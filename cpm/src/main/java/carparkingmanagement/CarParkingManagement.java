/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkingmanagement;

import java.util.Scanner;

public class CarParkingManagement {
       
    //sample input  pABC,pPQR,pGHF,uPQR
    private static SlotOperation slotmanager = new SlotOperation();
    private static int ticketNumber = 5000;

    public static void main(String[] args) {
        slotmanager.initialise();
        System.out.println("Welcome to car park management console");
        System.out.println("Please input your command (Type quit to exit)");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(processInput(sc.nextLine()));
        }
    }

    private static String processInput(String input) {
        if (input.toLowerCase().equals("quit")) {
            System.exit(0);
        }
        if (input.endsWith(",")) {
            return "Invalid input. Please remove ',' from the end ";
        } else if (input.isEmpty()) {
            return "Empty input.";
        } else {
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
            return slotmanager.printSlot(); // carParkService.getCurrentParkingOrder();
        }
    }
}
