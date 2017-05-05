package com.MyStock;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int quantityInStock() {
        return this.quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if((obj == null) || obj.getClass() != this.getClass()) {
            return false;
        }

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + 1;
    }

    @Override
    public int compareTo(StockItem stockItem) {
        if(this == stockItem){
            return 0;
        }
        if(stockItem != null){
            return this.name.compareTo(stockItem.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString(){
        return this.name + " | Price: " + this.price + " | Quantity: " + this.quantityStock;
    }
}
