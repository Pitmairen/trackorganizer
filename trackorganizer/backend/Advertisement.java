package backend;

/**
 * Represents advertisement content.
 * 
 * @author Kristian Honningsvag
 * @version 0.1
 */

public class Advertisement extends Track
{
    // Instance variables
    private String company;
    private String product;

    /**
     * Constructor.
     * 
     * @param title Name of the commercial.
     * @param company Name of the company.
     * @param product Name of the product.
     */
    public Advertisement(String title, String company, String product)
    {
        super(title);
        this.company = company;
        this.product = product;
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