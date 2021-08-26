package ood.OOD.src.VendingMachine;

public class NoSelectionState extends AbstractState{

    public NoSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String selection) {
        vendingMachine.setSelectedItem(selection); // setter
        vendingMachine.changeToHasSelectionState();
    }

    @Override
    public void insertMoney(int value) {
        System.out.println("Please make a selection first");

    }

    @Override
    public void executeTransaction() {
        System.out.println("Please make a selection first");
    }

    @Override
    public int cancelTransaction() {
        System.out.println("Please make a selection first");
        return 0;
    }

    @Override
    public String toString() {
        return "NoSelection";
    }
}
