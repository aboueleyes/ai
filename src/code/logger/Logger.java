package code.logger;

import code.Node;

public class Logger {

    public Logger() {
    }

    public static void logTree(Node node) {
        Node current = node;
        StringBuilder tree = new StringBuilder();
        while (current.getParent() != null) {
            tree.insert(0, current.getState() + "\n");
            tree.insert(0, "|\nv\n");
            tree.insert(0, current.getLeadingActionType() + "\n");
            tree.insert(0, "|\n");
            current = current.getParent();
        }
        tree.insert(0, current.getState() + "\n");
        System.out.println(tree);
    }
}
