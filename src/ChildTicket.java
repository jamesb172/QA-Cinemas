import java.util.Date;


public class ChildTicket extends Ticket{

	private static double price = 4.00;

	public ChildTicket(int id, Date timeDate){
		super(id, timeDate, price);
	}

	@Override
	public void discountPrice() {
		setTicketPrice(price-2.00);
	}
}
