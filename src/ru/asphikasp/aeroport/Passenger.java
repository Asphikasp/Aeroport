package ru.asphikasp.aeroport;

import java.security.SecureRandom;
import java.util.Random;

public class Passenger {

    enum Names{Pavel,Grisha,Roma,Vigo,Ruslan,Mari,Victor}
    enum Location{OnBoard,OnLand}

    private Names name;
    private int fligthNum;
    private Location location;

    public Passenger(int fligthNum, int random){
        this.fligthNum = fligthNum;
        name = Names.values()[random];
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public int getFligthNum() {
        return fligthNum;
    }
    public void reseiveSMS(){};
}
