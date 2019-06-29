package parkingLot;

public class RunProgram {

	
	public static void main(String[] args) {
		
		ParkingLot parkA = new ParkingLot(15, 15);
		
		Vehicle comp1 = new Vehicle();
		comp1.setVehicleCompact();
		Vehicle comp2 = new Vehicle();
		comp2.setVehicleCompact();
		Vehicle comp3 = new Vehicle();
		comp3.setVehicleCompact();
		
		Vehicle regul1 = new Vehicle();
		regul1.setVehicleRegular();
		Vehicle regul2 = new Vehicle();
		regul2.setVehicleRegular();
		
		Ticket Acomp1 = parkA.parkVehicle(comp1);
		Ticket Acomp2 = parkA.parkVehicle(comp2);
		Ticket Acomp3 = parkA.parkVehicle(comp3);
		
		System.out.println("Empty compact car spaces : ");
		System.out.println(parkA.getEmptyCompactSpacesCount());
		
		Ticket Aregul1 = parkA.parkVehicle(regul1);
		Ticket Aregul2 = parkA.parkVehicle(regul1);
		
		System.out.println("Empty regular car spaces : ");
		System.out.println(parkA.getEmptyRegularSpacesCount());
		
		System.out.println("Is parking lot full");
		System.out.println(parkA.isFull());
		
		parkA.releaseSpotByTicket(Acomp1);
		parkA.releaseSpotByTicket(Aregul1);
		
		System.out.println("After deletion");
		System.out.println("Empty compact car spaces : ");
		System.out.println(parkA.getEmptyCompactSpacesCount());
		
		System.out.println("Empty regular car spaces : ");
		System.out.println(parkA.getEmptyRegularSpacesCount());
	}
		

}
