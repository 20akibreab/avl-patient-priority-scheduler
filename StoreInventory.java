public class StoreInventory {

    private class node {
        int itemId;
        String name;
        node left;
        node right;

        node(int itemId, String name) {
            this.itemId = itemId;
            this.name = name;
        }
    }

    private node root;

    public void addItem(int itemId, String name) {
        root = add(root, itemId, name);
    }

    private node add(node n, int itemId, String name) {
        if (n == null)
            return new node(itemId, name);

        if (itemId < n.itemId)
            n.left = add(n.left, itemId, name);
        else if (itemId > n.itemId)
            n.right = add(n.right, itemId, name);
        // duplicate id, so just leave it alone

        return n;
    }

    public boolean hasItem(int itemId) {
        node cur = root;

        while (cur != null) {
            if (itemId == cur.itemId)
                return true;
            else if (itemId < cur.itemId)
                cur = cur.left;
            else
                cur = cur.right;
        }

        return false;
    }

    public String getItemName(int itemId) {
        node cur = root;

        while (cur != null) {
            if (itemId == cur.itemId)
                return cur.name;
            else if (itemId < cur.itemId)
                cur = cur.left;
            else
                cur = cur.right;
        }

        return "Item not found";
    }

    public void printInventory() {
        printInOrder(root);
    }

    private void printInOrder(node n) {
        if (n == null)
            return;

        printInOrder(n.left);
        System.out.println("Item ID: " + n.itemId + ", Name: " + n.name);
        printInOrder(n.right);
    }
}
