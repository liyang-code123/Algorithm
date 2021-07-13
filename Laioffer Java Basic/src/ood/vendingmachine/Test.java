package ood.vendingmachine;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        VendingMachineImpl test = new VendingMachineImpl();
        int price = test.selectItemGetPrice(Item.COKE);
        System.out.println("Price of COKE: " + price);
        test.insertCoin(Coin.QUARTER);
        Bucket<Item, List<Coin>> bucket = test.collectItemAndChange();
        System.out.println("[return]" + bucket.first + bucket.second);

        test.selectItemGetPrice(Item.PEPSI);
        test.insertCoin(Coin.QUARTER);
        bucket = test.collectItemAndChange();
        System.out.println("[return]" + bucket.first + bucket.second);

        test.printStats();
    }
}
