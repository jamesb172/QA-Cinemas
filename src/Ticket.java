import java.util.Date;


public abstract class Ticket {

	private int ticketID;
	private double ticketPrice;
	private Date ticketTimeDate;

	public Ticket(int id, Date timeDate, double price){
		ticketID = id;
		ticketTimeDate = timeDate;
		ticketPrice = price;
	}

	public abstract void discountPrice();

	public int getTicketID(){
		return ticketID;
	}

	public double getTicketPrice(){
		return ticketPrice;
	}

	public Date getTicketTimeDate(){
		return ticketTimeDate;
	}

	public void setTicketPrice(double price){
		ticketPrice = price;
	}

	public void setTicketTimeDate(Date date){
		ticketTimeDate = date;
	}
}
