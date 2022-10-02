package _17_moderate;

import java.util.LinkedList;

/*
Given an integer, print an english phrase that describes the integer (One thousand two hundred thirty four)
convert a number into three digit segments and insert "thousand", "million" etc as appropriate
convert(19, 323, 984) = convert(19) + "million " + convert(323) + "thousand " + convert(984)
 */
public class Example8_1 {
    static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] bigs = {"", "Thousand", "Million", "Billion"};
    static String hundred = "Hundred";
    static String negative = "Negative";

    static String convert(int num) {
        if (num == 0) {
            return smalls[0];
        } else if (num < 0) {
            return negative + convert(-1 * num);
        }
        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000;
            chunkCount += 1;
        }
        return listToString(parts);
    }

    static String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();
        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number = number % 100;
        }
        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number = number % 10;
        }

        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }

    static String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(19323912));
    }
}
