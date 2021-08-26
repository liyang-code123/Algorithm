public enum Item {
    COKE("Coke", 24),
    PEPSI("Pepsi", 26),
    SODA("Soda", 60);

    String name;
    int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
