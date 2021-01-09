package ru.asphikasp.aeroport;

public class ControlCenter {

    enum Sizes {High,Medium,Short}

    private Sizes size;
    //private int range;
    LandingStrip[] landingStrips;

    public ControlCenter(Sizes size){
        this.size = size;
        switch (size){
            case High:
                //range = 5000;
                landingStrips = new LandingStrip[4];
                landingStrips[0] = new LandingStrip(LandingStrip.Size.Long);
                landingStrips[1] = new LandingStrip(LandingStrip.Size.Medium);
                landingStrips[2] = new LandingStrip(LandingStrip.Size.Medium);
                landingStrips[3] = new LandingStrip(LandingStrip.Size.Helicopter);
                break;
            case Medium:
                //range = 3200;
                landingStrips = new LandingStrip[2];
                landingStrips[0] = new LandingStrip(LandingStrip.Size.Medium);
                landingStrips[0].setState(LandingStrip.State.NotEmpty);
                landingStrips[1] = new LandingStrip(LandingStrip.Size.Medium);
                break;
            case Short:
                //range = 1500;
                landingStrips = new LandingStrip[1];
                landingStrips[0] = new LandingStrip(LandingStrip.Size.Short);
                break;
        }
    }

    public boolean landingRequest(Plane plane){
        if(checkFlight(plane) && canLand(plane) && plane.getLocation() == Plane.Location.Air){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {return false;}
            return true;
        } else {
            return false;
        }
    }
    public LandingStrip getLandingStrip(Plane plane){
        switch (plane.getBodytype()) {
            case Air_Bus:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                break;
            case BUISNESS_JET:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Medium && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                break;
            case Сrop_duster:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Short && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Medium && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                break;
            case Helicopter:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Helicopter && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return landingStrips[i];
                }
                break;
        }
        return null;
    }
    private boolean canLand(Plane plane){
        switch (plane.getBodytype()) {
            case Air_Bus:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                break;
            case BUISNESS_JET:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Medium && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                break;
            case Сrop_duster:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Short && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Medium && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Long && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                break;
            case Helicopter:
                for (int i = 0; i < landingStrips.length; i++) {
                    if(landingStrips[i].getSize() == LandingStrip.Size.Helicopter && landingStrips[i].getState() == LandingStrip.State.NotEmpty)
                        return true;
                }
                break;
        }
        return false;
    }
    private boolean checkFlight(Plane plane){
        if(plane.getFlightNum() != 66) {
            return true;
        } else {
            return false;
        }
    }

    public Sizes getSize() {
        return size;
    }

    public void sMS(Passenger[] p){
        for(int i = 0;i<p.length;i++){
            p[i].reseiveSMS();
        }
    }
}
