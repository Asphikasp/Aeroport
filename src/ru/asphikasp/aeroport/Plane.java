package ru.asphikasp.aeroport;

public class Plane implements Landable{

    enum Bodytype {Air_Bus,Jet,CropDuster,Helicopter}
    enum Location {Air,LandingStrip,Hangar}

    private Bodytype bodytype;
    private Location location;
    private int flightNum;
    private Passenger[] passengers;
    public long landingTime = System.currentTimeMillis() - 4000;

    public Plane(Bodytype bodytype, Location location) {
        this.bodytype = bodytype;
        this.location = location;
    }

    public Bodytype getBodytype() {
        return bodytype;
    }
    public int getFlightNum() {
        return flightNum;
    }
    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }
    public Location getLocation() {
        return location;
    }
    public long getLandingTime() {
        return landingTime;
    }
    public void setPassengers(Passenger[] passengers){
        this.passengers = new Passenger[passengers.length];
        for(int i = 0;i< passengers.length;i++){
            this.passengers[i] = passengers[i];
        }
    }
    public void tryLand(LandingStrip landingStrip, ControlCenter controlCenter){
        if(location == Location.Air && landingStrip.getState() == LandingStrip.State.Empty) {
           // try {
                landingStrip.setState(LandingStrip.State.NotEmpty);
                if(landingTime < System.currentTimeMillis()) controlCenter.sMS(passengers);
           //     Thread.sleep(2000);
                location = Location.LandingStrip;
           //     Thread.sleep(800);
                for(int i =0;i< passengers.length;i++){
                    passengers[i].setLocation(Passenger.Location.OnLand);
                }
                passengers = new Passenger[0];
                location = Location.Hangar;
                landingStrip.setState(LandingStrip.State.Empty);
          //  } catch (InterruptedException e) {}
        } else {
            return;
        }
    }
    public String toString(){
        return ("Aircraft type of "+bodytype+" location: "+location+" Flight Number: "+flightNum+" ");
    }
}
