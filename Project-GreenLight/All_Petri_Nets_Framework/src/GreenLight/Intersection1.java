package GreenLight;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersection1 {
    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersection1";

        pn.NetworkPort = 1080;

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
        // --------------------------------Lane1 - Bulevardul Unirii - stanga -----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a1 = new DataCar();
        p_a1.SetName("P_a1");
        pn.PlaceList.add(p_a1);

        DataCarQueue p_x1 = new DataCarQueue();
        p_x1.Value.Size = 3;
        p_x1.SetName("P_x1");
        pn.PlaceList.add(p_x1);

        DataString p_tl1 = new DataString();
        p_tl1.SetName("TL1");
        pn.PlaceList.add(p_tl1);

        DataCar p_b1 = new DataCar();
        p_b1.SetName("P_b1");
        pn.PlaceList.add(p_b1);

        DataTransfer op1 = new DataTransfer();
        op1.SetName("OP1");
        op1.Value = new TransferOperation("localhost", "1081", "in1");
        pn.PlaceList.add(op1);

        // -------------------------------------------------------------------------------------
        // --------------------------------Lane3 - Bulevardul Unirii - dreapta -----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a3 = new DataCar();
        p_a3.SetName("P_a3");
        pn.PlaceList.add(p_a3);

        DataCarQueue p_x3 = new DataCarQueue();
        p_x3.Value.Size = 3; //Nu stiu ce i asta
        p_x3.SetName("P_x1");
        pn.PlaceList.add(p_x3);

        DataString p_tl3 = new DataString();
        p_tl3.SetName("TL3");
        pn.PlaceList.add(p_tl3);

        DataCar p_b3 = new DataCar();
        p_b3.SetName("P_b3");
        pn.PlaceList.add(p_b3);

        DataTransfer op3 = new DataTransfer();
        op3.SetName("OP3");
        op3.Value = new TransferOperation("localhost", "1081", "in3");
        pn.PlaceList.add(op3);



        // -------------------------------------------------------------------------------------
        // --------------------------------Lane2 - Bulevardul Mircea Voda - jos ----------------
        // -------------------------------------------------------------------------------------
        DataCar p_a2 = new DataCar(); //p5.Printable = false;
        p_a2.SetName("P_a2");
        pn.PlaceList.add(p_a2);

        DataCarQueue p_x2 = new DataCarQueue(); //p6.Printable = false;
        p_x2.Value.Size = 3;
        p_x2.SetName("P_x2");
        pn.PlaceList.add(p_x2);

        DataString p_tl2 = new DataString(); //p7.Printable = false;
        p_tl2.SetName("TL2");
        pn.PlaceList.add(p_tl2);

        DataCar p_b2 = new DataCar(); //p8.Printable = false;
        p_b2.SetName("P_b2");
        pn.PlaceList.add(p_b2);

        DataTransfer op2 = new DataTransfer();
        op2.SetName("OP2");
        op2.Value = new TransferOperation("localhost", "1081", "in2");
        pn.PlaceList.add(op2);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane4 - Bulevardul Mircea Voda - sus ----------------
        // -------------------------------------------------------------------------------------
        DataCar p_a4 = new DataCar(); //p5.Printable = false;
        p_a4.SetName("P_a4");
        pn.PlaceList.add(p_a4);

        DataCarQueue p_x4 = new DataCarQueue(); //p6.Printable = false;
        p_x4.Value.Size = 3;
        p_x4.SetName("P_x4");
        pn.PlaceList.add(p_x4);

        DataString p_tl4 = new DataString(); //p7.Printable = false;
        p_tl4.SetName("TL4");
        pn.PlaceList.add(p_tl4);

        DataCar p_b4 = new DataCar(); //p8.Printable = false;
        p_b4.SetName("P_b4");
        pn.PlaceList.add(p_b4);

        DataTransfer op4 = new DataTransfer();
        op4.SetName("OP4");
        op4.Value = new TransferOperation("localhost", "1081", "in4");
        pn.PlaceList.add(op4);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane1 - Bulevardul Unirii stanga-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o3 = new DataCarQueue(); //p10.Printable = false;
        p_o3.Value.Size = 3;
        p_o3.SetName("P_o3");
        pn.PlaceList.add(p_o3);

        DataCar p_o3exit = new DataCar();
        p_o3exit.SetName("P_O3Exit");
        pn.PlaceList.add(p_o3exit);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane2 - Bulevardul Mircea Voda jos-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o4 = new DataCarQueue(); //p10.Printable = false;
        p_o4.Value.Size = 3;
        p_o4.SetName("P_o4");
        pn.PlaceList.add(p_o4);

        DataCar p_o4exit = new DataCar();
        p_o4exit.SetName("P_O4Exit");
        pn.PlaceList.add(p_o4exit);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane4 - Bulevardul Mircea Voda sus-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o2 = new DataCarQueue(); //p10.Printable = false;
        p_o2.Value.Size = 3;
        p_o2.SetName("P_o2");
        pn.PlaceList.add(p_o2);

        DataCar p_o2exit = new DataCar();
        p_o2exit.SetName("P_O2Exit");
        pn.PlaceList.add(p_o2exit);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane3 - Bulevardul Unirii dreapta-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o1 = new DataCarQueue(); //p10.Printable = false;
        p_o1.Value.Size = 3;
        p_o1.SetName("P_o1");
        pn.PlaceList.add(p_o1);

        DataCar p_o1exit = new DataCar();
        p_o1exit.SetName("P_O1Exit");
        pn.PlaceList.add(p_o1exit);

        //Data Transfer place for lane 3 to send to the next intersection

        DataTransfer op_int2 = new DataTransfer();
        op_int2.SetName("OP_Int2");
        op_int2.Value = new TransferOperation("localhost", "1082", "P_a5");
        pn.PlaceList.add(op_int2);

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection1-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue p_i1 = new DataCarQueue();
        p_i1.Value.Size = 3;
        p_i1.SetName("P_I1");
        pn.PlaceList.add(p_i1);


        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T_u1";
        t1.InputPlaceName.add("P_a1");
        t1.InputPlaceName.add("P_x1");

        Condition T1Ct1 = new Condition(t1, "P_a1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P_x1", TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t1, "P_a1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t1, "P_x1", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        t1.GuardMappingList.add(grdT1);

        GuardMapping grdT1_new = new GuardMapping();
        grdT1_new .condition = T1Ct3;
        grdT1_new .Activations.add(new Activation(t1, "P_a1", TransitionOperation.Move, "P_a1"));
        grdT1_new .Activations.add(new Activation(t1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1_new);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T_e1";
        t2.InputPlaceName.add("P_x1");
        t2.InputPlaceName.add("TL1");

        Condition T2Ct1 = new Condition(t2, "TL1", TransitionCondition.Equal, "green");
        Condition T2Ct2 = new Condition(t2, "P_x1", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdT2.Activations.add(new Activation(t2, "TL1", TransitionOperation.Move, "TL1"));

        t2.GuardMappingList.add(grdT2);


        t2.Delay = 0;
        pn.Transitions.add(t2);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T_u2";
        t3.InputPlaceName.add("P_a2");
        t3.InputPlaceName.add("P_x2");

        Condition T3Ct1 = new Condition(t3, "P_a2", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P_x2", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition T3Ct3 = new Condition(t3, "P_a2", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(t3, "P_x2", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P_a2", TransitionOperation.AddElement, "P_x2"));
        t3.GuardMappingList.add(grdT3);

        GuardMapping grdT3_new = new GuardMapping();
        grdT3_new .condition = T3Ct3;
        grdT3_new .Activations.add(new Activation(t3, "P_a2", TransitionOperation.Move, "P_a2"));
        grdT3_new .Activations.add(new Activation(t3, "full", TransitionOperation.SendOverNetwork, "OP2"));
        t3.GuardMappingList.add(grdT3_new);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        // T4 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T_e2";
        t4.InputPlaceName.add("P_x2");
        t4.InputPlaceName.add("TL2");

        Condition T4Ct1 = new Condition(t4, "TL2", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(t4, "P_x2", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
        grdT4.Activations.add(new Activation(t4, "TL2", TransitionOperation.Move, "TL2"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T_u4";
        t5.InputPlaceName.add("P_a4");
        t5.InputPlaceName.add("P_x4");

        Condition T5Ct1 = new Condition(t5, "P_a4", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "P_x4", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        Condition T5Ct3 = new Condition(t5, "P_a4", TransitionCondition.NotNull);
        Condition T5Ct4 = new Condition(t5, "P_x4", TransitionCondition.CanNotAddCars);
        T5Ct3.SetNextCondition(LogicConnector.AND, T5Ct4);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P_a4", TransitionOperation.AddElement, "P_x4"));
        t5.GuardMappingList.add(grdT5);

        GuardMapping grdT5_new = new GuardMapping();
        grdT5_new .condition = T5Ct3;
        grdT5_new .Activations.add(new Activation(t5, "P_a4", TransitionOperation.Move, "P_a4"));
        grdT5_new .Activations.add(new Activation(t5, "full", TransitionOperation.SendOverNetwork, "OP4"));
        t5.GuardMappingList.add(grdT5_new);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T_e4";
        t6.InputPlaceName.add("P_x4");
        t6.InputPlaceName.add("TL4");

        Condition T6Ct1 = new Condition(t6, "TL4", TransitionCondition.Equal, "green");
        Condition T6Ct2 = new Condition(t6, "P_x4", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
        grdT6.Activations.add(new Activation(t6, "TL4", TransitionOperation.Move, "TL4"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);

        // T7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T_u3";
        t7.InputPlaceName.add("P_a3");
        t7.InputPlaceName.add("P_x3");

        Condition T7Ct1 = new Condition(t7, "P_a3", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t7, "P_x3", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        Condition T7Ct3 = new Condition(t7, "P_a3", TransitionCondition.NotNull);
        Condition T7Ct4 = new Condition(t7, "P_x3", TransitionCondition.CanNotAddCars);
        T7Ct3.SetNextCondition(LogicConnector.AND, T7Ct4);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "P_a3", TransitionOperation.AddElement, "P_x3"));
        t7.GuardMappingList.add(grdT7);

        GuardMapping grdT7_new = new GuardMapping();
        grdT7_new .condition = T7Ct3;
        grdT7_new .Activations.add(new Activation(t7, "P_a3", TransitionOperation.Move, "P_a3"));
        grdT7_new .Activations.add(new Activation(t7, "full", TransitionOperation.SendOverNetwork, "OP3"));
        t7.GuardMappingList.add(grdT7_new);

        t7.Delay = 0;
        pn.Transitions.add(t7);

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T_e3";
        t8.InputPlaceName.add("P_x3");
        t8.InputPlaceName.add("TL3");

        Condition T8Ct1 = new Condition(t8, "TL3", TransitionCondition.Equal, "green");
        Condition T8Ct2 = new Condition(t8, "P_x3", TransitionCondition.HaveCar);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t8, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b4"));
        grdT8.Activations.add(new Activation(t8, "TL3", TransitionOperation.Move, "TL3"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);
        
        PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

    }

}
