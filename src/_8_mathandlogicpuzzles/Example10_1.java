package _8_mathandlogicpuzzles;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.Random;

//1000 bottles, 1 contains poison
//10 test strips given to detect poison
//A single drop of poison turns the test strip positive permanently
//Tests can be run once per day and it takes 7 days to receive a test result
//
//28 days
//Day 0 :Divide 1000 bottles among 10 test strips
//Day 7 :Consider the 100 bottles that turned the positive test strip. Divide the 100 bottles over 9 test strips
//Days 14 : Consider the 12 bottles that turned the positive test strip. Divide the 12 bottles over 8 test strips
//Days 21 : Consider the two bottles that turned the positive test strip. Divide the two bottles over 7 test strips
//Days 28 : The bottle that turned the test strip positive is the poisonous one.
public class Example10_1 {
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

        public int getId() {
            return id;
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

        public ArrayList<Bottle> getLastWeeksBottles(int day) {
            int testDay = day - DAYS_FOR_RESULT;
            if (testDay < 0) {
                return null;
            }
            return dropsByDay.get(testDay);
        }
    }

    private static int findPoisonousBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
        int today = 0;
        while (bottles.size() > 1 && testStrips.size() > 1) {
            runTests(bottles, testStrips, today);

            today += TestStrip.DAYS_FOR_RESULT;
            for (int i = 0; i < testStrips.size(); i++) {
                TestStrip testStrip = testStrips.get(i);

                if (testStrip.isPositiveOnDay(today)) {
                    bottles = testStrip.getLastWeeksBottles(today);
                    testStrips.remove(i);
                    break;
                }
            }
        }

        if (bottles.size() == 1) {
            return bottles.get(0).getId();
        }

        return -1;
    }

    private static void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips, int day) {
        int index = 0;
        for (int i = 0; i < bottles.size(); i++) {
            Bottle bottle = bottles.get(i);
            TestStrip testStrip = testStrips.get(index);
            testStrip.addDropOnDay(bottle, day);
            index = (index + 1) % testStrips.size();
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

        ArrayList<TestStrip> testStrips = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            testStrips.add(new TestStrip(i));
        }

        int poisonousId = findPoisonousBottle(bottles, testStrips);
        System.out.println("Poisonous Bottle Id: " + poisonousId);
    }
}
