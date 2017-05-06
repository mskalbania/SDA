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

        temp = new StockItem("bottle of cola", 3.7, 5);
        stockList.addStock(temp);

        System.out.println(stockList);
        System.out.println("--------------------------------------------");
        Basket basket = new Basket("myBasket");
        basket.addToBasket(stockList.getItemFromStock("bottle of cola"), 2);
        basket.addToBasket(stockList.getItemFromStock("bottle of cola"), 3);
        basket.addToBasket(stockList.getItemFromStock("bottle of cola"), 10);
        basket.addToBasket(stockList.getItemFromStock("car"), 1);
        basket.addToBasket(stockList.getItemFromStock("car"), 1);// cant reserve more - cars in stock : 1
        System.out.println("Basket items: ");
        basket.showBasketList();
        System.out.println(stockList);

        basket.checkOut();

        basket.showBasketList();

        System.out.println(stockList);
        basket.addToBasket(stockList.getItemFromStock("bottle of cola"), 3);
        basket.addToBasket(stockList.getItemFromStock("bread"), 100);
        basket.addToBasket(stockList.getItemFromStock("cake"), 10);

        basket.removeFromBasket(stockList.getItemFromStock("cake"), 8);
        basket.showBasketList();
        basket.removeFromBasket(stockList.getItemFromStock("cake"), 5);
        basket.removeFromBasket(stockList.getItemFromStock("cake"), 1);
        basket.removeFromBasket(stockList.getItemFromStock("cake"), 1);
        basket.removeFromBasket(stockList.getItemFromStock("cake"), 1);
        basket.addToBasket(stockList.getItemFromStock("cake"), 5);
        basket.addToBasket(stockList.getItemFromStock("cake"), 10);
        basket.addToBasket(stockList.getItemFromStock("cake"), -10);
        basket.addToBasket(stockList.getItemFromStock("cake"), 5);

        basket.removeFromBasket(stockList.getItemFromStock("cake"), 9);
        basket.checkOut();
        basket.showBasketList();
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
