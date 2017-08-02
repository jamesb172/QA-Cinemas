import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CostProcessing extends Application {

	private AnchorPane rootLayout;
	private Stage primaryStage;

	public CostProcessing(){

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("QA Cinemas Ticket Booking");

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CostProcessing.class.getResource("LandingPage.fxml"));
		rootLayout = loader.load();
		Image logo = new Image("QA Cinemas.png");
		ImageView logoView = new ImageView(logo);
		logoView.setFitHeight(50);
		logoView.setPreserveRatio(true);
		logoView.setX(110);
		rootLayout.getChildren().add(logoView);

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String args[]){
		CommandLineImplementation cli = new CommandLineImplementation();
		// UNCOMMENT TO RUN COMMAND LINE INTERFACE
//		cli.beginCommandLine();
	    launch(args);
	}
}