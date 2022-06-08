package treesandgraphs;

import arraysandstrings.datastructures.ArrayList;
import linkedlists.datastructures.LinkedList;
import treesandgraphs.datastructures.BinaryTree;

//An array is traversed from left to right to create a BST
//Given a BST, determine all possible arrays that could generate the BST
//
//As we iterate through the array, the first element would be placed at the root
//The second or third either the left or right side of the root
//
//What is the meaning of the order of weaving?
//[10, 5, 15], [25]
//--> [5, 15], [25], [10]
//	--> [15], [25], [10, 5]
//		--> [], [25], [10, 5, 15] --> [10, 5, 15, 25]
//		--> [15], [], [10, 5, 25] --> [10, 5, 25, 15]
//	--> [5, 15], [], [10, 25] --> [10, 25, 5, 15]
//--> [10, 5, 15], [], [25] --> [25, 10, 5, 15]
//
//[10, 15, 5], [25]
//--> [15, 5], [25], [10]
//        --> [5], [25], [10, 15]
//        --> [], [25], [10, 15, 5] --> [10, 15, 5, 25]
//        --> [5], [], [10, 15, 25] --> [10, 15, 25, 5]
//        --> [15, 5], [], [10, 25] --> [10, 25, 15, 5]
//        --> [10, 15, 5], [], [25] --> [25, 10, 15, 5]
//All the above combinations when prefixed with 20, generate the same BST
//How to weave the arrays used to generate the left subtree with the arrays used to generate the right subtree?
//Weave [a, b, c], [d, e, f] --> add [a] as prefix to weaves of [b, c] and [d, e, f],
// add [d] as prefix to weaves of [a, b, c] and [e, f]
//Weave elements while maintaining the relative order
//
public class Example9_1 {
    private static ArrayList<LinkedList<Integer>> allSequences(BinaryTree.Node<Integer> node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            LinkedList<Integer> emptyList = new LinkedList<>();
            result.add(emptyList);
            return result;
        }

        ArrayList<LinkedList<Integer>> leftSequences = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSequences = allSequences(node.right);

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.addLast(node.data);

        ArrayList<LinkedList<Integer>> weaveResult;
        for (int i = 0; i < leftSequences.size(); i++) {
            for (int j = 0; j < rightSequences.size(); j++) {
                weaveResult = new ArrayList<>();
                weave(leftSequences.get(i), rightSequences.get(i), weaveResult, prefix);
                result.addAll(weaveResult);
            }
        }

        return result;
    }

    private static void weave(LinkedList<Integer> leftSequence, LinkedList<Integer> rightSequence,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (leftSequence.size() == 0 || rightSequence.size() == 0) {
            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(prefix);
            list.addAll(leftSequence);
            list.addAll(rightSequence);
            results.add(list);
            return;
        }

        LinkedList.Node<Integer> first = leftSequence.removeFront();
        prefix.addLast(first.data);
        weave(leftSequence, rightSequence, results, prefix);
        prefix.removeLast();
        leftSequence.addFront(first);

        first = rightSequence.removeFront();
        prefix.addLast(first.data);
        weave(leftSequence, rightSequence, results, prefix);
        prefix.removeLast();
        rightSequence.addFront(first);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        BinaryTree.Node<Integer> node = new BinaryTree.Node<>(2);
        BinaryTree.Node<Integer> subNode = new BinaryTree.Node<>(1);
        node.left = subNode;
        subNode.parent = node;
        subNode = new BinaryTree.Node<>(3);
        node.right = subNode;
        subNode.parent = node;

        binaryTree.root = node;

        node = subNode;
        subNode = new BinaryTree.Node<>(4);
        node.right = subNode;
        subNode.parent = node;
        node = subNode;
        subNode = new BinaryTree.Node<>(5);
        node.right = subNode;
        subNode.parent = node;

        System.out.println("All sequences that could generate the BST are: ");
        ArrayList<LinkedList<Integer>> results = allSequences(binaryTree.root);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).string());
        }
    }
}
