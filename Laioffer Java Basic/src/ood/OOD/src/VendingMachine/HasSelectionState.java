package ood.OOD.src.VendingMachine;

import sun.management.snmp.jvminstr.JvmMemGCEntryImpl;

public class HasSelectionState extends AbstractState{
    public HasSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        vendingMachine.setSelectedItem(selection);
    }

    @Override
    public void insertMoney(int value) {
        vendingMachine.insertMoney(value);
        vendingMachine.changeToInsertedMoneyState();
    }

    @Override
    public void executeTransaction() {
        System.out.println("You need to insert money first.");
    }

    @Override
    public int cancelTransaction() {
        System.out.println("Transaction canceled.");
        vendingMachine.setSelectedItem(null);
        vendingMachine.changeToNoSelectionState();
        return 0;
    }

    @Override
    public String toString() {
        return "selected";
    }
}
