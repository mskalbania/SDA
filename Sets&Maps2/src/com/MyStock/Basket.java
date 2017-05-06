package com.MyStock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> basketItems;

    public Basket(String name) {
        this.name = name;
        this.basketItems = new TreeMap<>();
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = basketItems.getOrDefault(item, 0);
            int newQuantity = item.unreserveItem(quantity);
            if (newQuantity > 0) {
                basketItems.put(item, inBasket - quantity);
            }else if(newQuantity == 0){
                basketItems.remove(item);
            }
            return inBasket;
        }
        return 0;
    }


    public int addToBasket(StockItem item, int quantity) {

        if ((item != null) && (quantity > 0)) {
            int inBasket = basketItems.getOrDefault(item, 0);
            if (item.reserveItem(quantity) >= 0) {
                basketItems.put(item, inBasket + quantity);
            }
            return inBasket;
        }
        return -1;
    }

    public boolean checkOut() {
        System.out.println("Buying items existing in basket...");
        if (!basketItems.isEmpty()) {
            for (Map.Entry<StockItem, Integer> item : basketItems.entrySet()) {
                System.out.println(item.getKey().getName() + " bought, " + item.getValue());
                item.getKey().adjustStock(-item.getValue());//removing items from stock
                item.getKey().unreserveItem(item.getValue());
            }
            basketItems.clear();
            return true;
        }
        return false;
    }

    public void showBasketList() {
        System.out.println("Basket list: ");
        if (basketItems.isEmpty()) {
            System.out.println("Basket is empty!");
        } else {
            for (Map.Entry<StockItem, Integer> item : basketItems.entrySet()) {
                System.out.println(item.getKey().getName() + " " + item.getValue());
            }
        }
    }

    public Map<StockItem, Integer> getBasketItems() {
        return Collections.unmodifiableMap(basketItems);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains + " + basketItems.size() + " items\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item : basketItems.entrySet()) {
            s = s + item.getKey().getName() + " - " + item.getValue() + " purchased.\n";
            totalCost = item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + totalCost;

    }
}
