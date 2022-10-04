package _17_moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
Given a 2 dimensional graph with points on it, find a line which passes the most number of points
 */
public class Example14_1 {
    static class GraphPoint {
        int x, y;

        GraphPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        static double epsilon = 0.0001;
        double slope, intercept;
        boolean infinite_slope = false;

        Line(GraphPoint p, GraphPoint q) {
            if (Math.abs(p.x - q.x) > epsilon) {
                slope = (p.y - q.y) / (p.x - q.x);
                intercept = p.y - slope * p.x;
            } else {
                infinite_slope = true;
                intercept = p.x;
            }
        }

        static double floorToNearEpsilon(double d) {
            int r = (int) (d / epsilon);
            return r * epsilon;
        }

        boolean isEquivalent(double a, double b) {
            return Math.abs(a - b) < epsilon;
        }

        boolean isEquivalent(Line line) {
            return isEquivalent(line.slope, this.slope) && isEquivalent(line.intercept, this.intercept)
                    && this.infinite_slope == line.infinite_slope;
        }
    }

    static Line findBestLine(GraphPoint[] points) {
        HashMap<Double, List<Line>> linesBySlope = getListOfLines(points);
        return getBestLine(linesBySlope);
    }

    static HashMap<Double, List<Line>> getListOfLines(GraphPoint[] points) {
        HashMap<Double, List<Line>> linesBySlope = new HashMap<>();
        for (GraphPoint pointI : points) {
            for (GraphPoint pointJ : points) {
                Line line = new Line(pointI, pointJ);
                double key = Line.floorToNearEpsilon(line.slope);
                List<Line> lines = linesBySlope.get(key);
                if (lines == null) {
                    lines = new ArrayList<>();
                    linesBySlope.put(key, lines);
                }
                lines.add(line);
            }
        }
        return linesBySlope;
    }

    static Line getBestLine(HashMap<Double, List<Line>> linesBySlope) {
        Line bestLine = null;
        int bestCount = 0;
        Set<Double> slopes = linesBySlope.keySet();
        for (Double slope : slopes) {
            List<Line> lines = linesBySlope.get(slope);
            for (Line line : lines) {
                int count = countEquivalentLines(linesBySlope, line);
                if (count > bestCount) {
                    bestCount = count;
                    bestLine = line;
                }
            }
        }
        return bestLine;
    }

    static int countEquivalentLines(HashMap<Double, List<Line>> linesBySlope, Line line) {
        double key = Line.floorToNearEpsilon(line.slope);
        int count = countEquivalentLines(linesBySlope.get(key), line);
        count += countEquivalentLines(linesBySlope.get(key - Line.epsilon), line);
        count += countEquivalentLines(linesBySlope.get(key + Line.epsilon), line);
        return count;
    }

    static int countEquivalentLines(List<Line> lines, Line line) {
        if (lines == null)
            return 0;
        int count = 0;
        for (Line parallelLine : lines) {
            if (parallelLine.isEquivalent(line)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Line line = findBestLine(new GraphPoint[]{new GraphPoint(0, 0), new GraphPoint(1, 1), new GraphPoint(2, 1),
                new GraphPoint(2, 2)});
        System.out.println("Slope: " + line.slope);
        System.out.println("Intercept: " + line.intercept);
    }
}
