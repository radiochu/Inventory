package model;

/**
 * Class for In-House parts. Inherits from Part superclass.
 */
public class InHouse extends Part {
    /**
     * Machine ID value.
     */
    private int machineID;

    /**
     * Instantiates a new In-House part.
     *
     * @param id        Part ID
     * @param name      Part name
     * @param price     Part price
     * @param stock     Part amount in stock
     * @param min       Minimum parts allowed in stock
     * @param max       Maximum parts allowed in stock
     * @param machineID Machine ID for the part
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineID = machineID;
    }

    /**
     * Gets machine id.
     *
     * @return the machine id
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * Sets machine id.
     *
     * @param machineID the machine id
     */
    public void setMachineID(int machineID) {
        this.machineID = machineID;
    }
}
