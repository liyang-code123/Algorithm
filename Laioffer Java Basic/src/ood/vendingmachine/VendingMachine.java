package ood.vendingmachine;

import java.util.List;

public interface VendingMachine {
    public int selectItemGetPrice(Item item);
    public void insertCoin(Coin coin);
    public Bucket<Item, List<Coin>> collectItemAndChange();
    public List<Coin> refund();
    public void reset();
}
