package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import viewmodel.SignalViewModel;

public class CircleFrequencySlider extends VBox {

    public CircleFrequencySlider(SignalViewModel viewModel) {
        super(20);

        Label textSlider = new Label("Circle frequency (cycles/second)");
        textSlider.setStyle("-fx-font: 18 arial");

        Slider slider = new Slider(0.1, 10, 1);
        slider.setShowTickMarks(true); slider.setShowTickLabels(true);
        slider.setPrefWidth(300);
        slider.valueProperty().addListener((_1, _2, newValue) -> viewModel.changeCircleFrequency(newValue));

        getChildren().addAll(textSlider, slider);
        setAlignment(Pos.CENTER);
    }
}
