package ru.asphikasp.aeroport;

import java.util.Random;

public class Main {

    private static final Random random = new Random();
    public static void main(String[] args) {
	// write your code here
    // Создается центр управления и самолет
        ControlCenter cC = new ControlCenter(ControlCenter.Sizes.values()[random.nextInt(ControlCenter.Sizes.values().length)]);
        Plane plane = new Plane(
                Plane.Bodytype.values()[random.nextInt(Plane.Bodytype.values().length)],
                Plane.Location.Air
        );
    // Генерируются пассажиры
        int passNum;
        switch (plane.getBodytype()){
            case Air_Bus:
                passNum = random.nextInt(20) + 80;
                break;
            case BUISNESS_JET:
                passNum = random.nextInt(5) + 15;
                break;
            case Сrop_duster:
                passNum = random.nextInt(2) + 3;
                break;
            case Helicopter:
                passNum = random.nextInt(8) + 2;
                break;
            default:
                passNum = 20;
        }
        Passenger passengers[] = new Passenger[passNum];
        // Создается номер полета
        int fligthNum1 = random.nextInt(100);
        plane.setFlightNum(fligthNum1);
        // Пассажиры наполняются информацией
        for(int i = 0;i<passNum;i++){
                passengers[i] = new Passenger(fligthNum1, random.nextInt(Passenger.Names.values().length));
        }
        // Пассажиры садятся в самолет
        plane.setPassengers(passengers);
        // Время прибытия выводится на табло
        System.out.println(plane.toString()+" - arrival at "+plane.getLandingTime()+" hours");
        // Запрос на посадку и попытка сесть.
        if(cC.landingRequest(plane)){
            plane.tryLand(cC.getLandingStrip(plane),cC);
        } else {
            System.out.println("Landing request denied");
        }
        if(plane.landingTime < System.currentTimeMillis()){
            System.out.println(plane.toString() + " - was delayed");
        }
        if(plane.getLocation() == Plane.Location.Hangar) {
            System.out.println(plane.toString() + " - landed successful. \nTotal "+passNum+" passengers income");
        }
        System.out.println(cC.getSize());
    }
}
