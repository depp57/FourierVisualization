package view;

import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Arrays;

public class GraphTimeDomain extends LineChart<Number, Number> {

    public GraphTimeDomain(double range) {
        super(
            new NumberAxis("Time", 0, range, 1),
            new NumberAxis("Amplitude", 0, 3, 1)
        );

        XYChart.Series<Number, Number> data = new XYChart.Series<>();
        getData().add(data);

        setTitle("Time domain");
        setLegendVisible(false);
        setCreateSymbols(false);
        setPrefWidth(1500); // TODO HARD CODED
        setPrefHeight(250);
    }

    public void plotPoints(double[][] points) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        ObservableList<XYChart.Data<Number, Number>> data = series.getData();

        data.clear();
        getData().clear();

        Arrays.stream(points).forEach(point -> data.add(new XYChart.Data<>(point[0], point[1])));

        getData().add(series);
    }
}
