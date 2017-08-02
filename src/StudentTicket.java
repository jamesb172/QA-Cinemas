import java.util.Date;


public class StudentTicket extends Ticket{

	private static double price = 6.00;

	public StudentTicket(int id, Date timeDate){
		super(id, timeDate, price);
	}

	@Override
	public void discountPrice() {
		setTicketPrice(price-2.00);
	}
}
