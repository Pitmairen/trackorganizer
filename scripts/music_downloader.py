# -*- coding: utf-8 -*-
import urllib2
import urlparse
import re
import json
import os.path

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




if __name__ == '__main__':




    if not os.path.exists("CD.db"):

        cds = download_from_cd_list('http://www.discogs.com/search/?format_exact=CD')
        with open("CD.db", "w") as f:

            f.write(json.dumps(cds))

    else:
        print "CD.db already exists"

