package com.MyStock;

public class Run {
    private static StockList stockList = new StockList();


    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.07, 10);
        stockList.addStock(temp);

        temp = new StockItem("cookie", 1.87, 15);
        stockList.addStock(temp);

        temp = new StockItem("tomato", 2.91, 35);
        stockList.addStock(temp);

        temp = new StockItem("tomato", 2.91, 22);
        stockList.addStock(temp);

        temp = new StockItem("lettuce", 0.55, 13);
        stockList.addStock(temp);

        temp = new StockItem("car", 20.0, 1);
        stockList.addStock(temp);

        temp = new StockItem("bottle of water", 2.14, 300);
        stockList.addStock(temp);

        temp = new StockItem("bottle of cola", 3.7, 45);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket = new Basket("myBasket");
        sellItem(basket,"car",1);
        System.out.println(basket);
        sellItem(basket,"bottle of cola", 4);
        System.out.println(basket);
        sellItem(basket,"bottle of water", 50);
        System.out.println(basket);
        sellItem(basket,"someString",3);
        System.out.println(basket);

        stockList.getAllItemsFromStock().get("car").adjustStock(2000);
        System.out.println(stockList);

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getItemFromStock(item);

        if (stockItem == null) {
            System.out.println("We do not have " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
