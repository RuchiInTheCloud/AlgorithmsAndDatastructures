package _9_objectorienteddesign.example2_1;

public class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
        super(callHandler);
        this.rank = Rank.Respondent;
    }
}
