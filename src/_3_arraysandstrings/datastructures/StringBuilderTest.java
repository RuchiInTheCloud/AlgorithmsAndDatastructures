package _3_arraysandstrings.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringBuilderTest {
    @Test
    public void testStringBuilder() {
        StringBuilder myStringBuilder = new StringBuilder();
        myStringBuilder.append("USA");
        myStringBuilder.append("Nepal");
        myStringBuilder.append("India");
        myStringBuilder.append("Australia");
        myStringBuilder.append("Germany");

        assertEquals(myStringBuilder.toString(), "USANepalIndiaAustraliaGermany");
    }
}
