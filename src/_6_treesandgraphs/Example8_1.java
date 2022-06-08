package _6_treesandgraphs;

// Question: Find the common ancestor of two tree nodes
//
// Example: Nodes could belong to a different tree, and have no common ancestor
// Example: Nodes could belong to the same tree, in which case they should have a common ancestor
//
// find the depth of each node
// move the node at deeper depth to the same depth as the shallow node
// until node1 != node2 && node2 != null && node1 != null
//     node1 = node1.parent
//     node2 = node2.parent
//
// return node1 == null || node2 == null ? return null: node1
//
//Complexity: O(d)
//Complexity: O(d)
import _6_treesandgraphs.datastructures.Tree;

public class Example8_1 {
    private static Tree.Node commonAncestor(Tree.Node node1, Tree.Node node2) {
        int depth1 = depth(node1);
        int depth2 = depth(node2);
        Tree.Node first = depth1 < depth2 ? node1 : node2;
        Tree.Node second = depth1 >= depth2 ? node1 : node2;

        second = goUp(second, Math.abs(depth1 - depth2));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    private static Tree.Node goUp(Tree.Node node, int steps) {
        for (int i = 0; i < steps; i++) {
            if (node == null) {
                return null;
            }
            node = node.parent;
        }
        return node;
    }

    private static int depth(Tree.Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(3);
        Tree.Node node0 = tree.new Node<Integer>(0);
        Tree.Node node1 = tree.new Node<Integer>(1);
        Tree.Node node2 = tree.new Node<Integer>(2);
        Tree.Node node3 = tree.new Node<Integer>(3);
        Tree.Node node4 = tree.new Node<Integer>(4);
        Tree.Node node5 = tree.new Node<Integer>(5);
        Tree.Node node6 = tree.new Node<Integer>(6);
        Tree.Node node7 = tree.new Node<Integer>(7);
        Tree.Node node8 = tree.new Node<Integer>(8);

        node0.children[0] = node1;
        node0.children[1] = node2;
        node0.children[2] = node3;
        node1.parent = node0;
        node2.parent = node0;
        node3.parent = node0;

        node1.children[0] = node4;
        node1.children[1] = node5;
        node1.children[2] = node6;
        node4.parent = node1;
        node5.parent = node1;
        node6.parent = node1;

        node4.children[0] = node7;
        node4.children[1] = node8;
        node7.parent = node4;
        node8.parent = node4;

        Tree.Node commonAncestor = commonAncestor(node8, node6);
        System.out.println("Common ancestor " + commonAncestor);
    }
}
