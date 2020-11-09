package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import viewmodel.SignalViewModel;

public class PointsSlider extends VBox {

    public PointsSlider(SignalViewModel viewModel) {
        super(20);

        Label textSlider = new Label("Number of points");
        textSlider.setStyle("-fx-font: 24 arial");

        Slider slider = new Slider(10, 500, 250);
        slider.setShowTickMarks(true); slider.setShowTickLabels(true);
        slider.setPrefWidth(300);
        slider.valueProperty().addListener((_1, _2, newValue) -> {
            final int discreteValue = newValue.intValue();
            slider.setValue(discreteValue);
            viewModel.changePointsNumber(discreteValue);
        });

        getChildren().addAll(textSlider, slider);
        setAlignment(Pos.CENTER);
    }
}
