package gojek.com.business;

import gojek.com.beans.Car;
import gojek.com.gojek.com.utility.ParkingCommands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParkingLotMainExecutor {
    public static void main(String[] args) throws Exception {
        ParkingLotImpl parkingLot = null;
        try {
            File file =
                    new File("C:\\Users\\Divyam\\IdeaProjects\\parking_lot_1.4.2\\parking_lot file_inputs.txt");
            Scanner sc = new Scanner(file);
            String line;
            String command;
            String regNo, colour;
            int parkingres;
            int num;
            line = sc.nextLine();
            int count = Integer.parseInt(line.split(" ")[1]);
            parkingLot = new ParkingLotImpl(count);
            System.out.println("Created a parking lot with " + count + " slots");
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] commandLine = line.split(" ");
                command = commandLine[0];
                switch(ParkingCommands.getCommand(command)){
                    case LEAVE:
                        num = Integer.parseInt(commandLine[1]);
                        parkingLot.leaveCar(num-1);
                        System.out.println("Slot number "+num+" is free");
                        break;
                    case PARK:
                        regNo = commandLine[1];
                        colour = commandLine[2];
                        parkingres =parkingLot.parkCar(new Car(regNo, colour));
                        if(parkingres != -1){
                            System.out.println("Allocated Slot Number: "+parkingres);
                        }
                        else
                            System.out.println("Sorry, parking lot is full");
                        break;
                    case REG_NUMBERS:
                        colour = commandLine[1];
                        parkingLot.getRegNumberForColor(colour);
                        break;
                    case SLOT_COLOUR:
                        colour = commandLine[1];
                        parkingLot.getSlotNumberForColor(colour);
                        break;
                    case SLOT_REG:
                        regNo = commandLine[1];
                        parkingres = parkingLot.getSlotNumberForReqNumber(regNo);
                        if(parkingres != -1){
                            System.out.println(parkingres);
                        }
                        else
                            System.out.println("Not Found");
                        break;
                    case STATUS:
                        parkingLot.getStatus();
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}