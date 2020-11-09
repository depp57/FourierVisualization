package model.maths;

import model.Signal;

public abstract class Algorithms {

    public static double[][] computePointsTimeDomain(Signal signal, double range, int numberPoints) {
        final double[][] points = new double[numberPoints][2]; // Matrix which contains (x;y) for all points

        for (int i = 0; i < numberPoints; i++) {
            final double x = (double)i/numberPoints * range;
            final double y = signal.offSet + Math.sin(x*2*Math.PI*signal.frequency+Math.PI/2) * signal.amplitude;

            points[i] = new double[] {x, y};
        }

        return points;
    }

    public static double[][] computePointsFrequencyDomain(double[][] timeDomainPoints, double frequency) {
        final int numberPoints = timeDomainPoints.length;

        final double[][] points = new double[numberPoints][2]; // Matrix which contains (x;y) for all points
        final double angleTick = 2*Math.PI*frequency/numberPoints;

        for (int i = 0; i < numberPoints; i++) {
            final double x = Math.cos(i * angleTick) * 100 * timeDomainPoints[i][1] + 200;
            final double y = Math.sin(i * angleTick) * 100 * timeDomainPoints[i][1] + 200;

            points[i] = new double[] {x, y};
        }

        return points;
    }

    public static void fastFourierTransform() {

    }
}
