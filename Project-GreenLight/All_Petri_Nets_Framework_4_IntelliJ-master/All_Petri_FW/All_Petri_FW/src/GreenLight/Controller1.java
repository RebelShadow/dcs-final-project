package GreenLight;

import Components.PetriNet;
import DataObjects.DataString;

public class Controller1 {
    public static void main(String[] args){
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller1";
        pn.SetName("Controller1");
        pn.NetworkPort = 1081;

        DataString red = new DataString();
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);




    }


}
