package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The Product class.
 */
public class Product {
    private final ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**
     * Instantiates a new Product.
     *
     * @param id    Product ID
     * @param name  Product name
     * @param price Product price
     * @param stock Product amount in stock
     * @param min   Minimum product allowed in stock
     * @param max   Maximum product allowed in stock.
     */
    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets min.
     *
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets min.
     *
     * @param min the min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets max.
     *
     * @param max the max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Add associated part.
     *
     * @param part the part
     */
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }

    /**
     * Delete associated part boolean.
     *
     * @param part the part
     * @return True if part was removed; false if not.
     */
    public boolean deleteAssociatedPart(Part part) {
        if (associatedParts.contains(part)) {
            associatedParts.remove(part);
            return true;
        }
        return false;
    }

    /**
     * Gets all associated parts.
     *
     * @return ObservableList of all associated parts.
     */
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

}
