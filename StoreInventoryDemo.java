public class StoreInventoryDemo {
    public static void main(String[] args) {
        StoreInventory store = new StoreInventory();

        store.addItem(30, "Keyboard");
        store.addItem(10, "Mouse");
        store.addItem(50, "Monitor");
        store.addItem(20, "Headphones");
        store.addItem(40, "Webcam");

        System.out.println("Inventory:");
        store.printInventory();

        System.out.println();
        System.out.println("Has item 20: " + store.hasItem(20));
        System.out.println("Has item 70: " + store.hasItem(70));
        System.out.println("Item 50 name: " + store.getItemName(50));
        System.out.println("Item 70 name: " + store.getItemName(70));
    }
}
