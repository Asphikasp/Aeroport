package ru.asphikasp.aeroport;

public class LandingStrip {

    enum Size {Long,Medium,Short,Helicopter}
    enum State {NotEmpty,Empty}

    private Size size;
    private State state = State.Empty;

    public LandingStrip(Size size){
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
    public State getState(){
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public String toString(){
        return (size+"  "+state);
    }
}
