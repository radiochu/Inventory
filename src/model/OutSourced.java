package model;

/**
 * Class for Outsourced parts. Inherits from Part superclass.
 */
public class OutSourced extends Part {
    /**
     * Company Name value.
     */
    private String companyName;

    /**
     * Instantiates a new Outsourced part.
     *
     * @param id          Part id
     * @param name        Part name
     * @param price       Part price
     * @param stock       Part amount in stock
     * @param min         Minimum parts allowed in stock
     * @param max         Maximum parts allowed in stock
     * @param companyName Company name
     */
    public OutSourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     * Gets company name.
     *
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name.
     *
     * @param companyName the company name
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
