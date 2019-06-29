package parkingLot;

public class ParkingLot {
	
	private int compactSpacesNo; //smaller car
	private int emptyCompactSpacesNo;
	private int regularSpacesNo; //larger cars
	private int emptyRegularSpacesNo;
	boolean redFlag = false; //if true indicates parking lot is full
	
	public ParkingLot()
	{
		compactSpacesNo = 30;
		regularSpacesNo = 30;
		
		emptyCompactSpacesNo = compactSpacesNo;
		emptyRegularSpacesNo = regularSpacesNo;
	}
	
	public ParkingLot(int compactSpacesCount,int regularSpacesCount)
	{
		setCompactSpacesCount(compactSpacesCount);
		setRegularSpacesCount(regularSpacesCount);
		
		emptyCompactSpacesNo = compactSpacesNo;
		emptyRegularSpacesNo = regularSpacesNo;
	}
	
	public int getCompactSpacesCount()
	{
		return compactSpacesNo;
	}
	
	public int getEmptyCompactSpacesCount()
	{
		return emptyCompactSpacesNo;
	}
	
	private void decOneCompactSpace()
	{
		if(emptyCompactSpacesNo > 0)
			emptyCompactSpacesNo --;
	}
	
	private void setCompactSpacesCount(int compactSpacesCount)
	{
		if(compactSpacesCount >=0)
			compactSpacesNo = compactSpacesCount;
	}
	
	public int getRegularSpacesCount()
	{
		return regularSpacesNo;
	}
	
	public int getEmptyRegularSpacesCount()
	{
		return emptyRegularSpacesNo;
	}
	
	private void decOneRegularSpace()
	{
		if(emptyRegularSpacesNo > 0)
			emptyRegularSpacesNo --;
	}
	
	private void setRegularSpacesCount(int regularSpacesCount)
	{
		if(regularSpacesCount >=0)
			regularSpacesNo = regularSpacesCount;
	}
	
	public boolean isFull()
	{
		if(getEmptyCompactSpacesCount() == 0 && getEmptyRegularSpacesCount() == 0)
			return true;
		else
			return false;
	}
	
	public void releaseSpotByTicket(Ticket t)
	{
		if(t.isTicketCompact()== true)
			emptyCompactSpacesNo ++;
		else if (t.isTicketRegular()== true)
			emptyRegularSpacesNo ++;
		
		if (redFlag == true)
			redFlag = false;
		t = null ;
	}
	
	public Ticket parkVehicle(Vehicle vehicle)
	{
		
		if(vehicle.isVehicleCompact() && (getEmptyCompactSpacesCount()!=0))
		{
			Ticket a = new Ticket(0);
			this.decOneCompactSpace();
			redFlag = isFull();
			return(a);
		}
		else if(vehicle.isVehicleCompact() && getEmptyRegularSpacesCount()!= 0)
		{
			Ticket a = new Ticket(1);
			this.decOneRegularSpace();
			redFlag = isFull();
			return(a);
		}
		else if(vehicle.isVehicleRegular() && getEmptyRegularSpacesCount()!= 0)
		{
			Ticket a = new Ticket(1);
			this.decOneRegularSpace();
			redFlag = isFull();
			return(a);
		}
		else
			throw new IllegalArgumentException("No empty places");
		
	}

}
