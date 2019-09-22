package carparkingmanagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarParkingManagementTest {

@Test	
public void test() {
	//setup
	String input="pABC,pPQR,pGHF,uPQR,u5001,u5005,pZZZ,u5003,c"; int ticketNumber=5000;
	//execute
	SlotOperation slotmanager = new SlotOperation();
	slotmanager.initialise();
	String[] inputArray = input.split(",");
    for (String s : inputArray) {
        switch (s.charAt(0)) {
            case 'p':
                slotmanager.ParkCar(s.substring(1), ticketNumber);
                ticketNumber++;
                break;
            case 'u': 
            	int ticketnum;
            	try {ticketnum= Integer.parseInt(s.substring(1));
                slotmanager.UnParkCarByTicketNumber(ticketnum);  
            	}catch(java.lang.NumberFormatException e) {
            		System.out.println("non numeric ticket number :("+s.substring(1)+")");
            	}
                break;
            case 'c':
                slotmanager.compact();
                break;
            default:
            	System.out.println("Invalid input. Input shoud startwith p/u/c");
            	break;
        }
    }
    String result = slotmanager.printSlot();
	//assert
    String expectedResult= "[ABC, GHF, , , , , , , , ]";
	assertEquals(expectedResult, result);
}
}
