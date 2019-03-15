package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Anime");
		Group root = new Group();
		Scene Animesc = new Scene(root);
		primaryStage.setScene(Animesc);
		Canvas canvas = new Canvas(450,260);
		root.getChildren().add(canvas);
		Image highway = new Image("Highway.png");
		Image car = new Image("Car.png");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		final long startTime = System.nanoTime();
		new AnimationTimer() {
			@Override
			public void handle(long t) {
				double diff = (t - startTime)/10000000.0;
				while (diff > 450) {
					diff = diff - 450;
				}
				double x = diff;
				gc.drawImage(highway,-x,0);
				gc.drawImage(highway,450-x,0);
				gc.drawImage(car,0,0);
			}
		}.start();
		//gc.drawImage(highway,0,0);
		//gc.drawImage(car,0,0);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
