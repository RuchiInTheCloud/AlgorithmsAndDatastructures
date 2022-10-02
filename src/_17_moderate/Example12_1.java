package _17_moderate;

import org.w3c.dom.Attr;

/*
XML Encoding
Element --> Tag Attributes END Children END
Attribute --> Tag Value
END --> 0
Tag --> predefined mapping to int
Value --> string
 */
public class Example12_1 {
    static class Attribute {
        private String tagCode;
        public String value;

        public String getTagCode() {
            return tagCode;
        }
    }

    static class Element {
        private String nameCode;

        public Attribute[] attributes;
        public Element[] children;
        public String value;

        public String getNameCode() {
            return nameCode;
        }
    }

    static String encode(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    static void encode(Element root, StringBuilder sb) {
        encode(root.getNameCode(), sb);
        for (Attribute a : root.attributes) {
            encode(a, sb);
        }
        encode("0", sb);

        if (root.value != null && root.value != "") {
            encode(root.value, sb);
        } else {
            for (Element e : root.children) {
                encode(e, sb);
            }
        }
        encode("0", sb);
    }

    static void encode(Attribute a, StringBuilder sb) {
        encode(a.getTagCode(), sb);
        encode(a.value, sb);
    }

    static void encode(String v, StringBuilder sb) {
        sb.append(v);
        sb.append(" "); // very easy to forget if one would not create this method
    }
}
