package com.MyStock;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem stockItem) {
        if (stockItem != null) {
            //check if we got on in stock already
            StockItem inStock = list.getOrDefault(stockItem.getName(), stockItem);
            //if yes adjusting quantity
            if (inStock != stockItem) {
                stockItem.adjustStock(inStock.quantityInStock());
            }
            //either way putting object to map
            list.put(stockItem.getName(), stockItem);
            return stockItem.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String stockItem, int quantity) {
        StockItem inStock = list.get(stockItem);
        //checking if item exist in stock and quantity is correct
        if ((inStock != null) && (quantity > 0) && (inStock.quantityInStock() >= quantity)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem getItemFromStock(String itemName){
        return list.get(itemName);
    }

    public Map<String, StockItem> getAllItemsFromStock(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString(){
        String s = "\n Stock list\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%2f",itemValue) +"\n";

            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}


