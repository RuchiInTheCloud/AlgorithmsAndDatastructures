package _9_objectorienteddesign.example2_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class CallHandler {
    private static final int LEVELS = 3;
    ArrayList<ArrayList<Employee>> employeeLevels;
    ArrayList<ArrayList<Call>> callQueues;

    /* Initialize with 10 respondents, 4 managers, and 2 directors. */
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    public CallHandler() {
        employeeLevels = new ArrayList<>(LEVELS);
        callQueues = new ArrayList<>(LEVELS);

        // Create respondents.
        ArrayList<Employee> respondents = new ArrayList<>(NUM_RESPONDENTS);
        for (int k = 0; k < NUM_RESPONDENTS; k++) {
            respondents.add(new Respondent(this));
        }
        employeeLevels.add(respondents);

        // Create managers.
        ArrayList<Employee> managers = new ArrayList<>(NUM_MANAGERS);
        for (int k = 0; k < NUM_MANAGERS; k++) {
            managers.add(new Manager(this));
        }
        employeeLevels.add(managers);

        // Create directors.
        ArrayList<Employee> directors = new ArrayList<>(NUM_DIRECTORS);
        for (int k = 0; k < NUM_DIRECTORS; k++) {
            directors.add(new Director(this));
        }
        employeeLevels.add(directors);

        ArrayList<Call> callQueue;
        for (int k = 0; k < LEVELS; k++) {
            callQueue = new ArrayList<>();
            callQueues.add(callQueue);
        }
    }

    public Employee getHandlerForCall(Call call) {
        for (int level = call.getRank().getValue(); level < LEVELS; level++) {
            ArrayList<Employee> employeeLevel = employeeLevels.get(level);
            for (int i = 0; i < employeeLevel.size(); i++) {
                Employee employee = employeeLevel.get(i);
                if (employee.isFree()) {
                    return employee;
                }
            }
        }
        return null;
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee employee = getHandlerForCall(call);
        if (employee != null) {
            employee.receiveCall(call);
            call.setHandler(employee);
        } else {
            /* Place the call into corresponding call queue according to its rank. */
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    /* An employee got free. Look for a waiting call that he/she can serve. Return true
     * if we were able to assign a call, false otherwise. */
    public boolean assignCall(Employee employee) {
        /* Check the queues, starting from the highest rank this employee can serve. */
        for (int rank = employee.getRank().getValue(); rank >= 0; rank--) {
            ArrayList<Call> queue = callQueues.get(rank);

            /* Remove the first call, if any */
            if (queue.size() > 0) {
                Call call = queue.remove(0);
                if (call != null) {
                    employee.receiveCall(call);
                    return true;
                }
            }
        }
        return false;
    }
}