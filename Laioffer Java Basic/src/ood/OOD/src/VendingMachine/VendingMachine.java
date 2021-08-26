package ood.OOD.src.VendingMachine;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
//    private List<Coin> coins;
//    private Map<ItemInfo, List<Item>> stock;  // coke: coke1, coke2, coke3

//    private ItemInfo currentSelection;
//    private List<Coin> currentCoins;
//    private Stock stock;

    private int currentInsertedMoney;
    private Map<String, Integer> itemPrice; // coke: iteminfo
    private AbstractState state;
    private String currentSelectedItem;
    private NoSelectionState noSelectionState;
    private HasSelectionState hasSelectionState;
    private InsertedMoneyState insertedMoneyState;


    public VendingMachine() {
        currentInsertedMoney = 0;
        currentSelectedItem = null;
        noSelectionState = new NoSelectionState(this);
        hasSelectionState = new HasSelectionState(this);
        insertedMoneyState = new InsertedMoneyState(this);
        state = noSelectionState;
        itemPrice = new HashMap<>();
        itemPrice.put("Coke", 199);
        itemPrice.put("Sprite", 299);
        itemPrice.put("MountainDew", 399);
    }


    // change states methods:
    public void changeToInsertedMoneyState() {
        state = insertedMoneyState;
    }

    public void changeToNoSelectionState() {
        state = noSelectionState;
    }

    public void changeToHasSelectionState() {
        state = hasSelectionState;
    }

    // getter and setter selectedItem

    public String getSelectedItem() {
        return currentSelectedItem;
    }

    public void setSelectedItem(String item) {
        this.currentSelectedItem = item;
    }

    public int getInsertedMoney() {
        return currentInsertedMoney;
    }

    public void emptyInsertedMoney() {
        this.currentInsertedMoney = 0;
    }

    public int getSalePrice() {
        if (currentSelectedItem == null) {
            System.out.println("Please make a selection before asking price");
            return 0;
        } else {
            return itemPrice.get(currentSelectedItem);
        }
    }

    // user case methods: selectItem, addMoney, executeTransection, cancelTransection;
    public void selectItem(String selection) {
        state.selectItem(selection);
    }

    public void addMoney(int value) {
        state.insertMoney(value);
    }

    public void insertMoney(int amount) {
        this.currentInsertedMoney += amount;
    }

    public void executeTransaction() {
        state.executeTransaction();
    }

    public int cancelTransaction() {
        return state.cancelTransaction();
    }

    public String printState() {
        String res = "";

        res = "Current selection is: " + currentSelectedItem + ", current inserted money: " + currentInsertedMoney
                + ", current state is : " + state;

        return res;
    }


}



//    public float selectItem(String selection) {
//        return 0;
//    }
//
//    public void insertCoins(List<Coin>coins) {
//
//    }
//
//    public Pair<Item, List<Coin>> executeTransaction() {
//        return null;
//    }
//
//    private List<Coin> refund() { // helper function uses private
//        return null;
//    }
//
//    public List<Coin> cancelTransaction() {
//        return null;
//    }

//    public void refillItems(List<Item> items) {
//        for(Item item: items) {
//            stock.add(item);
//        }
//    }

