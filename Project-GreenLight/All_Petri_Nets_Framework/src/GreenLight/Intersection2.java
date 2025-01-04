package GreenLight;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

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
        
        DataCarQueue p_x5 = new DataCarQueue();
        p_x5.Value.Size = 3;
        p_x5.SetName("P_x5");
        pn.PlaceList.add(p_x5);

        DataString p_tl5 = new DataString();
        p_tl5.SetName("TL5");
        pn.PlaceList.add(p_tl5);
        
        DataString p_tl5_left = new DataString();
        p_tl5_left.SetName("TL5_L");
        pn.PlaceList.add(p_tl5_left);

        DataCar p_b5 = new DataCar();
        p_b5.SetName("P_b5");
        pn.PlaceList.add(p_b5);

        DataTransfer op1 = new DataTransfer();
        op1.SetName("OP1");
        op1.Value = new TransferOperation("localhost", "1081", "in1");
        pn.PlaceList.add(op1);






        // -------------------------------------------------------------------------------------
        // --------------------------------Lane2 - Strada Nerva Traian ----------------
        // -------------------------------------------------------------------------------------






        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection1-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue p_i2 = new DataCarQueue();
        p_i2.Value.Size = 3;
        p_i2.SetName("P_I2");
        pn.PlaceList.add(p_i2);


        // T_u5 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T_u5";
        t1.InputPlaceName.add("P_a5");
        t1.InputPlaceName.add("P_x5");

        Condition T1Ct1 = new Condition(t1, "P_a5", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P_x5", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t1, "P_a5", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t1, "P_x5", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P_a5", TransitionOperation.AddElement, "P_x5"));
        t1.GuardMappingList.add(grdT1);

        GuardMapping grdT1_new = new GuardMapping();
        grdT1_new .condition = T1Ct3;
        grdT1_new .Activations.add(new Activation(t1, "P_a5", TransitionOperation.Move, "P_a5"));
        grdT1_new .Activations.add(new Activation(t1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1_new);

        t1.Delay = 0;
        pn.Transitions.add(t1);
        
        // T_e5 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T_e5";
        t2.InputPlaceName.add("P_x5");
        t2.InputPlaceName.add("P_b5");

        Condition T2Ct1 = new Condition(t2, "P_x5", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "P_b5", TransitionCondition.CanAddCars);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        Condition T2Ct3 = new Condition(t2, "P_a5", TransitionCondition.NotNull);
        Condition T2Ct4 = new Condition(t2, "P_x5", TransitionCondition.CanNotAddCars);
        T2Ct3.SetNextCondition(LogicConnector.AND, T2Ct4);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P_x5", TransitionOperation.AddElement, "P_b5"));
        t2.GuardMappingList.add(grdT1);

        GuardMapping grdT2_new = new GuardMapping();
        grdT2_new .condition = T1Ct3;
        grdT2_new .Activations.add(new Activation(t2, "P_x5", TransitionOperation.Move, "P_x5"));
        grdT2_new .Activations.add(new Activation(t2, "full", TransitionOperation.SendOverNetwork, "OP1"));
        t2.GuardMappingList.add(grdT2_new);

        t2.Delay = 0;
        pn.Transitions.add(t2);
        
        
        PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

    }

    }
