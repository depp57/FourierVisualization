package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import viewmodel.SignalViewModel;

public class InputSignal extends VBox {

    public InputSignal(SignalViewModel viewModel) {
        super(20);

        HBox hbox = new HBox(10);

        Label textFrequency = new Label("Frequency (Hz) :");
        Label textAmplitude = new Label("Amplitude (Arbitrary) :");
        Label textOffset = new Label("Offset (Arbitrary) :");

        TextField inputFrequency = createTextFieldOnlyNumber(String.valueOf(viewModel.getSignal().frequency));
        TextField inputAmplitude = createTextFieldOnlyNumber(String.valueOf(viewModel.getSignal().amplitude));
        TextField inputOffset = createTextFieldOnlyNumber(String.valueOf(viewModel.getSignal().offSet));

        inputFrequency.textProperty().addListener((_1, _2, newValue) -> {
            if (!newValue.equals("")) viewModel.changeSignal(Double.parseDouble(newValue), -1, -1);
        });

        inputAmplitude.textProperty().addListener((_1, _2, newValue) -> {
            if (!newValue.equals("")) viewModel.changeSignal(-1, Double.parseDouble(newValue), -1);
        });

        inputOffset.textProperty().addListener((_1, _2, newValue) -> {
            if (!newValue.equals("")) viewModel.changeSignal(-1, -1, Double.parseDouble(newValue));
        });

        hbox.getChildren().addAll(textFrequency, inputFrequency, textAmplitude, inputAmplitude, textOffset, inputOffset);
        hbox.setAlignment(Pos.CENTER);

        Label mainLabel = new Label("Signal");
        mainLabel.setStyle("-fx-font: 24 arial");
        getChildren().addAll(mainLabel, hbox);
        setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: #2c2c54; -fx-border-width: 2px; -fx-border-style: hidden solid hidden solid");
    }

    private TextField createTextFieldOnlyNumber(String text) {
        TextField textField = new TextField(text);

        textField.textProperty().addListener((_1, _2, newValue) -> {
            if (!newValue.matches("\\d*.?\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        return textField;
    }
}
