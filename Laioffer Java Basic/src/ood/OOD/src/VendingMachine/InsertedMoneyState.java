package ood.OOD.src.VendingMachine;

public class InsertedMoneyState extends AbstractState{
    public InsertedMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        System.out.println("Already has a selection, please cancel transaction to make a new selection");

    }

    @Override
    public void insertMoney(int value) {

        vendingMachine.insertMoney(value); // you can continue to insert money.
    }

    @Override
    public void executeTransaction() {

        int diff = vendingMachine.getInsertedMoney() - vendingMachine.getSalePrice();
        if(diff >= 0){
            System.out.println("Executing transaction, will return you : " + diff + " money and item: " + vendingMachine.getSelectedItem());
            vendingMachine.setSelectedItem(null);
            vendingMachine.emptyInsertedMoney();
            vendingMachine.changeToNoSelectionState();
        }
        else{
            System.out.println("Not enough money, please insert " + (-diff) + " more.");
        }
    }

    @Override
    public int cancelTransaction() {
        int insertedMoney = vendingMachine.getInsertedMoney();
        vendingMachine.setSelectedItem(null);
        vendingMachine.emptyInsertedMoney();
        vendingMachine.changeToNoSelectionState();
        return insertedMoney;
    }

    @Override
    public String toString() {
        return "inserted Money";
    }
}
