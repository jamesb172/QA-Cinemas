import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PurchaseController implements Initializable {

	@FXML private TextField stnd;
	@FXML private TextField oap;
	@FXML private TextField stu;
	@FXML private TextField child;
	@FXML private ComboBox combo;
	@FXML private DatePicker datepicker;
	@FXML private TableView table = new TableView();
	final ObservableList<Film> data = FXCollections.observableArrayList(
		    new Film("Spiderman 7", "Manchester"),
		    new Film("The Notebook", "Manchester"),
		    new Film("Shawshank Redemption", "Manchester"),
		    new Film("Dunkirk", "Manchester"),
		    new Film("100 Hours", "Manchester")
		);
	private ArrayList<Ticket> ticketOrder = new ArrayList<Ticket>();

	public void reset(){
		stnd.setText("0");
		oap.setText("0");
		stu.setText("0");
		child.setText("0");
	}

	public void cancel(ActionEvent actionEvent){
		Node  source = (Node)  actionEvent.getSource();
	    Stage stage  = (Stage) source.getScene().getWindow();
	    stage.close();
	}

	public void accept(ActionEvent ae){
		try{
			if(combo.getValue()!=null && table.getSelectionModel().getSelectedItem()!=null){
				int stand = Integer.parseInt(stnd.getText());
				int oapa = Integer.parseInt(oap.getText());
				int stud = Integer.parseInt(stu.getText());
				int chil = Integer.parseInt(child.getText());
				int day = datepicker.getValue().getDayOfMonth();
				int month = datepicker.getValue().getMonthValue()-1;
				int year = datepicker.getValue().getYear()-1900;
				Date cdate = new Date(year, month, day);
	//			System.out.println(calculateTicketCost(stand, oapa, stud, chil, cdate)+ " ");
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Ticket Order Confirmation");
				alert.setHeaderText("Booking cost: £"+ calculateTicketCost(stand, oapa, stud, chil, cdate) +"0");
				alert.setContentText("Please confirm your order.");
				alert.showAndWait();
				cancel(ae);
			}else{
				throw new RuntimeException();
			}
		}catch(RuntimeException r){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("An Error Occurred");
			alert.setContentText("Please check your input data and try again.");
			alert.showAndWait();
		}

	}

	public void setData() {
		combo.getItems().clear();
		combo.getItems().addAll("10:00", "12:00", "14:00", "16:00", "18:00", "20:00");
		TableColumn col1 = new TableColumn("Film");
		TableColumn col2 = new TableColumn("Location");
		table.getColumns().addAll(col1, col2);
		col1.setCellValueFactory(new PropertyValueFactory<Film,String>("title"));
		col2.setCellValueFactory(new PropertyValueFactory<Film,String>("location"));
		table.setItems(data);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	public double calculateTicketCost(int stan, int oap, int stu, int child, Date date){
		ticketOrder.clear();
		for(int n=0;n<stan;n++){
        	Ticket t = new StandardTicket(ticketOrder.size()+1, date);
        	if(isItWednesday(date)){
        		applyDiscount(t);
        	}
        	ticketOrder.add(t);
        }
		for(int n=0;n<oap;n++){
        	Ticket t = new OAPTicket(ticketOrder.size()+1, date);
        	if(isItWednesday(date)){
        		applyDiscount(t);
        	}
        	ticketOrder.add(t);
        }
		for(int n=0;n<stu;n++){
        	Ticket t = new StudentTicket(ticketOrder.size()+1, date);
        	if(isItWednesday(date)){
        		applyDiscount(t);
        	}
        	ticketOrder.add(t);
        }
		for(int n=0;n<child;n++){
        	Ticket t = new ChildTicket(ticketOrder.size()+1, date);
        	if(isItWednesday(date)){
        		applyDiscount(t);
        	}
        	ticketOrder.add(t);
        }
		return totalTicketCost();
	}

	public boolean isItWednesday(Date date){

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		boolean wednesday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
//		System.out.println(wednesday+"");
		return wednesday;
	}

	public void applyDiscount(Ticket t){
		t.discountPrice();
	}

	public double totalTicketCost(){
		double totalTicketCost = 0.00;
		for(Ticket t:ticketOrder){
			totalTicketCost = totalTicketCost + t.getTicketPrice();
		}
		return totalTicketCost;
	}
}
