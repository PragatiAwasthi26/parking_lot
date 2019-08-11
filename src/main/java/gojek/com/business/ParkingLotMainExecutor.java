package gojek.com.business;

import gojek.com.beans.Car;

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
                regNo = commandLine[1];
                colour = commandLine[2];
                parkingres = parkingLot.parkCar(new Car(regNo, colour));
                if (parkingres != -1) {
                    System.out.println("Allocated Slot Number: " + parkingres);
                } else
                    System.out.println("Sorry, parking lot is full");
                break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }
    }
}

