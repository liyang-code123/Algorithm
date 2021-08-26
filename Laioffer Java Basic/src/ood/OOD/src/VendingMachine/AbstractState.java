package ood.OOD.src.VendingMachine;

public abstract class AbstractState implements State{
    protected VendingMachine vendingMachine;

    public AbstractState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
