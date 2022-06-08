package _5_stacksandqueues.datastructures;

public class SortedStack extends Stack<Integer> {
    public SortedStack(int capacity) {
        super(capacity);
    }

    public Stack<Integer> sort() {
        Stack<Integer> sortedStack = new Stack<>(this.capacity);

        Integer element, sortedElement;
        while (!this.isEmpty()) {
            element = this.pop().data;
            while (!sortedStack.isEmpty() && sortedStack.peek().data > element) {
                sortedElement = sortedStack.pop().data;
                this.push(sortedElement);
            }
            sortedStack.push(element);
        }

        return sortedStack;
    }
}
