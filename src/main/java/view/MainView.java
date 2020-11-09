package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import viewmodel.SignalViewModel;

public class MainView extends VBox {

    private final double RANGE = 3;

    private final GraphTimeDomain graph = new GraphTimeDomain(RANGE);
    private final CircleFrequencyDomain circle = new CircleFrequencyDomain();
    private final SignalViewModel viewModel = new SignalViewModel(RANGE);

    public MainView() {
        super(20);
        setStyle("-fx-background-color: #2c2c54");
        createView();
        bindViewModel();
    }

    private void createView() {
        PointsSlider pointsSlider = new PointsSlider(viewModel);
        CircleFrequencySlider circleFrequencySlider = new CircleFrequencySlider(viewModel);
        InputSignal inputSignal = new InputSignal(viewModel);

        HBox hBox = new HBox(50, pointsSlider, circleFrequencySlider, inputSignal);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: white");

        getChildren().addAll(graph, circle, hBox);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
    }

    private void bindViewModel() {
        viewModel.bind(graph, circle);
    }
}
