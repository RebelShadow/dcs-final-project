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
        pn.PetriNetName = "Intersection2";

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
        // --------------------------------Lane1 - Bulevardul Unirii stanga -----------------
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

        DataString p_ptl5 = new DataString();
        p_ptl5.SetName("TL5");
        pn.PlaceList.add(p_ptl5);

        DataString UserReq_5 = new DataString();
        p_ptl5.SetName("USR_5");
        pn.PlaceList.add(UserReq_5);

        DataTransfer OPreq_5 = new DataTransfer();
        OPreq_5.SetName("Preq_5");
        pn.PlaceList.add(OPreq_5);

        DataCar p_b5 = new DataCar();
        p_b5.SetName("P_b5");
        pn.PlaceList.add(p_b5);

        DataTransfer OP7 = new DataTransfer();
        OP7.SetName("OP7");
        OP7.Value = new TransferOperation("localhost", "1081", "IN7");
        pn.PlaceList.add(OP7);



        // -------------------------------------------------------------------------------------
        // --------------------------------Lane2 - Bulevardul Unirii - dreapta -----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a7 = new DataCar();
        p_a7.SetName("P_a7");
        pn.PlaceList.add(p_a7);

        DataCarQueue p_x7 = new DataCarQueue();
        p_x7.Value.Size = 3;
        p_x7.SetName("P_x7");
        pn.PlaceList.add(p_x7);

        DataString p_tl7 = new DataString();
        p_tl7.SetName("TL7");
        pn.PlaceList.add(p_tl7);

        DataString p_tl7_left = new DataString();
        p_tl7_left.SetName("TL7_L");
        pn.PlaceList.add(p_tl7_left);

        DataCar p_b7 = new DataCar();
        p_b7.SetName("P_b7");
        pn.PlaceList.add(p_b7);

        DataTransfer OP9 = new DataTransfer();
        OP9.SetName("OP9");
        OP9.Value = new TransferOperation("localhost", "1083", "IN9");
        pn.PlaceList.add(OP9);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane3 - Strada Nerva Traian ----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a6 = new DataCar(); //p5.Printable = false;
        p_a6.SetName("P_a6");
        pn.PlaceList.add(p_a6);

        DataCarQueue p_x6 = new DataCarQueue(); //p6.Printable = false;
        p_x6.Value.Size = 3;
        p_x6.SetName("P_x6");
        pn.PlaceList.add(p_x6);

        DataString p_tl6 = new DataString(); //p7.Printable = false;
        p_tl6.SetName("TL6");
        pn.PlaceList.add(p_tl6);


        DataCar p_b6 = new DataCar(); //p8.Printable = false;
        p_b6.SetName("P_b6");
        pn.PlaceList.add(p_b6);

        DataTransfer OP8 = new DataTransfer();
        OP8.SetName("OP8");
        OP8.Value = new TransferOperation("localhost", "1083", "IN8");
        pn.PlaceList.add(OP8);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane4 - Strada Traian ----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a8 = new DataCar(); //p5.Printable = false;
        p_a8.SetName("P_a8");
        pn.PlaceList.add(p_a8);

        DataCarQueue p_x8 = new DataCarQueue(); //p6.Printable = false;
        p_x8.Value.Size = 3;
        p_x8.SetName("P_x8");
        pn.PlaceList.add(p_x8);

        DataString p_tl8 = new DataString(); //p7.Printable = false;
        p_tl8.SetName("TL8");
        pn.PlaceList.add(p_tl8);

        DataCar p_b8 = new DataCar(); //p8.Printable = false;
        p_b8.SetName("P_b8");
        pn.PlaceList.add(p_b8);

        DataTransfer OP10 = new DataTransfer();
        OP10.SetName("OP10");
        OP10.Value = new TransferOperation("localhost", "1083", "IN10");
        pn.PlaceList.add(OP10);
        
        DataTransfer OP11 = new DataTransfer();
        OP11.SetName("OP11");
        OP11.Value = new TransferOperation("localhost", "1083", "IN11");
        pn.PlaceList.add(OP11);
        
        
        DataTransfer OP12 = new DataTransfer();
        OP12.SetName("OP12");
        OP12.Value = new TransferOperation("localhost", "1080", "P_a3");
        pn.PlaceList.add(OP12);

        DataTransfer OP13 = new DataTransfer();
        OP13.SetName("OP13");
        OP13.Value = new TransferOperation("localhost", "1083", "IN13");
        pn.PlaceList.add(OP13);
        
        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane1 - Bulevardul Unirii stanga-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o7 = new DataCarQueue();
        p_o7.Value.Size = 3;
        p_o7.SetName("P_o7");
        pn.PlaceList.add(p_o7);

        DataCarQueue Px5_o7 = new DataCarQueue();
        Px5_o7.Value.Size = 3;
        Px5_o7.SetName("Px5_o7");
        pn.PlaceList.add(Px5_o7);

        DataCarQueue PS_o7 = new DataCarQueue();
        PS_o7.Value.Size = 3;
        PS_o7.SetName("PS_o7");
        pn.PlaceList.add(PS_o7);

        DataCarQueue Px6_o7 = new DataCarQueue();
        Px6_o7.Value.Size = 3;
        Px6_o7.SetName("Px6_o7");
        pn.PlaceList.add(Px6_o7);

        DataString Usreq_o7 = new DataString();
        Usreq_o7.SetName("Usreq_o7");
        pn.PlaceList.add(Usreq_o7);

        DataCar Pt6_o7 = new DataCar();
        Pt6_o7.SetName("Pt6_o7");
        pn.PlaceList.add(Pt6_o7);

        DataCar Pt7_o7 = new DataCar();
        Pt7_o7.SetName("Pt7_o7");
        pn.PlaceList.add(Pt7_o7);

        DataCar PExit_car7 = new DataCar();
        PExit_car7.SetName("Pexit_car7");
        pn.PlaceList.add(PExit_car7);
        
        

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane2 - Bulevardul Mircea Voda jos-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o8 = new DataCarQueue(); //p10.Printable = false;
        p_o8.Value.Size = 3;
        p_o8.SetName("P_o8");
        pn.PlaceList.add(p_o8);

        DataCar p_o8exit = new DataCar();
        p_o8exit.SetName("P_O8Exit");
        pn.PlaceList.add(p_o8exit);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane4 - Strada Traian-------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o6 = new DataCarQueue(); //p10.Printable = false;
        p_o6.Value.Size = 3;
        p_o6.SetName("P_o6");
        pn.PlaceList.add(p_o6);

        DataCar p_o6exit = new DataCar();
        p_o6exit.SetName("P_O6Exit");
        pn.PlaceList.add(p_o6exit);

        // -------------------------------------------------------------------------------------
        // --------------------------------Exit lane3 - Strada Nerva Traian -------
        // -------------------------------------------------------------------------------------

        //Car queue for exit
        DataCarQueue p_o5 = new DataCarQueue(); //p10.Printable = false;
        p_o5.Value.Size = 3;
        p_o5.SetName("P_o5");
        pn.PlaceList.add(p_o5);

        DataCar Pexit_car5 = new DataCar();
        Pexit_car5.SetName("Pexit_car5");
        pn.PlaceList.add(Pexit_car5);
        
        

        // -------------------------------------------------------------------------------------------
        // --------------------------------Intersection2-----------------------------------------------
        // -------------------------------------------------------------------------------------------

        DataCarQueue p_i2 = new DataCarQueue();
        p_i2.Value.Size = 3;
        p_i2.SetName("P_I2");
        pn.PlaceList.add(p_i2);

        // T_u6 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T_u6";
        t3.InputPlaceName.add("P_a6");
        t3.InputPlaceName.add("P_x6");

        Condition T3Ct1 = new Condition(t3, "P_a6", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P_x6", TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition T3Ct3 = new Condition(t3, "P_a6", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(t3, "P_x6", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "P_a6", TransitionOperation.AddElement, "P_x6"));
        t3.GuardMappingList.add(grdT3);

        GuardMapping grdT3_new = new GuardMapping();
        grdT3_new .condition = T3Ct3;
        grdT3_new .Activations.add(new Activation(t3, "P_a6", TransitionOperation.Move, "P_a6"));
        grdT3_new .Activations.add(new Activation(t3, "full", TransitionOperation.SendOverNetwork, "OP10"));
        t3.GuardMappingList.add(grdT3_new);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        
        // T_e6 ------------------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T_e6";
        t4.InputPlaceName.add("P_x6");
        t4.InputPlaceName.add("TL6");

        Condition T4Ct1 = new Condition(t4, "TL6", TransitionCondition.Equal, "green");
        Condition T4Ct2 = new Condition(t4, "P_x6", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "P_x6", TransitionOperation.PopElementWithoutTarget, "P_b6"));
        grdT4.Activations.add(new Activation(t4, "TL6", TransitionOperation.Move, "TL6"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 0;
        pn.Transitions.add(t4);

        // T11 ------Entrance for lane 2-------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "Ti_6";
        t11.InputPlaceName.add("P_b6");
        t11.InputPlaceName.add("P_I2");

        Condition T11Ct1 = new Condition(t11, "P_b6", TransitionCondition.NotNull);
        Condition T11Ct2 = new Condition(t11, "P_I2", TransitionCondition.CanAddCars);
        T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t11, "P_b6", TransitionOperation.AddElement, "P_I2"));

        t11.GuardMappingList.add(grdT11);

        t11.Delay = 0;
        pn.Transitions.add(t11);

        // T14 -------------------------------------Exit for lane 1------------------------------------------

        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "T_g7";
        t14.InputPlaceName.add("P_I2");
        t14.InputPlaceName.add("P_o7");

        Condition T14Ct1 = new Condition(t14, "P_I2", TransitionCondition.HaveCarForMe);
        Condition T14Ct2 = new Condition(t14, "P_o7", TransitionCondition.CanAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t14, "P_I2", TransitionOperation.PopElementWithTargetToQueue, "P_o7"));
        t14.GuardMappingList.add(grdT14);

        t14.Delay = 0;
        pn.Transitions.add(t14);

        // T25 -----------------------Car-------------------------
        PetriTransition t25 = new PetriTransition(pn);
        t25.TransitionName = "Tu5_o7car";
        t25.InputPlaceName.add("P_o7");
        t25.InputPlaceName.add("Pexit_car7");



        Condition T25Ct1 = new Condition(t25, "P_o7", TransitionCondition.HaveCar);


        GuardMapping grdT25 = new GuardMapping();
        grdT25.condition = T25Ct1;
        grdT25.Activations.add(new Activation(t25, "P_o7", TransitionOperation.PopElementWithoutTarget, "Pexit_car7"));

        t25.GuardMappingList.add(grdT25);


        t25.Delay = 0;
        pn.Transitions.add(t25);
        
        
        

     // T29 ------------------------------------------------
        PetriTransition t30= new PetriTransition(pn);
        t30.TransitionName = "T_send3";
        t30.InputPlaceName.add("Pexit_car7");

        Condition T30Ct1 = new Condition(t30, "Pexit_car7", TransitionCondition.NotNull);

        GuardMapping grdT30 = new GuardMapping();
        grdT30.condition = T30Ct1;
        grdT30.Activations.add(new Activation(t30, "Pexit_car7", TransitionOperation.SendOverNetwork, "OP12"));

        t30.GuardMappingList.add(grdT30);

        t30.Delay = 0;
        pn.Transitions.add(t30);

        //Pana aici merge

















        // T1 ------------------------------------------------
        PetriTransition t29 = new PetriTransition(pn);
        t29.TransitionName = "T_u5";
        t29.InputPlaceName.add("P_a5");
        t29.InputPlaceName.add("P_x5");

        Condition T29Ct1 = new Condition(t29, "P_a5", TransitionCondition.NotNull);
        Condition T29Ct2 = new Condition(t29, "P_x5", TransitionCondition.CanAddCars);
        T29Ct1.SetNextCondition(LogicConnector.AND, T29Ct2);

        Condition T29Ct3 = new Condition(t29, "P_a5", TransitionCondition.NotNull);
        Condition T29Ct4 = new Condition(t29, "P_x5", TransitionCondition.CanNotAddCars);
        T29Ct3.SetNextCondition(LogicConnector.AND, T29Ct4);

        GuardMapping grdT29 = new GuardMapping();
        grdT29.condition = T29Ct1;
        grdT29.Activations.add(new Activation(t29, "P_a5", TransitionOperation.AddElement, "P_x5"));
        t29.GuardMappingList.add(grdT29);

        GuardMapping grdT29_new = new GuardMapping();
        grdT29_new .condition = T29Ct3;
        grdT29_new .Activations.add(new Activation(t29, "P_a5", TransitionOperation.Move, "P_a5"));
        grdT29_new .Activations.add(new Activation(t29, "full", TransitionOperation.SendOverNetwork, "OP7"));
        t29.GuardMappingList.add(grdT29_new);

        t29.Delay = 0;
        pn.Transitions.add(t29);

        // T2 ------------------------------------------------
        PetriTransition t31 = new PetriTransition(pn);
        t31.TransitionName = "T_e5";
        t31.InputPlaceName.add("P_x5");
        t31.InputPlaceName.add("TL5");

        Condition T31Ct1 = new Condition(t31, "TL5", TransitionCondition.Equal, "green");
        Condition T31Ct2 = new Condition(t31, "P_x5", TransitionCondition.HaveCar);
        T31Ct1.SetNextCondition(LogicConnector.AND, T31Ct2);

        GuardMapping grdT31 = new GuardMapping();
        grdT31.condition = T31Ct1;
        grdT31.Activations.add(new Activation(t31, "P_x5", TransitionOperation.PopElementWithoutTarget, "P_b5"));
        grdT31.Activations.add(new Activation(t31, "TL5", TransitionOperation.Move, "TL5"));



        t31.GuardMappingList.add(grdT31);


        t31.Delay = 0;
        pn.Transitions.add(t31);

        // T5 ------------------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T_u8";
        t5.InputPlaceName.add("P_a8");
        t5.InputPlaceName.add("P_x8");

        Condition T5Ct1 = new Condition(t5, "P_a8", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "P_x8", TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        Condition T5Ct3 = new Condition(t5, "P_a8", TransitionCondition.NotNull);
        Condition T5Ct4 = new Condition(t5, "P_x8", TransitionCondition.CanNotAddCars);
        T5Ct3.SetNextCondition(LogicConnector.AND, T5Ct4);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new Activation(t5, "P_a8", TransitionOperation.AddElement, "P_x8"));
        t5.GuardMappingList.add(grdT5);

        GuardMapping grdT5_new = new GuardMapping();
        grdT5_new .condition = T5Ct3;
        grdT5_new .Activations.add(new Activation(t5, "P_a8", TransitionOperation.Move, "P_a8"));
        grdT5_new .Activations.add(new Activation(t5, "full", TransitionOperation.SendOverNetwork, "OP10"));
        t5.GuardMappingList.add(grdT5_new);

        t5.Delay = 0;
        pn.Transitions.add(t5);

        // T6 ------------------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T_e8";
        t6.InputPlaceName.add("P_x8");
        t6.InputPlaceName.add("TL8");

        Condition T6Ct1 = new Condition(t6, "TL8", TransitionCondition.Equal, "green");
        Condition T6Ct2 = new Condition(t6, "P_x8", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "P_x8", TransitionOperation.PopElementWithoutTarget, "P_b8"));
        grdT6.Activations.add(new Activation(t6, "TL8", TransitionOperation.Move, "TL8"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 0;
        pn.Transitions.add(t6);

        // T7 ------------------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T_u7";
        t7.InputPlaceName.add("P_a7");
        t7.InputPlaceName.add("P_x7");

        Condition T7Ct1 = new Condition(t7, "P_a7", TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t7, "P_x7", TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        Condition T7Ct3 = new Condition(t7, "P_a7", TransitionCondition.NotNull);
        Condition T7Ct4 = new Condition(t7, "P_x7", TransitionCondition.CanNotAddCars);
        T7Ct3.SetNextCondition(LogicConnector.AND, T7Ct4);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "P_a7", TransitionOperation.AddElement, "P_x7"));
        t7.GuardMappingList.add(grdT7);

        GuardMapping grdT7_new = new GuardMapping();
        grdT7_new .condition = T7Ct3;
        grdT7_new .Activations.add(new Activation(t7, "P_a7", TransitionOperation.Move, "P_a7"));
        grdT7_new .Activations.add(new Activation(t7, "full", TransitionOperation.SendOverNetwork, "OP13"));
        t7.GuardMappingList.add(grdT7_new);

        t7.Delay = 0;
        pn.Transitions.add(t7);

        // T8 ------------------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T_e7";
        t8.InputPlaceName.add("P_x7");
        t8.InputPlaceName.add("TL7");

        Condition T8Ct1 = new Condition(t8, "TL7", TransitionCondition.Equal, "green");
        Condition T8Ct2 = new Condition(t8, "P_x7", TransitionCondition.HaveCar);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t8, "P_x7", TransitionOperation.PopElementWithoutTarget, "P_b7"));
        grdT8.Activations.add(new Activation(t8, "TL7", TransitionOperation.Move, "TL7"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);



        // T9 ------------------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "TL5_left";
        t9.InputPlaceName.add("P_x5");
        t9.InputPlaceName.add("TL5_L");

        Condition T9Ct1 = new Condition(t9, "TL5_L", TransitionCondition.Equal, "green");
        Condition T9Ct2 = new Condition(t9, "P_x5", TransitionCondition.HaveCar);
        T9Ct1.SetNextCondition(LogicConnector.AND, T9Ct2);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t9, "P_x5", TransitionOperation.PopElementWithoutTarget, "P_b5"));
        grdT9.Activations.add(new Activation(t9, "TL5_L", TransitionOperation.Move, "TL5_L"));

        t9.GuardMappingList.add(grdT9);


        t9.Delay = 0;
        pn.Transitions.add(t9);

        // T10 ------Entrance for lane 1-------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "Ti_5";
        t10.InputPlaceName.add("P_b5");
        t10.InputPlaceName.add("P_I2");

        Condition T10Ct1 = new Condition(t10, "P_b5", TransitionCondition.NotNull);
        Condition T10Ct2 = new Condition(t10, "P_I2", TransitionCondition.CanAddCars);
        T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t10, "P_b5", TransitionOperation.AddElement, "P_I2"));

        t10.GuardMappingList.add(grdT10);

        t10.Delay = 0;
        pn.Transitions.add(t10);



        // T12 ------Entrance for lane 3-------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "Ti_7";
        t12.InputPlaceName.add("P_b7");
        t12.InputPlaceName.add("P_I2");

        Condition T12Ct1 = new Condition(t12, "P_b7", TransitionCondition.NotNull);
        Condition T12Ct2 = new Condition(t12, "P_I2", TransitionCondition.CanAddCars);
        T12Ct1.SetNextCondition(LogicConnector.AND, T12Ct2);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t12, "P_b7", TransitionOperation.AddElement, "P_I2"));

        t12.GuardMappingList.add(grdT12);

        t12.Delay = 0;
        pn.Transitions.add(t12);

        // T13 ------Entrance for lane 4-------------------
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "Ti_8";
        t13.InputPlaceName.add("P_b8");
        t13.InputPlaceName.add("P_I8");

        Condition T13Ct1 = new Condition(t13, "P_b8", TransitionCondition.NotNull);
        Condition T13Ct2 = new Condition(t13, "P_I2", TransitionCondition.CanAddCars);
        T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(t13, "P_b8", TransitionOperation.AddElement, "P_I2"));

        t13.GuardMappingList.add(grdT13);

        t13.Delay = 0;
        pn.Transitions.add(t13);

        // T15 -------------------------------------Exit for lane 2------------------------------------------


        PetriTransition t15 = new PetriTransition(pn);
        t15.TransitionName = "T_g8";
        t15.InputPlaceName.add("P_I2");
        t15.InputPlaceName.add("P_o8");

        Condition T15Ct1 = new Condition(t15, "P_I2", TransitionCondition.HaveCarForMe);
        Condition T15Ct2 = new Condition(t15, "P_o8", TransitionCondition.CanAddCars);
        T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(t15, "P_I2", TransitionOperation.PopElementWithTargetToQueue, "P_o8"));
        t15.GuardMappingList.add(grdT15);

        t15.Delay = 0;
        pn.Transitions.add(t15);


        // T16 -------------------------------------Exit for lane 3------------------------------------------


        PetriTransition t16 = new PetriTransition(pn);
        t16.TransitionName = "T_g5";
        t16.InputPlaceName.add("P_I2");
        t16.InputPlaceName.add("P_o5");

        Condition T16Ct1 = new Condition(t16, "P_I2", TransitionCondition.HaveCarForMe);
        Condition T16Ct2 = new Condition(t16, "P_o5", TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;
        grdT16.Activations.add(new Activation(t16, "P_I2", TransitionOperation.PopElementWithTargetToQueue, "P_o5"));
        t16.GuardMappingList.add(grdT16);

        t16.Delay = 0;
        pn.Transitions.add(t16);

        // T17 -------------------------------------Exit for lane 4------------------------------------------


        PetriTransition t17 = new PetriTransition(pn);
        t17.TransitionName = "T_g6";
        t17.InputPlaceName.add("P_I2");
        t17.InputPlaceName.add("P_o6");

        Condition T17Ct1 = new Condition(t17, "P_I2", TransitionCondition.HaveCarForMe);
        Condition T17Ct2 = new Condition(t17, "P_o6", TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;
        grdT17.Activations.add(new Activation(t17, "P_I2", TransitionOperation.PopElementWithTargetToQueue, "P_o6"));
        t17.GuardMappingList.add(grdT17);

        t17.Delay = 0;
        pn.Transitions.add(t17);


        // T18 ------------------------------------------------
        PetriTransition t18 = new PetriTransition(pn);
        t18.TransitionName = "TL7_left";
        t18.InputPlaceName.add("P_x7");
        t18.InputPlaceName.add("TL7_L");

        Condition T18Ct1 = new Condition(t18, "TL7_L", TransitionCondition.Equal, "green");
        Condition T18Ct2 = new Condition(t18, "P_x7", TransitionCondition.HaveCar);
        T18Ct1.SetNextCondition(LogicConnector.AND, T18Ct2);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;
        grdT18.Activations.add(new Activation(t18, "P_x7", TransitionOperation.PopElementWithoutTarget, "P_b7"));
        grdT18.Activations.add(new Activation(t18, "TL7_L", TransitionOperation.Move, "TL7_L"));

        t18.GuardMappingList.add(grdT18);


        t18.Delay = 0;
        pn.Transitions.add(t18);

        // T19 -----------------------Bus-------------------------
        PetriTransition t19 = new PetriTransition(pn);
        t19.TransitionName = "Tu5_o7";
        t19.InputPlaceName.add("P_o7");
        t19.InputPlaceName.add("Px5_o7");

        Condition T19Ct1 = new Condition(t19, "P_o7", TransitionCondition.NotNull);
        Condition T19Ct2 = new Condition(t19, "Px5_o7", TransitionCondition.CanAddCars);
        Condition T19Ct3 = new Condition(t19, "Px5_o7", TransitionCondition.IsBus);

        T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);
        T19Ct2.SetNextCondition(LogicConnector.AND, T19Ct3);

        GuardMapping grdT19 = new GuardMapping();
        grdT19.condition = T19Ct1;
        grdT19.Activations.add(new Activation(t19, "P_o7", TransitionOperation.Move, "Px5_o7"));

        t19.GuardMappingList.add(grdT19);


        //-----------------------Priority-------------------------

        Condition T19Ct4 = new Condition(t19, "P_o7", TransitionCondition.NotNull);
        Condition T19Ct5 = new Condition(t19, "Px5_o7", TransitionCondition.CanAddCars);
        Condition T19Ct6 = new Condition(t19, "Px5_o7", TransitionCondition.IsPriorityCar);

        T19Ct4.SetNextCondition(LogicConnector.AND, T19Ct5);
        T19Ct5.SetNextCondition(LogicConnector.AND, T19Ct6);

        GuardMapping grdT19_new = new GuardMapping();
        grdT19_new.condition = T19Ct4;
        grdT19_new.Activations.add(new Activation(t19, "P_o7", TransitionOperation.Move, "Px5_o7"));

        t19.GuardMappingList.add(grdT19_new);


        t19.Delay = 0;
        pn.Transitions.add(t19);

        // T20 -----------------------Priority-------------------------
        PetriTransition t20 = new PetriTransition(pn);
        t20.TransitionName = "T5_o7";
        t20.InputPlaceName.add("Px5_o7");
        t20.InputPlaceName.add("Px6_o7");


        Condition T20Ct1 = new Condition(t20, "Px6_o7", TransitionCondition.NotNull);
        Condition T20Ct2 = new Condition(t20, "Px6_o7", TransitionCondition.CanAddCars);
        Condition T20Ct3 = new Condition(t20, "Px5_o7", TransitionCondition.IsPriorityCar);

        T20Ct1.SetNextCondition(LogicConnector.AND, T20Ct2);
        T20Ct2.SetNextCondition(LogicConnector.AND, T20Ct3);

        GuardMapping grdT20 = new GuardMapping();
        grdT20.condition = T20Ct3;
        grdT20.Activations.add(new Activation(t20, "Px5_o7", TransitionOperation.Move, "Px6_o7"));

        t20.GuardMappingList.add(grdT20);


        t20.Delay = 0;
        pn.Transitions.add(t20);

        // T21 -----------------------Bus-------------------------
        PetriTransition t21 = new PetriTransition(pn);
        t21.TransitionName = "Ts_o7";
        t21.InputPlaceName.add("Px5_o7");
        t21.InputPlaceName.add("Ps_o7");


        Condition T21Ct1 = new Condition(t21, "Px5_o7", TransitionCondition.HaveTaxi);
        Condition T21Ct2 = new Condition(t21, "Ps_o7", TransitionCondition.HaveCar);

        T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T21Ct1;
        grdT21.Activations.add(new Activation(t21, "Px5_o7", TransitionOperation.PopElementWithoutTarget,"Ps_o7"));

        t21.GuardMappingList.add(grdT21);


        t21.Delay = 0;
        pn.Transitions.add(t21);

        // T22 -----------------------Bus-------------------------
        PetriTransition t22 = new PetriTransition(pn);
        t22.TransitionName = "Tes_o7";
        t22.InputPlaceName.add("Px6_o7");
        t22.InputPlaceName.add("Ps_o7");
        t22.InputPlaceName.add("Usreq_o7");



        Condition T22Ct11 = new Condition(t22, "Ps_o7", TransitionCondition.HaveCar);
        Condition T22Ct21 = new Condition(t22, "Usreq_o7", TransitionCondition.NotNull);

        T22Ct11.SetNextCondition(LogicConnector.AND, T22Ct21);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T22Ct11;
        grdT22.Activations.add(new Activation(t22, "Ps_o7", TransitionOperation.PopTaxiToQueue,"Px6_o7")); // cannot pop a bus to queue

        t22.GuardMappingList.add(grdT22);


        t22.Delay = 0;
        pn.Transitions.add(t22);

        // T23 -----------------------Bus-------------------------
        PetriTransition t23 = new PetriTransition(pn);
        t23.TransitionName = "T6_o7";
        t23.InputPlaceName.add("Px6_o7");
        t23.InputPlaceName.add("Pt6_o7");



        Condition T23Ct11 = new Condition(t23, "Px6_o7", TransitionCondition.HaveCar);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T23Ct11;
        grdT23.Activations.add(new Activation(t23, "Px6_o7", TransitionOperation.PopElementWithTarget,"Pt6_o7"));

        t23.GuardMappingList.add(grdT23);


        t23.Delay = 0;
        pn.Transitions.add(t23);

        // T24 -----------------------Bus-------------------------
        PetriTransition t24 = new PetriTransition(pn);
        t24.TransitionName = "T7_o7";
        t24.InputPlaceName.add("Px6_o7");
        t24.InputPlaceName.add("Pt7_o7");



        Condition T24Ct11 = new Condition(t24, "Px6_o7", TransitionCondition.HaveCar);

        GuardMapping grdT24 = new GuardMapping();
        grdT24.condition = T24Ct11;
        grdT24.Activations.add(new Activation(t24, "Px6_o7", TransitionOperation.PopElementWithTarget,"Pt7_o7"));

        t24.GuardMappingList.add(grdT24);


        t24.Delay = 0;
        pn.Transitions.add(t24);

        // T26 -----------------------Car-------------------------
        PetriTransition t26 = new PetriTransition(pn);
        t26.TransitionName = "Tu5_o8car";
        t26.InputPlaceName.add("P_o8");
        t26.InputPlaceName.add("Pexit_car8");



        Condition T26Ct1 = new Condition(t26, "P_o8", TransitionCondition.HaveCar);


        GuardMapping grdT26 = new GuardMapping();
        grdT26.condition = T26Ct1;
        grdT26.Activations.add(new Activation(t26, "P_o8", TransitionOperation.PopElementWithoutTarget,"Pexit_car8"));

        t26.GuardMappingList.add(grdT26);


        t26.Delay = 0;
        pn.Transitions.add(t26);

        // T27 -----------------------Car-------------------------
        PetriTransition t27 = new PetriTransition(pn);
        t27.TransitionName = "Tu5_o5car";
        t27.InputPlaceName.add("P_o5");
        t27.InputPlaceName.add("Pexit_car5");



        Condition T27Ct1 = new Condition(t27, "P_o5", TransitionCondition.HaveCar);


        GuardMapping grdT27 = new GuardMapping();
        grdT27.condition = T27Ct1;
        grdT27.Activations.add(new Activation(t27, "P_o5", TransitionOperation.PopElementWithoutTarget,"Pexit_car5"));

        t27.GuardMappingList.add(grdT27);


        t27.Delay = 0;
        pn.Transitions.add(t27);

        // T28 -----------------------Car-------------------------
        PetriTransition t28 = new PetriTransition(pn);
        t28.TransitionName = "Tu5_o6car";
        t28.InputPlaceName.add("P_o6");
        t28.InputPlaceName.add("Pexit_car6");



        Condition T28Ct1 = new Condition(t28, "P_o6", TransitionCondition.HaveCar);


        GuardMapping grdT28 = new GuardMapping();
        grdT28.condition = T28Ct1;
        grdT28.Activations.add(new Activation(t28, "P_o6", TransitionOperation.PopElementWithoutTarget,"Pexit_car6"));

        t28.GuardMappingList.add(grdT28);


        t28.Delay = 0;
        pn.Transitions.add(t28);
        
        



        System.out.println("Exp1 started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();
        PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

        
    }

}
