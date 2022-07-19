package _17_moderate;

//Intersection: Given two line segments (repr. start and end point), compute point of intersection if any
//
//Point -> x, y
//Point intersection (Point start1, Point end1, Point start2, Point end2)
//
//slope = (y2 - y1)/ (x2 - x1)
//intercept = y1 - (slope * x1)
//Line -> slope, intercept
//
//slope: slope1 != slope2 || (slope1 == slope2 && intercept1 == intercept2)
//  slope1 != slope2 --> intersection needs to be between start1, end1 && start2, end2
//      x = (b2 - b1)/ (m1 - m2)
//      y = m1(b2 - b1)/ (m1 - m2) + b1
//  slope1 == slope2 --> start2 between start1 and end1 or end2 between start1 and end1 or start1 is between start2 and end2 or end1 is between start2 and end2
//                   --> rearrange the points swap start and end for both segments if x > y + swap segment1 and segment2 if segment1.startx > segment2.startx
public class Example3_1 {
    private static class Line {
        public double slope;
        public double yIntercept;

        public Line(Point start, Point end) {
            this.slope = (end.y - start.y) / (end.x - start.x);
            this.yIntercept = end.y - slope * end.x;
        }
    }

    private static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x = " + x + ", y = " + y;
        }
    }

    private static Point intersection(Point start1, Point end1, Point start2, Point end2) {
        if (start1 == null || end1 == null || start2 == null || end2 == null) {
            return null;
        }
        if (start1.x > end1.x)
            swap(start1, end1);
        if (start2.x > end2.x)
            swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }
        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope && line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1)) {
            return start2;
        } else if (line1.slope != line2.slope) {
            double x = (line2.yIntercept - line1.yIntercept) / (line1.slope - line2.slope);
            double y = line1.slope * x + line1.yIntercept;
            Point intersection = new Point(x, y);
            if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
                return intersection;
            }
        }
        return null;
    }

    private static void swap(Point point1, Point point2) {
        double x = point1.x;
        double y = point1.y;
        point1.setLocation(point2.x, point2.y);
        point2.setLocation(x, y);
    }

    private static boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private static boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    public static void main(String[] args) {
        Point s1 = new Point(2147000000, 1);
        Point e1 = new Point(-2147000000, -1);
        Point s2 = new Point(-10, 0);
        Point e2 = new Point(0, 0);
        Point intersection = intersection(s1, e1, s2, e2);
        System.out.println("Line Segment 1: " + s1 + " to " + e1);
        System.out.println("Line Segment 2: " + s2 + " to " + e2);
        System.out.println("Intersection: " + (intersection == null ? "None" : intersection));
    }
}
