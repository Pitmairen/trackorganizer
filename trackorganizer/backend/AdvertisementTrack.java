package backend;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Represents advertisement content.
 */

public class AdvertisementTrack extends Track
{
    // Instance variables
    private String company;
    private String product;

    /**
     * Constructor.
     * 
     * @param title Title of the track.
     * @param duration Duration of the track.
     * @param company Name of the company.
     * @param product Name of the product.
     */
    public AdvertisementTrack(String title, Duration duration, String company, String product)
    {
        super(title, duration);
        this.company = company;
        this.product = product;
    }
    
    
    /**
     * Returns a description of the track
     *
     * @return A description of the track.
     */
    @Override
    public String getDescriptionString(){
        return getDescription() + ": "+ 
            DurationHandler.durationToString(getDuration());
    }
    
    
    
    /**
     * Returns a description of the track
     *
     * @return A description of the track.
     */
    public String getDescription(){
        return getCompany() + " - " + getProduct() + ": " + getTitle();
    }
    
    
    /**
     * Returns the name of the company.
     * 
     * @return Company name.
     */
    public String getCompany()
    {
        return company;
    }

    /**
     * Sets the name of company.
     * 
     * @param company Name of the company.
     */
    public void setCompany(String company)
    {
        this.company = company;
    }
    
    /**
     * Returns the name of the product.
     * 
     * @return Product name.
     */
    public String getProduct()
    {
        return product;
    }

    /**
     * Sets the name of product.
     * 
     * @param product Name of the product.
     */
    public void setProduct(String product)
    {
        this.product = product;
    }
}