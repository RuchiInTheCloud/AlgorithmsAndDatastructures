package _9_objectorienteddesign.example2_1;

public class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        this.rank = Rank.Director;
    }
}
