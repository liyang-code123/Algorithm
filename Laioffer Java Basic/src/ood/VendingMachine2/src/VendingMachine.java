package ood.VendingMachine2.src;

import java.util.List;

public interface VendingMachine {

    int insertCoin(Coin coin);
    void setItemInventory(Item item, int quantity) throws IllegalArgumentException;
    int getItemInventory(Item item);

    int selectItemGetPrice(Item item) throws SoldOutException;
    Pair<Item, List<Coin>> collectItemAndChange() throws NotSufficientCoinException, NotFullyPaidException;

    List<Coin> refund() throws NotSufficientCoinException;

    void reset();

}
