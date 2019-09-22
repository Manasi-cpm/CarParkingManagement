package carparkingmanagement;

import java.util.Arrays;

class SlotOperation {

    private slot slot[];
    private final int slotsize=10;

    public SlotOperation() {
        slot = new slot[slotsize];
    }

    public void initialise(){
        for(int i=0;i<slotsize;i++){
            slot[i]=new slot();
            slot[i].setLicencePlate("");
            slot[i].setTicketNumber(0);
            
        }
    }
    public boolean ParkCar(String carnoplate, int ticktNumber) {
        Boolean slotfound = false;
        for (int i = 0; i < 10; i++) {
                if (slot[i].getLicencePlate().length() == 0) {
                    slot[i].setLicencePlate(carnoplate);
                    slot[i].setTicketNumber(ticktNumber);
                    slotfound = true;
                    return slotfound;
            }
        }
        if(!slotfound)System.out.println("Car Park full could not park "+carnoplate);
        return false;
    }

    public boolean UnParkCarByPlate(String carnoplate) {
        Boolean slotfound = false;
        Boolean unparkedcar =false;
        for (int i = 0; i < 10; i++) {
            if (slot[i].getLicencePlate().equals(carnoplate)) {
                slotfound = true;
                slot[i].setLicencePlate("");
                slot[i].setTicketNumber(0);
                unparkedcar=true;
            }
        }
        if(!slotfound) System.out.println("car with "+carnoplate+ " licence plate not found in parking !");
        return unparkedcar;        
    }
    
    public boolean UnParkCarByTicketNumber(int ticketnum) {
        Boolean slotfound = false;
        Boolean unparkedcar =false;
        for (int i = 0; i < 10; i++) {
            if (slot[i].getTicketNumber()==ticketnum) {
                slotfound = true;
                slot[i].setLicencePlate("");
                slot[i].setTicketNumber(0);
                unparkedcar=true;
            }
        }
        if(!slotfound) System.out.println("car with "+ticketnum+ " Ticket number not found in parking !");
        return unparkedcar;        
    }

    public String printSlot() {
        String output[] =new String[10];
        for (int i = 0; i < 10; i++) {
            output[i] = slot[i].licencePlate;
        }
        return Arrays.toString(output);
    }
    
    public void compact(){
    	slot tmpslot[] = new slot[slotsize];
    	for(int i=0;i<slotsize;i++){
    		tmpslot[i]=new slot();
            tmpslot[i].setLicencePlate("");
            tmpslot[i].setTicketNumber(0);            
        }
    	    	
    	int j=0;
    	for (int i = 0; i < 10; i++) {
    		if(slot[i].getLicencePlate().length()>0)
    			tmpslot[j++].setLicencePlate(slot[i].getLicencePlate());
        }
    	
    	initialise();
    	
    	for (int i = 0; i < 10; i++) {
    		slot[i].setLicencePlate(tmpslot[i].getLicencePlate());
        }
    	
    }
}
