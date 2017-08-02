import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LandingController {

	public void purchase() throws Exception{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchasePage.fxml"));
			Parent root = (Parent) loader.load();
			Stage s = new Stage();
			s.setScene(new Scene(root));
			s.show();

			PurchaseController p = loader.getController();
			p.setData();


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void check(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("This feature is not currently avalible");
		alert.setContentText("Future developments consist of combining the booking system with an SQL database so you can check your purchases at a later date. A login system and RMI framework would also be ideal for allowing multiple users to perform bookings at the same time.");
		alert.showAndWait();
	}
}
