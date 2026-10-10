public class PatientScheduler {

    private class node {
        int priority;
        String name;
        int height;
        node left;
        node right;

        node(int priority, String name) {
            this.priority = priority;
            this.name = name;
            height = 1;
        }
    }

    private node root;

    public void addPatient(int priority, String name) {
        root = add(root, priority, name);
    }

    private node add(node n, int priority, String name) {
        if (n == null)
            return new node(priority, name);

        if (priority < n.priority)
            n.left = add(n.left, priority, name);
        else if (priority > n.priority)
            n.right = add(n.right, priority, name);
        else
            return n; // already have this priority

        updateHeight(n);
        return balance(n);
    }

    public void removePatient(int priority) {
        root = remove(root, priority);
    }

    private node remove(node n, int priority) {
        if (n == null)
            return null;

        if (priority < n.priority) {
            n.left = remove(n.left, priority);
        } else if (priority > n.priority) {
            n.right = remove(n.right, priority);
        } else {
            // found the patient
            if (n.left == null)
                return n.right;
            if (n.right == null)
                return n.left;

            // two kids, use the next smallest one
            node next = findSmallest(n.right);
            n.priority = next.priority;
            n.name = next.name;
            n.right = remove(n.right, next.priority);
        }

        updateHeight(n);
        return balance(n);
    }

    public String getHighestPriorityPatient() {
        if (root == null)
            return "No patients";

        return findSmallest(root).name;
    }

    private node findSmallest(node n) {
        while (n.left != null)
            n = n.left;

        return n;
    }

    public void printSchedule() {
        printInOrder(root);
    }

    private void printInOrder(node n) {
        if (n == null)
            return;

        printInOrder(n.left);
        System.out.println("Priority: " + n.priority + ", Name: " + n.name);
        printInOrder(n.right);
    }

    private int getHeight(node n) {
        if (n == null)
            return 0;

        return n.height;
    }

    private void updateHeight(node n) {
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    private int getBalance(node n) {
        if (n == null)
            return 0;

        return getHeight(n.left) - getHeight(n.right);
    }

    // fix the tree if one side gets too heavy
    private node balance(node n) {
        int bal = getBalance(n);

        if (bal > 1) {
            if (getBalance(n.left) < 0)
                n.left = rotateLeft(n.left);

            return rotateRight(n);
        }

        if (bal < -1) {
            if (getBalance(n.right) > 0)
                n.right = rotateRight(n.right);

            return rotateLeft(n);
        }

        return n;
    }

    private node rotateRight(node n) {
        node newTop = n.left;
        node middle = newTop.right;

        newTop.right = n;
        n.left = middle;

        updateHeight(n);
        updateHeight(newTop);

        return newTop;
    }

    private node rotateLeft(node n) {
        node newTop = n.right;
        node middle = newTop.left;

        newTop.left = n;
        n.right = middle;

        updateHeight(n);
        updateHeight(newTop);

        return newTop;
    }
}
