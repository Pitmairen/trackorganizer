# -*- coding: utf-8 -*-
import urllib2
import urlparse
import re
import json
import os.path
import random
import sys

from collections import namedtuple

from BeautifulSoup import BeautifulSoup


BASE_URL = 'http://www.discogs.com'
_cd_re = re.compile(r'/.+?/release/\d+')



def run_request(url):

    req = urllib2.Request(url, headers={ 'User-Agent': 'Mozilla/5.0 (X11; Linux i686 on x86_64; rv:10.0) Gecko/20100101 Firefox/10.0' })

    return urllib2.urlopen(req).read()


def findall_cd_releases(content):

    return _cd_re.findall(content)



def download_from_cd_list(cd_list_url):

    try:
        content = run_request(cd_list_url)
    except urllib2.HTTPError as e:
        print e
        return

    releases = findall_cd_releases(content)
    releases = map(lambda rel: urlparse.urljoin(BASE_URL, rel), releases)

    cds = []

    for url in releases:

        try:
            cd = download_cd(url)
        except (ValueError, AttributeError) as e:
            print e
            continue

        if cd is not None:
            cds.append(cd)

    return cds




def download_cd(cd_url):

    try:
        content = run_request(cd_url)
    except urllib2.HTTPError as e:
        print e
        return


    parsed_html = BeautifulSoup(content)

    profile = parsed_html.body.find('div', attrs={'class':'profile'})

    artist = profile.find('span', attrs={'itemprop': 'name'}).get('title').strip()
    name = profile.findAll('span', attrs={'itemprop': 'name'})[1].string.strip()
    label = profile.find('div', attrs={'class': 'content'}).a.string.strip()

    year = profile.findAll('div', attrs={'class': 'content'})[3]
    if year.a is not None:
        try:
            year = int(year.a.string.strip())
        except ValueError:
            # Probably a string line "04 May 2015"
            year = int(year.a.string.split(" ")[-1])

    else:
        year = None


    playlist = parsed_html.body.find('table', attrs={'class':'playlist'})

    tracks = []
    for track in playlist.findAll("tr"):
        tracks.append(track.find("span", attrs={'class': 'tracklist_track_title'}).string)


    return dict(
        name=name,
        artist=artist,
        label=label,
        year=year,
        tracks=tracks
    )




def generate_java_source(cds, filename):

    # if os.path.exists(filename):
    #     print u"Output file already exists"
    #     return

    java_source = u"""
package backend;
import java.time.Duration;
import java.time.Year;

public class SampleData{{

    public void addCds(TrackOrganizer to){{
        CD cd;
        {0}
    }}
}}
"""

    add_cd_line = u"""
        cd = new CD("{title}", "{artist}", Year.of({year}), "{label}");
        {tracks}
        to.addMedia(cd);"""

    add_track_line = u"""\
        cd.addTrack(new MusicTrack("{title}", "{artist}", Duration.ofSeconds({duration})));"""

    lines = []

    for cd in cds:


        tracks = []

        for track in cd["tracks"]:

            tracks.append(add_track_line.format(
                title=track,
                artist=cd["artist"],
                duration=random.randint(150, 250)
                ))

        lines.append(add_cd_line.format(
            title=cd["name"],
            artist=cd["artist"],
            year=cd["year"] or random.randint(1950, 2015),
            label=cd["label"],
            tracks='\n'.join(tracks)
            ))



    source = java_source.format("\n".join(lines))

    with open(filename, "w") as f:

        f.write(source.encode("utf8"))





if __name__ == '__main__':


    with open("CD.db") as f:
        cds = json.loads(f.read())

    generate_java_source(cds, "SampleData.java")


    # if not os.path.exists("CD.db"):
    #
    #     cds = download_from_cd_list('http://www.discogs.com/search/?format_exact=CD')
    #     with open("CD.db", "w") as f:
    #
    #         f.write(json.dumps(cds))
    #
    # else:
    #     print "CD.db already exists"

