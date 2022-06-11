package _8_mathandlogicpuzzles;

import _3_arraysandstrings.datastructures.ArrayList;

import java.util.Random;

//1000 bottles, 1 contains poison
//10 test strips given to detect poison
//A single drop of poison turns the test strip positive permanently
//Tests can be run once per day and it takes 7 days to receive a test result
//
//7 days
//Convert bottle id into binary and place a drop on the test strip if the bit is 1
//test strips (9 8 7 6 5 4 3 2 1)
public class Example10_3 {
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
        for (int bottleId = 0; bottleId < bottles.size(); bottleId++) {
            int currentBottleId = bottleId;
            Bottle bottle = bottles.get(bottleId);

            int bitIndex = 0;
            while (currentBottleId != 0) {
                if ((currentBottleId & 1) == 1) {
                    TestStrip testStrip = testStrips.get(bitIndex);
                    testStrip.addDropOnDay(bottle, 0);
                }
                bitIndex = bitIndex + 1;
                currentBottleId = currentBottleId >>> 1;
            }
        }

        ArrayList<Integer> positiveTestStrips = getPoisonousOnDay(testStrips, TestStrip.DAYS_FOR_RESULT);
        return setBits(positiveTestStrips);
    }

    private static int setBits(ArrayList<Integer> positiveTestStrips) {
        int bottleId = 0;
        for (int i = 0; i < positiveTestStrips.size(); i++) {
            bottleId |= (1 << positiveTestStrips.get(i));
        }
        return bottleId;
    }

    private static ArrayList<Integer> getPoisonousOnDay(ArrayList<TestStrip> testStrips, int resultDay) {
        ArrayList<Integer> positiveTestStrips = new ArrayList<>();
        for (int i = 0; i < testStrips.size(); i++) {
            TestStrip testStrip = testStrips.get(i);

            if (testStrip.isPositiveOnDay(resultDay)) {
                positiveTestStrips.add(i);
            }
        }
        return positiveTestStrips;
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
