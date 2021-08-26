package ood.OOD.src.VendingMachine;

public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

//        vm.selectItem("Coke");
//        vm.cancelTransaction();

        vm.selectItem("Coke");
        System.out.println(vm.printState());
        vm.addMoney(100);
        System.out.println(vm.cancelTransaction());
    }
}
