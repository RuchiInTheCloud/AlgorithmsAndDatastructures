package _9_objectorienteddesign.example1_1;

import _3_arraysandstrings.datastructures.ArrayList;

public class Question {
    public static void main(String[] args) {
        int numHands = 5;
        BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
        automator.initializeDeck();
        boolean success = automator.dealInitial();

        if (!success) {

            System.out.println("Error. Out of cards.");
        } else {

            System.out.println("-- Initial --");
            automator.printHandsAndScore();
            ArrayList<Integer> blackjacks = automator.getBlackJacks();

            if (blackjacks.size() > 0) {

                System.out.print("Blackjack at ");
                for (int i = 0; i < blackjacks.size(); i++) {
                    System.out.print(blackjacks.get(i) + ", ");
                }
                System.out.println();
            } else {

                success = automator.playAllHands();
                if (!success) {

                    System.out.println("Error. Out of cards.");
                } else {

                    System.out.println("\n-- Completed Game --");
                    automator.printHandsAndScore();
                    ArrayList<Integer> winners = automator.getWinners();

                    if (winners.size() > 0) {

                        System.out.print("Winners: ");
                        for (int i = 0; i < winners.size(); i++) {
                            System.out.print(winners.get(i) + ", ");
                        }
                        System.out.println();
                    } else {

                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}