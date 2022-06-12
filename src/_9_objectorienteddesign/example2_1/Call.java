package _9_objectorienteddesign.example2_1;

public class Call {
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller caller) {
        this.caller = caller;
        this.rank = Rank.Respondent;
    }

    public void setHandler(Employee employee) {
        this.handler = employee;
    }

    public void disconnect() {
        reply("Thank you for calling");
    }

    public Rank getRank() {
        return rank;
    }

    public void incrementRank() {
        if (rank == Rank.Respondent) {
            rank = Rank.Manager;
        } else if (rank == Rank.Manager) {
            rank = Rank.Director;
        }
    }

    public void reply(String message) {
        System.out.println(message);
    }
}
