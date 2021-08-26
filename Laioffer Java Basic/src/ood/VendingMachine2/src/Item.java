package ood.VendingMachine2.src;

public enum Item {
    COKE("Coke", 24),
    PEPSI("Pepsi", 24),
    SODA("Soda", 45);

    private final String name;
    private final int price;

    private Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
