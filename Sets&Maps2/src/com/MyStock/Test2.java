package com.MyStock;

public class Test2 {
    public static void main(String[] args) {
        StockList shopStockList = new StockList();

        //adding positions to list
        shopStockList.addStock(new StockItem("water", 2.54));
        shopStockList.addStock(new StockItem("cola", 1.72));
        //adding quantity to positions
        shopStockList.getItemFromStock("water").adjustStock(10);
        shopStockList.getItemFromStock("cola").adjustStock(15);

        Basket basket = new Basket("Bs");

        //adding items to basket

        basket.addToBasket(shopStockList.getItemFromStock("water"), 5);
        basket.addToBasket(shopStockList.getItemFromStock("cola"), 15);
        basket.checkOut();

        basket.addToBasket(shopStockList.getItemFromStock("water"), 5);
        basket.checkOut();
        basket.showBasketList();

        System.out.println(shopStockList);
    }
}
