import java.util.Date;


public class StandardTicket extends Ticket{

	private static double price = 8.00;

	public StandardTicket(int id, Date timeDate){
		super(id, timeDate, price);
	}

	@Override
	public void discountPrice() {
		setTicketPrice(price-2.00);
	}
}
