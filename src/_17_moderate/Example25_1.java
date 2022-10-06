package _17_moderate;

import java.util.HashMap;

/*
Implement Least Recently Used Cache
Easy to evict least recently used item
Maps keys (int) to values (string) --> insert and retrieve with key
Initialised with max size --> When full evict least recently used item
Update most recently used

HashMap --> makes insertion, update and retrieval easy
--> Removal of least recently used too slow O(N), also requires saving timestamp
Doubly Linked List --> most recently used at front of list, least recently used at the end
--> Easy to remove element from middle of the list
--> Does not offer quick lookup O(N)

Merge both approaches
--> Hash table maps key to linked list node
--> Insertion: remove if existing key, adjust capacity, insert new key, value pair in hash map and linked list
--> Retrieval: get linked list node, if node is not head, remove from linkedlist and add to head, return node value
 */
public class Example25_1 {
    static class Cache {
        /*Inner class as it exists within this context*/
        static class LinkedListNode {
            private LinkedListNode next, prev;
            public int key;
            public String value;

            public LinkedListNode(int k, String v) {
                key = k;
                value = v;
            }
        }

        private int maxCacheSize;
        private HashMap<Integer, LinkedListNode> map = new HashMap<>();
        private LinkedListNode listHead = null;
        private LinkedListNode listTail = null;

        public Cache(int maxSize) {
            maxCacheSize = maxSize;
        }

        public String getValue(int key) {
            LinkedListNode item = map.get(key);
            if (item == null) {
                return null;
            }

            if (item != listHead) {
                removeFromLinkedList(item);
                insertAtFrontOfLinkedList(item);
            }
            return item.value;
        }

        public boolean removeKey(int key) {
            LinkedListNode item = map.get(key);
            if (item == null) {
                return false;
            }
            removeFromLinkedList(item);
            map.remove(key);
            return true;
        }

        public void setKeyValue(int key, String value) {
            removeKey(key);

            if (map.size() >= maxCacheSize) {
                removeKey(listTail.key);
            }

            LinkedListNode node = new LinkedListNode(key, value);
            insertAtFrontOfLinkedList(node);
            map.put(key, node);
        }

        private void removeFromLinkedList(LinkedListNode node) {
            if (node == null)
                return;

            if (node.prev != null)
                node.prev.next = node.next;
            if (node.next != null)
                node.next.prev = node.prev;
            if (node == listTail)
                listTail = node.prev;
            if (node == listHead)
                listHead = node.next;
        }

        private void insertAtFrontOfLinkedList(LinkedListNode node) {
            if (listHead == null) {
                listHead = node;
                listTail = node;
            } else {
                listHead.prev = node;
                node.next = listHead;
                listHead = node;
            }
        }
    }
}
