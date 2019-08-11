package gojek.com.gojek.com.utility;

public enum ParkingCommands {

    CREATE,PARK,LEAVE,STATUS, REG_NUMBERS, SLOT_COLOUR, SLOT_REG;

    public static ParkingCommands getCommand(String comm){
        if(ParkingConstants.CREATE.equals(comm))
            return CREATE;
        else if(ParkingConstants.PARK.equals(comm))
            return PARK;
        else if(ParkingConstants.LEAVE.equals(comm))
            return LEAVE;
        else if(ParkingConstants.STATUS.equals(comm))
            return STATUS;
        else if(ParkingConstants.REG_NUMBERS.equals(comm))
            return REG_NUMBERS;
        else if(ParkingConstants.SLOT_COLOUR.equals(comm))
            return SLOT_COLOUR;
        else if(ParkingConstants.SLOT_REG.equals(comm))
            return SLOT_REG;
        else
            return null;

    }
}
