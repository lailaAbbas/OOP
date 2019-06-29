package parkingLot;

public class Vehicle {
	
	int vehicleType ;//0 for compact and 1 for regular
	
	public Vehicle()
	{
		vehicleType = 1; //by default all cars regular
	}
	
	public void setVehicleCompact()
	{
		vehicleType = 0;
	}
	
	public boolean isVehicleCompact()
	{
		if(vehicleType == 0)
			return true;
		else
			return false;
	}
	
	public void setVehicleRegular()
	{
		vehicleType = 1;
	}
	
	public boolean isVehicleRegular()
	{
		if(vehicleType == 1)
			return true;
		else
			return false;
	}	

}
