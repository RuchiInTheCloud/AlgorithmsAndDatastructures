package _9_objectorienteddesign.example2_1;

public class Manager extends Employee {
    public Manager(CallHandler callHandler) {
        super(callHandler);
        this.rank = Rank.Manager;
    }
}
