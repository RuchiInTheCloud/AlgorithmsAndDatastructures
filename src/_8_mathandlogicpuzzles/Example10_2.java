package _8_mathandlogicpuzzles;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.HashSet;
import java.util.Random;

//1000 bottles, 1 contains poison
//10 test strips given to detect poison
//A single drop of poison turns the test strip positive permanently
//Tests can be run once per day and it takes 7 days to receive a test result
//
//10 days
//Categorize the bottles based on the first digit, 0xx --> 0, 9xx --> 9 -> perform test on day 0
//Categorize the bottles based on the second digit, x0x --> 0, x9x --> 9 -> perform test on day 1
//Categorize the bottles based on the third digit, xx0 --> 0, xx9 --> 9 -> perform test on day 2
//Categorize the bottles based on the third digit, xx0 --> 1, xx9 --> 0 -> perform test on day 3
//
//If on day 1 there is no new sign, it indicates second digit is same as first
//If on day 2 there is no new sign, it indicates third digit could be first or second
//If on day 3 there is no new sign, based on whether digit 0 can morph into digit 1 by addition of 1 or vice versa, digit 2 needs to be determined
//099, 909

public class Example10_2 {
    private static class Bottle {
        private boolean poisoned = false;
        private int id;

        public Bottle(int id) {
            this.id = id;
        }

        public void setAsPoisoned() {
            poisoned = true;
        }

        public boolean isPoisoned() {
            return poisoned;
        }
    }

    private static class TestStrip {
        public static int DAYS_FOR_RESULT = 7;
        private int id;
        ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<>();

        public TestStrip(int id) {
            this.id = id;
        }

        private void sizeDropsByDay(int day) {
            while (dropsByDay.size() <= day) {
                ArrayList<Bottle> bottles = new ArrayList<>();
                dropsByDay.add(bottles);
            }
        }

        public void addDropOnDay(Bottle bottle, int day) {
            sizeDropsByDay(day);
            ArrayList<Bottle> bottles = dropsByDay.get(day);
            bottles.add(bottle);
        }

        public boolean isPositiveOnDay(int day) {
            int testDay = day - DAYS_FOR_RESULT;
            if (testDay < 0 || testDay > dropsByDay.size()) {
                return false;
            }
            for (int i = 0; i <= testDay; i++) {
                ArrayList<Bottle> bottles = dropsByDay.get(i);
                for (int j = 0; j < bottles.size(); j++) {
                    if (bottles.get(j).isPoisoned()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static int findPoisonousBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
        int tests = 4;

        int[] digits = new int[tests];
        HashSet<Integer> previousResults = new HashSet<>();

        for (int day = 0; day < tests; day++) {
            runTests(bottles, testStrips, day);
            int resultDay = day + TestStrip.DAYS_FOR_RESULT;
            digits[day] = getPoisonousStrip(testStrips, resultDay, previousResults);
            previousResults.add(digits[day]);
        }

        if (digits[1] == -1) {
            digits[1] = digits[0];
        }

        if (digits[2] == -1) {
            if (digits[3] == -1) {
                digits[2] = (digits[0] + 1) % 10 == digits[1] ? digits[0] : digits[1];
            } else {
                digits[2] = (digits[3] - 1 + 10) % 10;
            }
        }
        return digits[0] * 100 + digits[1] * 10 + digits[2];
    }

    private static int getPoisonousStrip(ArrayList<TestStrip> testStrips, int resultDay,
            HashSet<Integer> previousResults) {
        for (int i = 0; i < testStrips.size(); i++) {
            TestStrip testStrip = testStrips.get(i);

            if (testStrip.isPositiveOnDay(resultDay) && !previousResults.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips, int day) {
        for (int bottleId = 0; bottleId < bottles.size(); bottleId++) {
            int testStripIndex = findTestStrip(bottleId, day, testStrips);
            TestStrip testStrip = testStrips.get(testStripIndex);
            Bottle bottle = bottles.get(bottleId);
            testStrip.addDropOnDay(bottle, day);
        }
    }

    private static int findTestStrip(int bottleId, int day, ArrayList<TestStrip> testStrips) {
        switch (day) {
            case 0:
                return bottleId / 100;
            case 1:
                return (bottleId % 100) / 10;
            case 2:
                return bottleId % 10;
            case 3:
                return (bottleId + 1) % 10;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Bottle> bottles = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            bottles.add(new Bottle(i));
        }

        Random random = new Random();
        int randomIdx = random.nextInt(1000);
        bottles.get(randomIdx).setAsPoisoned();
        System.out.println("Poisonous Bottle set as: " + randomIdx);

        ArrayList<TestStrip> testStrips = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            testStrips.add(new TestStrip(i));
        }

        int poisonousId = findPoisonousBottle(bottles, testStrips);
        System.out.println("Poisonous Bottle Id: " + poisonousId);
    }
}
