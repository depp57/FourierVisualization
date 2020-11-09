package model;

public class Signal {

    public double frequency; // In Hz
    public double amplitude; // In arbitrary unit
    public double offSet; // In arbitrary unit

    public Signal(double frequency, double amplitude, double offSet) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.offSet = offSet;
    }
}
