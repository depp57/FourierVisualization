package viewmodel;

import model.Signal;
import model.maths.Algorithms;
import view.CircleFrequencyDomain;
import view.GraphTimeDomain;

public class SignalViewModel {

    private final double range;
    private GraphTimeDomain graphTimeDomain;
    private CircleFrequencyDomain circleFrequencyDomain;
    private final Signal signal;
    private int numberPoints = 250;
    private double circleFrequency = 1.0;

    public SignalViewModel(double range) {
        this.range = range;

        // Default signal
        signal = new Signal(4, 1, 1);
    }

    private double[][] computePointsTimeDomain(int numberPoints) {
        return Algorithms.computePointsTimeDomain(signal, range, numberPoints);
    }

    private double[][] computePointsFrequencyDomain(double[][] timeDomainPoints) {
        return Algorithms.computePointsFrequencyDomain(timeDomainPoints, circleFrequency);
    }

    public void bind(GraphTimeDomain graph, CircleFrequencyDomain circle) {
        graphTimeDomain = graph;
        circleFrequencyDomain = circle;

        updateChart();
    }

    // -1 if value unchanged
    public void changeSignal(double frequency, double Amplitude, double offSet) {
        if (frequency != -1) signal.frequency = frequency;
        if (Amplitude != -1) signal.amplitude = Amplitude;
        if (offSet != -1)    signal.offSet = offSet;

        updateChart();
    }

    public void changePointsNumber(Number points) {
        numberPoints = points.intValue();

        updateChart();
    }

    public void changeCircleFrequency(Number frequency) {
        circleFrequency = frequency.doubleValue();

        updateChart();
    }

    private void updateChart() {
        double[][] timeDomainPoints = computePointsTimeDomain(numberPoints);
        graphTimeDomain.plotPoints(timeDomainPoints);
        circleFrequencyDomain.plotPoints(computePointsFrequencyDomain(timeDomainPoints));
    }

    public Signal getSignal() {
        return signal;
    }


}
