package treesandgraphs;

//Given a binary tree, return a list of linked lists for every depth. Each linked list contains the elements at a certain depth.
//Bruteforce:
//Traverse the tree through preorder traversal and pass along the level to construct such a desired DS
//
//list<linkedlist<treenode>> createLevelLinkedList(binarytreenode root)
//  list<linkedlist<treenode>> list = new arraylist<linkedlist<treenode>>
//  createLevelLinkedList(root, list, 0)
//void createLevelLinkedList(binarytreenode node, list<linkedlist<treenode>> list, int level)
//  if (level == list.size())
//      linkedlist<treenode> levellist = new linkedlist<treenode>();
//  else
//      linkedlist<treenode> levellist = list.get(level)
//  levellist.add(node)
//  createLevelLinkedList(node.left, list, level + 1)
//  createLevelLinkedList(node.right, list, level + 1)
//  Space complexity: O(log n), Time complexity: O(n)
import arraysandstrings.datastructures.ArrayList;
import linkedlists.datastructures.LinkedList;
import treesandgraphs.datastructures.BinaryTree;

public class Example3_1 {
    private static ArrayList<LinkedList<BinaryTree.Node<Integer>>> createLevelLinkedList(
            BinaryTree<Integer> binaryTree) {
        ArrayList<LinkedList<BinaryTree.Node<Integer>>> list = new ArrayList<>();
        createLevelLinkedList(binaryTree.root, list, 0);
        return list;
    }

    private static void createLevelLinkedList(BinaryTree.Node<Integer> node,
            ArrayList<LinkedList<BinaryTree.Node<Integer>>> list, int level) {
        if (node == null) {
            return;
        }

        LinkedList<BinaryTree.Node<Integer>> levelList;
        if (level == list.size()) {
            levelList = new LinkedList<>();
            list.add(levelList);
        } else {
            levelList = list.get(level);
        }
        levelList.addLast(node);
        createLevelLinkedList(node.left, list, level + 1);
        createLevelLinkedList(node.right, list, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(1);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(2);
        node.left = subNode;
        subNode.parent = node;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        subNode.parent = node;

        binaryTree.root = node;

        ArrayList<LinkedList<BinaryTree.Node<Integer>>> levelLinkedLists = createLevelLinkedList(binaryTree);
        for (int i = 0; i < levelLinkedLists.size(); i++) {
            System.out.println(levelLinkedLists.get(i).string());
        }
    }
}
