package GreenLight;

import Components.PetriNet;
import DataObjects.DataCar;
import DataObjects.DataString;

public class Intersection2 {
    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersection1";

        pn.NetworkPort = 1082;

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.Printable = false;
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane3 - Bulevardul Unirii -----------------
        // -------------------------------------------------------------------------------------

        // Entrance of lane 3 into intersection2
        DataCar p_a5 = new DataCar();
        p_a5.SetName("P_a5");
        pn.PlaceList.add(p_a5);





        // -------------------------------------------------------------------------------------
        // --------------------------------Lane2 - Strada Nerva Traian ----------------
        // -------------------------------------------------------------------------------------







    }

    }
