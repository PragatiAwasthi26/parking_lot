package gojek.com.business;

import gojek.com.beans.Car;
import java.util.HashMap;
import java.util.TreeSet;

public class ParkingLotImpl {
    private int capacity;
    private int availability;
    private HashMap<Integer, Car> parkingLotMap;
    private TreeSet<Integer> freeSlots;

    public ParkingLotImpl(int c) {
        capacity = c;
        availability = c;
        parkingLotMap = new HashMap<Integer, Car>();
        freeSlots = new TreeSet<Integer>();
        for (int i = 0; i < capacity; i++) {
            parkingLotMap.put(i, null);
            freeSlots.add(i);
        }
    }

    public int parkCar(Car c) {
        int nextAvail;
        if (availability == 0) {
            return -1;
        } else {
            nextAvail = freeSlots.first();
            parkingLotMap.put(nextAvail, c);
            availability--;
            freeSlots.remove(nextAvail);
        }
        return (nextAvail + 1);
    }
}
