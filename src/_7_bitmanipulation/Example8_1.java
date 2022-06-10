package _7_bitmanipulation;

//A monochrome screen is stored in an array of "bytes". A pixel is represented by a bit.
//The width of the screen in pixels is w
//Implement function to draw a line from (x1, y) to (x2, y)
//
//64 bits, w = 32 bits, y = 1, x1 = 0, x2 = 15
//[][][][],[][][][]
// / 8 very important to pick the right byte
public class Example8_1 {
    private static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startByte = x1 / 8;
        int offsetStartBit = x1 % 8;

        if (offsetStartBit != 0) {
            startByte++;
        }

        int lastByte = x2 / 8;
        int offsetLastBit = x2 % 8;

        if (offsetLastBit != 7) {
            lastByte--;
        }

        for (int i = startByte; i <= lastByte; i++) {
            screen[(width / 8) * y + i] = (byte) 0xff;
        }

        byte startMask = (byte) (0xff >>> offsetStartBit);
        byte lastMask = (byte) (~(0xff >>> (offsetLastBit + 1)));

        if (x1 / 8 == x2 / 8) {
            screen[(width / 8) * y + x1 / 8] |= (startMask & lastMask);
        } else {
            screen[(width / 8) * y + x1 / 8] |= startMask;
            screen[(width / 8) * y + x2 / 8] |= lastMask;
        }
    }
}
