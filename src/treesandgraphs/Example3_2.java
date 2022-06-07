package treesandgraphs;

import arraysandstrings.datastructures.ArrayList;
import linkedlists.datastructures.LinkedList;
import treesandgraphs.datastructures.BinaryTree;

//Given a binary tree, return a list of linked lists for every depth. Each linked list contains the elements at a certain depth.
//Bruteforce:
//Use BFS
//list<linkedlist<treenode>> createLevelLinkedList(binarytreenode root)
//  list<linkedlist<treenode>> list = new arraylist<linkedlist<treenode>>
//  Initially level = new list
//  level.add(root)
//  Until level.size() > 0
//      levellist.add(level)
//      parents = level
//      level = new list
//      for every parent, add child to level
public class Example3_2 {
    private static ArrayList<LinkedList<BinaryTree.Node<Integer>>> createLevelLinkedList(
            BinaryTree<Integer> binaryTree) {
        ArrayList<LinkedList<BinaryTree.Node<Integer>>> list = new ArrayList<>();

        LinkedList<BinaryTree.Node<Integer>> levelList = new LinkedList<>();
        levelList.addLast(binaryTree.root);

        while (levelList.size() > 0) {
            list.add(levelList);
            LinkedList<BinaryTree.Node<Integer>> parents = levelList;
            levelList = new LinkedList<>();

            LinkedList.Node<BinaryTree.Node<Integer>> parentNode = parents.head;
            while (parentNode != null) {
                if (parentNode.data.left != null) {
                    levelList.addLast(parentNode.data.left);
                }
                if (parentNode.data.right != null) {
                    levelList.addLast(parentNode.data.right);
                }
                parentNode = parentNode.next;
            }
        }
        return list;
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