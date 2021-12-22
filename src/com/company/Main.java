package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        double Knad = 1.2;

        ArrayList<Busbar> busesnow = new ArrayList<>();
        Busbar buses[] = new Busbar[11];
        Busbar busbarForChange = new Busbar();

        Busbar b1 = new Busbar();
        Busbar b11 = new Busbar();
        Busbar b111 = new Busbar();
        Busbar b112 = new Busbar();
        Busbar b12 = new Busbar();
        Busbar b13 = new Busbar();
        Busbar b131 = new Busbar();
        Busbar b1311 = new Busbar();
        Busbar b1312 = new Busbar();
        Busbar b132 = new Busbar();


        b1.setPosition(1);
        b11.setPosition(11);
        b111.setPosition(111);
        b112.setPosition(112);
        b12.setPosition(12);
        b13.setPosition(13);
        b131.setPosition(131);
        b1311.setPosition(1311);
        b1312.setPosition(1312);
        b132.setPosition(132);

        b1.setShortCircuitCurrent(30); //значение КЗ шины на конце защищаемой линии
        b11.setShortCircuitCurrent(14);
        b111.setShortCircuitCurrent(-1);
        b112.setShortCircuitCurrent(-1);
        b12.setShortCircuitCurrent(-1);
        b13.setShortCircuitCurrent(20);
        b131.setShortCircuitCurrent(15);
        b1311.setShortCircuitCurrent(-1);
        b1312.setShortCircuitCurrent(-1);
        b132.setShortCircuitCurrent(-1);

        buses[0] = b1;
        buses[1] = b11;
        buses[2] = b111;
        buses[3] = b112;
        buses[4] = b12;
        buses[5] = b13;
        buses[6] = b131;
        buses[7] = b1311;
        buses[8] = b1312;
        buses[9] = b132;
        buses[10] = busbarForChange;

        //Поиск токов первой ступени
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getShortCircuitCurrent() == -1){
                buses[i].setCurrentOne(-1);
            }else {
                buses[i].setCurrentOne(buses[i].getShortCircuitCurrent()*Knad);
            }
        }

        b1.setCurrentTwo(findCurrentTwo(b1, buses));


        b1.ShowSteps();
        b11.ShowSteps();
        b12.ShowSteps();
        b13.ShowSteps();
        b131.ShowSteps();
    }


    public static double findCurrentTwo(Busbar b, Busbar busess[]) {

        ArrayList<Busbar> busesnoww = new ArrayList<>();
        Busbar busbarForChange = busess[10];
        double currentOneMax=0;
        double currentTwo=0;
        double Knad = 1.2;


        for (int i = 0; i < 10; i++) {
            if (((busess[i].getPosition()/10) == (b.getPosition()))) {
                busesnoww.add(busess[i]);
            }
        }
        for (int i=0; i<busesnoww.size(); i++) {
            busbarForChange=busesnoww.get(i);
            if (busbarForChange.getShortCircuitCurrent() != -1){
                busbarForChange.setCurrentTwo(findCurrentTwo(busbarForChange, busess));
                busesnoww.set(i, busbarForChange);
            }
            

            if (busesnoww.get(i).getCurrentOne() > currentOneMax) {
                currentOneMax = busesnoww.get(i).getCurrentOne();
                currentTwo = currentOneMax * Knad;
            }
        }
        return currentTwo;
    }
}
