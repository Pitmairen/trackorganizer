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
}