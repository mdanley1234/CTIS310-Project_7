package edu.guilford;

/**
 * Represents a data point with a string element and an associated quantity.
 * Implements Comparable to allow sorting based on quantity in descending order.
 */
public class DataPoint implements Comparable<DataPoint> {
    
    private String stringElement;
    private int quantity;

    /**
     * Constructs a DataPoint with the given string element and initializes quantity to 1.
     * 
     * @param stringElement the string element associated with this data point
     */
    public DataPoint(String stringElement) {
        this.stringElement = stringElement;
        this.quantity = 1;
    }

    /**
     * Increments the quantity of this data point by 1.
     */
    public void incrementQuantity() {
        quantity++;
    }

    /**
     * Returns a string representation of this data point.
     * 
     * @return a string containing the string element and its quantity
     */
    @Override
    public String toString() {
        return stringElement + " " + quantity;
    }

    /**
     * Gets the quantity of this data point.
     * 
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the string element of this data point.
     * 
     * @return the string element
     */
    public String getStringElement() {
        return stringElement;
    }

    /**
     * Compares this data point with another based on quantity in descending order.
     * 
     * @param o the other DataPoint to compare with
     * @return a negative integer, zero, or a positive integer as this object
     *         has greater, equal, or lesser quantity than the specified object
     */
    @Override
    public int compareTo(DataPoint o) {
        return Integer.compare(o.quantity, this.quantity);
    }
}