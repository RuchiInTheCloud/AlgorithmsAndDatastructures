package stacksandqueues;

import stacksandqueues.datastructures.SetOfStacks;

//Set of stacks: When capacity is reached for a stack, create a new stack
//push: When capacity reached in last stack or last stack is null, create a new stack and insert it into the stacklist. Push data into the last stack
//pop: If last stack is null or empty, throw ex. If after popping last stack is empty remove it from the list of stacks. Return value.
//popAt: Remove element from the top of stack, if next stacks are present remove element from bottom and pass on to caller. Put the element
// received from recursive call to the top of stack
//BCR: popAt: O(number of stacks)
//Test: Cross check boundary conditions, pointers
public class Example3_1 {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        System.out.println(setOfStacks.getStackCount());

        setOfStacks.popAt(0);
        System.out.println(setOfStacks.getStackCount());
    }
}

