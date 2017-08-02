import java.util.Date;


public class OAPTicket extends Ticket{

	private static double price = 6.00;

	public OAPTicket(int id, Date timeDate){
		super(id, timeDate, price);
	}

	@Override
	public void discountPrice() {
		setTicketPrice(price-2.00);
	}
}
