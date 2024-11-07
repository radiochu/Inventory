package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Provides methods for storing parts and products, and for modifying or returning
 * those objects once saved.
 */
public class Inventory {
    private static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     * Adds a new part from the Add Part screen to the allParts list.
     *
     * @param newPart The part from the Add Part screen to be added.
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     * Adds a new product from the Add Product screen to the allProducts list.
     *
     * @param newProduct The product from the Add Product screen to be added.
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Lookup part based on part ID.
     *
     * @param partID ID of the part to search for.
     * @return Part matching the given ID.
     */
    public static Part lookupPart(int partID) {
        for (Part p : allParts) {
            if (p.getId() == partID) {
                return p;
            }
        }
        return null;
    }

    /**
     * Lookup product based on product ID.
     *
     * @param productID ID of the product to search for.
     * @return Product matching the given ID.
     */
    public static Product lookupProduct(int productID) {
        for (Product p : allProducts) {
            if (p.getId() == productID) {
                return p;
            }
        }
        return null;
    }

    /**
     * Lookup part based on part name.
     *
     * @param partName Name of the part to search for.
     * @return Part matching the given name.
     */
    public static Part lookupPart(String partName) {
        for (Part p : allParts) {
            if (p.getName().equals(partName)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Lookup product based on product name.
     *
     * @param productName Name of the product to search for.
     * @return Product matching the given name.
     */
    public static Product lookupProduct(String productName) {
        for (Product p : allProducts) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Receives a selected part and its index from the modify part screen, and updates the part
     * at the appropriate index in allParts with the new information.
     *
     * @param index        The selected part's index in allParts.
     * @param selectedPart The selected part to update.
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * Receives a selected product and its index from the modify product screen, and updates the product
     * at the appropriate index in allProducts with the new information.
     *
     * @param index      The selected produt's index in allProducts.
     * @param newProduct The modified part to update.
     */
    public static void updateProduct(int index, Product newProduct) {
        allProducts.set(index, newProduct);
    }

    /**
     * Deletes the selected part from the allParts list.
     *
     * @param selectedPart The part selected for deletion.
     * @return Boolean returns true if part was successfully deleted.
     */
    public static boolean deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
        return true;
    }

    /**
     * Deletes the selected product from the allProducts list.
     *
     * @param product The product selected for deletion.
     * @return Boolean returns true if product was successfully deleted.
     */
    public static boolean deleteProduct(Product product) {
        allProducts.remove(product);
        return true;
    }


    /**
     * Gets list of all parts.
     *
     * @return allParts list.
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * Gets list of all products.
     *
     * @return allProducts list.
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}
