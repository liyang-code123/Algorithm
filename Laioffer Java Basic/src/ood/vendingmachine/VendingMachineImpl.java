package ood.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine{
    private Inventory<Coin> cashInventory = new Inventory<>();
    private Inventory<Item> itemInventory = new Inventory<>();
    private int totalSales;
    private Item currentItem;
    private int currentBalance;

    public VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        for (Coin c : Coin.values()){
            cashInventory.put(c, 5);
        }

        for (Item i : Item.values()){
            itemInventory.put(i, 5);
        }
    }

    @Override
    public int selectItemGetPrice(Item item) {
        if (itemInventory.hasItem(item)) {
            currentItem = item;
            return currentItem.getPrice();
        } else {
            throw new SoldOutException("Sold Out, Please choose another item.");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
            currentBalance = currentBalance + coin.getDenomination();
            cashInventory.add(coin);
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();

        List<Coin> change = collectChange();
        return new Bucket<Item, List<Coin>>(item, change);
    }

    private Item collectItem() throws NotSufficientCoinException, NotFullyPaidException{
        if(isFullyPaid()) {
            if(hasSufficientChange()){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientCoinException("Not Sufficient change in Inventory.");
        }
        int remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullyPaidException("Price not fully paid, remaining: ", remainingBalance);
    }

    private boolean isFullyPaid() {
        if (currentBalance >= currentItem.getPrice()){
            return true;
        }
        return false;
    }

    private List<Coin> collectChange(){
        int changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(int amount) {
        boolean hasChange = true;
        try{
            getChange(amount);
        } catch (NotSufficientCoinException err) {
            return hasChange = false;
        }
        return hasChange;
    }

    private List<Coin> getChange(int amount) throws NotSufficientCoinException {
        List<Coin> changes = new ArrayList<>();
        if (amount > 0) {
            int balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)){
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();
                    continue;
                } else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                } else if (balance >= Coin.NICKEL.getDenomination() && cashInventory.hasItem(Coin.NICKEL)){
                    changes.add(Coin.NICKEL);
                    balance = balance - Coin.NICKEL.getDenomination();
                } else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                } else {
                    throw new NotSufficientCoinException("Not Sufficient Changes. Please try another item.");
                }
            }
        }
        return changes;
    }

    @Override
    public List<Coin> refund(){
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    private void updateCashInventory(List<Coin> change){
        for(Coin c : change) {
            cashInventory.deduct(c);
        }
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    public void printStats(){
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current Item Inventory : " + "Coke: " + itemInventory.getQuantity(Item.COKE)
                + "; Pepsi : " + itemInventory.getQuantity(Item.PEPSI)
                + "; Soda : " + itemInventory.getQuantity(Item.SODA));
        System.out.println("Current Cash Inventory : " + "Quarter : " + cashInventory.getQuantity(Coin.QUARTER)
                + "; Dime : " + cashInventory.getQuantity(Coin.DIME)
                + "; Nickel : " + cashInventory.getQuantity(Coin.NICKEL)
                + "; Penny : " + cashInventory.getQuantity(Coin.PENNY));
    }
}
