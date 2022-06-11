package _8_mathandlogicpuzzles;

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
public class Example10_3 {
}
