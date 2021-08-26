package ood.OOD.src.VendingMachine;

// user case ---> all the actions/behavior ---> state.
public interface State {
    void selectItem(String selection);
    void insertMoney(int value);
    void executeTransaction();
    int cancelTransaction();
    String toString();
}
