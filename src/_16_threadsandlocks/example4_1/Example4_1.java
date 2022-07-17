package _16_threadsandlocks.example4_1;

//Several ways to prevent deadlocks
//One way is for process to declare upfront what locks it will need
//We can then verify if a deadlock would be created by issuing these locks and we can fail if so
//Order of locks requested
//A= 1, 2, 3, 4
//B= 1, 3, 5
//C= 7, 5, 9, 2
//
//2 -> 3, 3 -> 5, 5 -> 9 -> 2
//A deadlock is presented as a cycle
//An edge (w, v) exist in the graph if a process declares that it will request lock v immediately after lock w.
//Create class that Threads and processes can use to declare the order in which they will request resources
//Declare will iterate through the declare order add contiguous pair of elements (v, w) to the graph.
//Afterwards check to see if a cycle has been created. If cycle is created backtrack and remove edges that were created
//Detect cycle by DFS through connected component
//If a cycle is created one of the newly added edges is to blame. As long as all edges touched by DFS, we know we fully
//searched for a cycle
public class Example4_1 {
    public static void main(String[] args) {
        //Assumption: Locks and Processes are ordered sequentially
        int[] res1 = {1, 2, 3, 4};
        int[] res2 = {1, 5, 4, 1};
        int[] res3 = {1, 4, 5};

        LockFactory.initialize(10);

        LockFactory lf = LockFactory.getInstance();
        System.out.println(lf.declare(1, res1));
        System.out.println(lf.declare(2, res2));
        System.out.println(lf.declare(3, res3));

        System.out.println(lf.getLock(1, 1));
        System.out.println(lf.getLock(1, 2));
        System.out.println(lf.getLock(2, 4));
    }
}
