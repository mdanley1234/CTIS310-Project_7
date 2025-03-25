package edu.guilford;

// Analytics data point
public class DataPoint implements Comparable<DataPoint>{
    private String stringElement;
    private int quantity = 0; 

    public DataPoint(String stringElement) {
        this.stringElement = stringElement;
        quantity = 1;
    }

    public void incrementQuantity() {
        quantity++;
    }

    @Override
    public String toString() {
        return stringElement + " " + quantity;
    }

    // Getters
    public int getQuantity() {
        return quantity;
    }

    public String getStringElement() {
        return stringElement;
    }

    @Override
    public int compareTo(DataPoint o) {
        return Integer.compare(o.quantity, this.quantity);
    }

}
