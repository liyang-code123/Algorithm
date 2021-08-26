import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    Map<Item, Integer> itemInventory = new HashMap<>();
    Map<Coin, Integer> cashInventory = new HashMap<>();
    boolean on;
    Item currentItem = null;
    int currentBalance = 0;

    public VendingMachine(){
        init();
    }

    private void init(){
        for(Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }
        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }
    }

    public void powerButton() {
        on = !on;
    }

    public boolean isOn() {

        return on;
    }

    int selectItemGetPrice(Item item) throws SoldOutException {
        Integer quantity = itemInventory.get(item);
        if (quantity == 0 || quantity == null) {
            throw new SoldOutException("Item sold out.");
        }
        currentItem = item;
        return item.price;
    }

    int insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.denomination;
        cashInventory.put(coin, cashInventory.getOrDefault(coin, 0) + 1);
        return currentBalance;
    }

    void setItemInventory(Item item, int quantity) throws IllegalArgumentException {
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative.");
        }
        itemInventory.put(item, quantity);
    }

    void setCashInventory(Coin coin, int quantity) throws IllegalArgumentException {
        if(quantity < 0) {
            throw new IllegalArgumentException("quantity can't be negative.");
        }
        cashInventory.put(coin, quantity);
    }

    int getItemInventory(Item item) {
        return itemInventory.get(item);
    }

    int getCashInventory(Coin coin) {
        return cashInventory.get(coin);
    }

    Pair<Item, Map<Coin, Integer>> collectItemAndChange() throws NotSufficientCoinException, NotFullyPaidException {
        if (currentBalance < currentItem.price) {
            throw new NotFullyPaidException("please add additional : " + (currentItem.price - currentBalance));
        }

        int change = currentBalance - currentItem.price;
        Map<Coin, Integer> changes = new HashMap<>();
        while (change > 0) {
            if (change >= Coin.QUARTER.denomination
                    && cashInventory.getOrDefault(Coin.QUARTER, 0) > changes.getOrDefault(Coin.QUARTER, 0) + 1) {
                changes.put(Coin.QUARTER, changes.getOrDefault(Coin.QUARTER, 0) + 1);
                change -= Coin.QUARTER.denomination;
            } else if (change >= Coin.DIME.denomination
                    && cashInventory.getOrDefault(Coin.DIME, 0) > changes.getOrDefault(Coin.DIME, 0) + 1) {
                changes.put(Coin.DIME, changes.getOrDefault(Coin.DIME, 0) + 1);
                change -= Coin.DIME.denomination;
            } else if (change >= Coin.NICKEL.denomination
                    && cashInventory.getOrDefault(Coin.NICKEL, 0) > changes.getOrDefault(Coin.NICKEL, 0) + 1) {
                changes.put(Coin.NICKEL, changes.getOrDefault(Coin.NICKEL, 0) + 1);
                change -= Coin.NICKEL.denomination;
            } else if (change >= Coin.PENNY.denomination
                    && cashInventory.getOrDefault(Coin.PENNY, 0) > changes.getOrDefault(Coin.PENNY, 0) + 1) {
                changes.put(Coin.PENNY, changes.getOrDefault(Coin.PENNY, 0) + 1);
                change -= Coin.PENNY.denomination;
            } else {
                throw new NotSufficientCoinException("No changes to return.");
            }
        }

        for(Coin c : changes.keySet()) {
            cashInventory.put(c, cashInventory.get(c) - changes.get(c));
        }

        itemInventory.put(currentItem, itemInventory.get(currentItem) - 1);
        Item item = currentItem;
        currentItem = null;
        currentBalance = 0;
        return new Pair<>(item, changes);
    }

    Map<Coin, Integer> refund() throws NotSufficientCoinException {
        int change = currentBalance;
        Map<Coin, Integer> changes = new HashMap<>();
        while (change > 0) {
            if (change >= Coin.QUARTER.denomination
                    && cashInventory.getOrDefault(Coin.QUARTER, 0) > changes.getOrDefault(Coin.QUARTER, 0) + 1) {
                changes.put(Coin.QUARTER, changes.getOrDefault(Coin.QUARTER, 0) + 1);
                change -= Coin.QUARTER.denomination;
            } else if (change >= Coin.DIME.denomination
                    && cashInventory.getOrDefault(Coin.DIME, 0) > changes.getOrDefault(Coin.DIME, 0) + 1) {
                changes.put(Coin.DIME, changes.getOrDefault(Coin.DIME, 0) + 1);
                change -= Coin.DIME.denomination;
            } else if (change >= Coin.NICKEL.denomination
                    && cashInventory.getOrDefault(Coin.NICKEL, 0) > changes.getOrDefault(Coin.NICKEL, 0) + 1) {
                changes.put(Coin.NICKEL, changes.getOrDefault(Coin.NICKEL, 0) + 1);
                change -= Coin.NICKEL.denomination;
            } else if (change >= Coin.PENNY.denomination
                    && cashInventory.getOrDefault(Coin.PENNY, 0) > changes.getOrDefault(Coin.PENNY, 0) + 1) {
                changes.put(Coin.PENNY, changes.getOrDefault(Coin.PENNY, 0) + 1);
                change -= Coin.PENNY.denomination;
            } else {
                throw new NotSufficientCoinException("No changes to return.");
            }
        }
        return changes;
    }

}
