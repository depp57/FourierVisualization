package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleFrequencyDomain extends Canvas {

    private static final double WIDTH = 400, HEIGHT = 400;
    private final GraphicsContext gc;

    public CircleFrequencyDomain() {
        super(WIDTH, HEIGHT);
        gc = getGraphicsContext2D();

        drawAxes();
    }

    private void drawAxes() {
        gc.setStroke(Color.GRAY);

        // Draw axes
        gc.strokeLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
        gc.strokeLine(0, HEIGHT/2, WIDTH, HEIGHT/2);

        // Draw dotted circle
        gc.setLineDashes(2);
        gc.strokeOval(WIDTH/4, HEIGHT/4, WIDTH/2, HEIGHT/2);

        // Setup Graphics properties for next drawing
        gc.setStroke(Color.YELLOW);
        gc.setLineDashes(0);
        gc.setLineWidth(1.5);

        //drawVectorFromOrigin(100, 100);
    }

    public void animePlotPoints(double[][] points) {
        final int animationTime = 300;
        final int step = animationTime / (points.length-1); // As we start from second point

        for (int i = 1; i < points.length; i++) {
            gc.strokeLine(points[i-1][0], points[i-1][1], points[i][0], points[i][1]);
        }
    }

    public void plotPoints(double[][] points) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        drawAxes();

        for (int i = 1; i < points.length; i++) {
            gc.strokeLine(points[i-1][0], points[i-1][1], points[i][0], points[i][1]);
        }
    }

    private void drawVectorFromOrigin(double endX, double endY) {
        gc.setFill(Color.WHITE);

        gc.strokePolygon(new double[] {
            WIDTH/2, endX, endX, WIDTH/2
        }, new double[] {
            HEIGHT/2, HEIGHT/2, endY, endY,
        }, 4);

         // TODO
    }
}
