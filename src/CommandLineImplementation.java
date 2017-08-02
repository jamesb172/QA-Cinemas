import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CommandLineImplementation {

	private ArrayList<Ticket> ticketOrder = new ArrayList<Ticket>();
	private ArrayList<Ticket> allTickets = new ArrayList<Ticket>();

	public CommandLineImplementation(){

	}

	public void beginCommandLine(){
		System.out.println("-----");
		System.out.println("Welcome to the QA Cinema's ticketing software!");
		System.out.println("-----");
		System.out.println("How would you like to proceed?");
		System.out.println("1: Purchase tickets for the next movie");

		Scanner scan = new Scanner(System.in);

		//Reading User Input
		boolean catchInput = true;
	    int i = 0;
	    do{
	        if(scan.hasNextInt()){
	            i = scan.nextInt();
	            if(i==1){
		            catchInput = false;
	    			commandLinePurchaseTickets();
	    		}else{
	    			scan.nextLine();
		            System.out.println("Enter a valid Integer value");
	    		}
	        }else{
	            scan.nextLine();
	            System.out.println("Enter a valid Integer value");
	        }
	    }while(catchInput);

        scan.close();
	}

	public void commandLinePurchaseTickets(){


		System.out.println("-----");
		System.out.println("Enter number of 'Standard' tickets you wish to purchase");

		Scanner scan = new Scanner(System.in);

		//Reading User Input
		boolean catchInput1 = true;
	    int standard = 0;
	    do{
	        if(scan.hasNextInt()){
	        	standard = scan.nextInt();
	        	Date date = new Date();
	            for(int n=0;n<standard;n++){
	            	Ticket t = new StandardTicket(allTickets.size()+1, date);
	            	if(isItWednesday(date)){
	            		applyDiscount(t);
	            	}
//		            System.out.println("Added a 'Standard' ticket to your order at price £"+t.getTicketPrice());
	            	ticketOrder.add(t);
	            	allTickets.add(t);
	            }
	            catchInput1 = false;
	        }else{
	            scan.nextLine();
	            System.out.println("Enter a valid Integer value");
	        }
	    }while(catchInput1);


		System.out.println("Enter number of 'OAP' tickets you wish to purchase");

	  //Reading User Input
  		boolean catchInput2 = true;
  	    int oap = 0;
  	    do{
  	        if(scan.hasNextInt()){
  	        	oap = scan.nextInt();
  	        	Date date = new Date();
  	            for(int n=0;n<oap;n++){
  	            	Ticket t = new OAPTicket(allTickets.size()+1, date);
  	            	if(isItWednesday(date)){
  	            		applyDiscount(t);
  	            	}
//  		            System.out.println("Added a 'OAP' ticket to your order at price £"+t.getTicketPrice());
  	            	ticketOrder.add(t);
  	            	allTickets.add(t);
  	            }
  	            catchInput2 = false;
  	        }else{
  	            scan.nextLine();
  	            System.out.println("Enter a valid Integer value");
  	        }
  	    }while(catchInput2);


		System.out.println("Enter number of 'Student' tickets you wish to purchase");

	  	//Reading User Input
		boolean catchInput3 = true;
	    int student = 0;
	    do{
	        if(scan.hasNextInt()){
	        	student = scan.nextInt();
	        	Date date = new Date();
	            for(int n=0;n<student;n++){
	            	Ticket t = new StudentTicket(allTickets.size()+1, date);
	            	if(isItWednesday(date)){
	            		applyDiscount(t);
	            	}
//		            System.out.println("Added a 'Student' ticket to your order at price £"+t.getTicketPrice());
	            	ticketOrder.add(t);
	            	allTickets.add(t);
	            }
	            catchInput3 = false;
	        }else{
	            scan.nextLine();
	            System.out.println("Enter a valid Integer value");
	        }
	    }while(catchInput3);


		System.out.println("Enter number of 'Child' tickets you wish to purchase");

		  //Reading User Input
		boolean catchInput4 = true;
	    int child = 0;
	    do{
	        if(scan.hasNextInt()){
	        	child = scan.nextInt();
	        	Date date = new Date();
	            for(int n=0;n<child;n++){
	            	Ticket t = new ChildTicket(allTickets.size()+1, date);
	            	if(isItWednesday(date)){
	            		applyDiscount(t);
	            	}
//		            System.out.println("Added a 'Child' ticket to your order at price £"+t.getTicketPrice());
	            	ticketOrder.add(t);
	            	allTickets.add(t);
	            }
	            catchInput4 = false;
	        }else{
	            scan.nextLine();
	            System.out.println("Enter a valid Integer value");
	        }
	    }while(catchInput4);

        scan.close();

        System.out.println("-----");
		System.out.println("TODAY, your total comes to £" + totalTicketCost() + "0");
	}


	public boolean isItWednesday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		boolean wednesday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY;
		return wednesday;
	}

	public void applyDiscount(Ticket t){
		t.setTicketPrice(t.getTicketPrice()-2.00);
	}

	public double totalTicketCost(){
		double totalTicketCost = 0.00;
		for(Ticket t:ticketOrder){
			totalTicketCost = totalTicketCost + t.getTicketPrice();
		}
		return totalTicketCost;
	}
}
