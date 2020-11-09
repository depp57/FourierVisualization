import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainView;

public class FourierVisualization extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fourier Visualization");

        Scene scene = new Scene(new MainView());

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}
