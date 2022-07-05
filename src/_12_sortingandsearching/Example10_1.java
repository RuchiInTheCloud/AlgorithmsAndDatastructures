package _12_sortingandsearching;

//track (int x)
//getRankOfNumber (int x) --> return elements less than equal to x (not including x)
//Stream 5, 1, 4, 4, 5, 9, 7, 13, 3
//getRankOfNumber(1) = 0
//getRankOfNumber(3) = 1
//getRankOfNumber(4) = 3
//Save numbers in array in sorted order. Binary search number and array index represents rank.
// Maintaining sorted order extremely expensive, worst case n shifts required.
//
//Use binary search tree. If it is balanced, insertion takes O(log n) time
//We could perform in order traversal to compute rank. When traversing left the counter does not increase,
// when traversing right all elements seen in the left need to be counted as they are less than this right element
//Rather than counting elements in left subtree, keep track of this left subtree size during insertion.
//
public class Example10_1 {
    private static class BinarySearchTree {
        private static class RankNode {
            int data = 0;
            int leftSize = 0;
            RankNode left = null;
            RankNode right = null;

            public RankNode(int data) {
                this.data = data;
            }
        }

        RankNode root;

        public void insert(int data) {
            if (root == null) {
                root = new RankNode(data);
            } else {
                insert(root, data);
            }
        }

        public int getRank(int data) {
            if (root == null) {
                return -1;
            } else {
                return getRank(root, data);
            }
        }

        private int getRank(RankNode node, int data) {
            if (data == node.data) {
                return node.leftSize;
            } else if (data < node.data) {
                if (node.left != null) {
                    return getRank(node.left, data);
                } else {
                    return -1;
                }
            } else {
                if (node.right != null) {
                    int rank = getRank(node.right, data);
                    return rank == -1 ? -1 : node.leftSize + 1 + rank;
                } else {
                    return -1;
                }
            }
        }

        private void insert(RankNode node, int data) {
            if (data <= node.data) {
                if (node.left != null) {
                    insert(node.left, data);
                } else {
                    node.left = new RankNode(data);
                }
                node.leftSize++;
            } else {
                if (node.right != null) {
                    insert(node.right, data);
                } else {
                    node.right = new RankNode(data);
                }
            }
        }
    }

    private static BinarySearchTree bst = new BinarySearchTree();

    private static void track(int data) {
        bst.insert(data);
    }

    private static int getRankOfNumber(int data) {
        return bst.getRank(data);
    }

    public static void main(String[] args) {
        track(5);
        track(1);
        track(4);
        track(4);
        track(5);
        track(9);
        track(7);
        track(13);
        track(3);

        int rank = getRankOfNumber(1);
        System.out.println(rank);
        rank = getRankOfNumber(3);
        System.out.println(rank);
        rank = getRankOfNumber(4);
        System.out.println(rank);
    }
}
