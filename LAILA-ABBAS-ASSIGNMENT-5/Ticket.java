package parkingLot;

import java.time.LocalDateTime;

public class Ticket {
	
	private LocalDateTime tickStartTime;
	int tickType ;//0 for compact and 1 for regular 
	
	public Ticket(int ticketType)
	{
		setTicketType(ticketType);
		tickStartTime =  java.time.LocalDateTime.now();
	}
	
	public LocalDateTime getStartTime()
	{
		return tickStartTime;
	}
	
	private void setTicketType(int ticketType)
	{
		if(ticketType == 0 || ticketType == 1)
			tickType = ticketType;
		else
			throw new IllegalArgumentException("Inavlid ticket type");
	}
	
	public boolean isTicketRegular()
	{
		if(tickType == 1)
			return true;
		else
			return false;
	}
	
	public boolean isTicketCompact()
	{
		if(tickType == 0)
			return true;
		else
			return false;
	}
}
