package GreenLight;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;


public class Controller6F_I1 {

    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "6-Phase Controller";
        pn.SetName("Controller");
        pn.NetworkPort = 1081;

        // Initialize constant places
        DataString ini = new DataString();
        ini.SetName("ini");
        ini.SetValue("red");
        pn.ConstantPlaceList.add(ini);

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

        DataInteger five = new DataInteger();
        five.SetName("Five");
        five.SetValue(5);
        pn.ConstantPlaceList.add(five);

        DataInteger ten = new DataInteger();
        ten.SetName("Ten");
        ten.SetValue(10);
        pn.ConstantPlaceList.add(ten);

        // Define all dynamic places
        DataString r1r2r3r4r5r6 = new DataString();
        r1r2r3r4r5r6.SetName("r1r2r3r4r5r6");
        r1r2r3r4r5r6.SetValue("signal");
        pn.PlaceList.add(r1r2r3r4r5r6);

        DataString g1r2r3r4r5r6 = new DataString();
        g1r2r3r4r5r6.SetName("g1r2r3r4r5r6");
        pn.PlaceList.add(g1r2r3r4r5r6);

        DataString y1r2r3r4r5r6 = new DataString();
        y1r2r3r4r5r6.SetName("y1r2r3r4r5r6");
        pn.PlaceList.add(y1r2r3r4r5r6);

        DataString r1g2r3r4r5r6 = new DataString();
        r1g2r3r4r5r6.SetName("r1g2r3r4r5r6");
        pn.PlaceList.add(r1g2r3r4r5r6);

        DataString r1y2r3r4r5r6 = new DataString();
        r1y2r3r4r5r6.SetName("r1y2r3r4r5r6");
        pn.PlaceList.add(r1y2r3r4r5r6);

        DataString r1r2g3r4r5r6 = new DataString();
        r1r2g3r4r5r6.SetName("r1r2g3r4r5r6");
        pn.PlaceList.add(r1r2g3r4r5r6);

        DataString r1r2y3r4r5r6 = new DataString();
        r1r2y3r4r5r6.SetName("r1r2y3r4r5r6");
        pn.PlaceList.add(r1r2y3r4r5r6);

        DataString r1r2r3g4r5r6 = new DataString();
        r1r2r3g4r5r6.SetName("r1r2r3g4r5r6");
        pn.PlaceList.add(r1r2r3g4r5r6);

        DataString r1r2r3y4r5r6 = new DataString();
        r1r2r3y4r5r6.SetName("r1r2r3y4r5r6");
        pn.PlaceList.add(r1r2r3y4r5r6);

        DataString r1r2r3r4g5r6 = new DataString();
        r1r2r3r4g5r6.SetName("r1r2r3r4g5r6");
        pn.PlaceList.add(r1r2r3r4g5r6);

        DataString r1r2r3r4y5r6 = new DataString();
        r1r2r3r4y5r6.SetName("r1r2r3r4y5r6");
        pn.PlaceList.add(r1r2r3r4y5r6);

        DataString r1r2r3r4r5g6 = new DataString();
        r1r2r3r4r5g6.SetName("r1r2r3r4r5g6");
        pn.PlaceList.add(r1r2r3r4r5g6);

        DataString r1r2r3r4r5y6 = new DataString();
        r1r2r3r4r5y6.SetName("r1r2r3r4r5y6");
        pn.PlaceList.add(r1r2r3r4r5y6);

        // Define transfer operations for outputs
        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1080", "TL1");
        pn.PlaceList.add(OP1);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1080", "TL2");
        pn.PlaceList.add(OP2);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1080", "TL3");
        pn.PlaceList.add(OP3);

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost", "1080", "TL4");
        pn.PlaceList.add(OP4);

        DataTransfer OP5 = new DataTransfer();
        OP5.SetName("OP5");
        OP5.Value = new TransferOperation("localhost", "1080", "TL1_L");
        pn.PlaceList.add(OP5);

        DataTransfer OP6 = new DataTransfer();
        OP6.SetName("OP6");
        OP6.Value = new TransferOperation("localhost", "1080", "TL3_L");
        pn.PlaceList.add(OP6);

        //----------------------------iniT------------------------------------
        PetriTransition iniT = new PetriTransition(pn);
        iniT.TransitionName = "iniT";

        Condition iniTCt1 = new Condition(iniT, "ini", TransitionCondition.NotNull);

        GuardMapping grdiniT = new GuardMapping();
        grdiniT.condition= iniTCt1;

        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP1"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP2"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP3"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP4"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP5"));
        grdiniT.Activations.add(new Activation(iniT, "ini", TransitionOperation.SendOverNetwork, "OP6"));
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);


        // ---------------------------- T1 - Phase 1 Green (OP1 green, others red) ------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4r5r6");

        Condition T1Ct1 = new Condition(t1, "r1r2r3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5r6", TransitionOperation.Move, "g1r2r3r4r5r6"));
        //grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5r6", TransitionOperation.MakeNull, "r1r2r3r4r5r6")); // Explicit reset
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4r5r6", TransitionOperation.Copy, "P_f1"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);

        // ---------------------------- T2 - Phase 1 Yellow (OP1 yellow, others red) ------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4r5r6");

        Condition T2Ct1 = new Condition(t2, "g1r2r3r4r5r6", TransitionCondition.NotNull);
        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "g1r2r3r4r5r6", TransitionOperation.Move, "y1r2r3r4r5r6"));
        //grdT2.Activations.add(new Activation(t2, "g1r2r3r4r5r6", TransitionOperation.MakeNull, "g1r2r3r4r5r6")); // Reset input place
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
        t2.GuardMappingList.add(grdT2);


        t2.Delay = 5;
        pn.Transitions.add(t2);

        // ---------------------------- T3 - Phase 2 Green (OP2 green, OP1 red) ------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4r5r6");

        Condition T3Ct1 = new Condition(t3, "y1r2r3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4r5r6", TransitionOperation.Move, "r1g2r3r4r5r6"));
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4r5r6", TransitionOperation.Copy, "P_f2"));
        //grdT3.Activations.add(new Activation(t3, "y1r2r3r4r5r6", TransitionOperation.MakeNull, "y1r2r3r4r5r6")); // Reset input place
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);

        // ---------------------------- T4 - Phase 2 Yellow (OP2 yellow, others red) ------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("r1g2r3r4r5r6");

        Condition T4Ct1 = new Condition(t4, "r1g2r3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t4, "r1g2r3r4r5r6", TransitionOperation.Move, "r1y2r3r4r5r6"));
        //grdT4.Activations.add(new Activation(t4, "r1g2r3r4r5r6", TransitionOperation.MakeNull, "r1g2r3r4r5r6")); // Reset input place
        grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 5;
        pn.Transitions.add(t4);

        // ---------------------------- T5 - Phase 3 Green (OP3 green, OP2 red) ------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1y2r3r4r5r6");

        Condition T5Ct1 = new Condition(t5, "r1y2r3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;
        grdT5.Activations.add(new

                Activation(t5, "r1y2r3r4r5r6", TransitionOperation.Move, "r1r2g3r4r5r6"));
        //grdT5.Activations.add(new Activation(t5, "r1y2r3r4r5r6", TransitionOperation.MakeNull, "r1y2r3r4r5r6")); // Reset input place
        grdT5.Activations.add(new Activation(t5, "r1y2r3r4r5r6", TransitionOperation.Copy, "P_f3"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);

        // ---------------------------- T6 - Phase 3 Yellow (OP3 yellow, others red) ------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1r2g3r4r5r6");

        Condition T6Ct1 = new Condition(t6, "r1r2g3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t6, "r1r2g3r4r5r6", TransitionOperation.Move, "r1r2y3r4r5r6"));
        //grdT6.Activations.add(new Activation(t6, "r1r2g3r4r5r6", TransitionOperation.MakeNull, "r1r2g3r4r5r6")); // Reset
        grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
        t6.GuardMappingList.add(grdT6);

        t6.Delay = 5;
        pn.Transitions.add(t6);

        // ---------------------------- T7 - Phase 4 Green (OP4 green, OP3 red) ------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("r1r2y3r4r5r6");

        Condition T7Ct1 = new Condition(t7, "r1r2y3r4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4r5r6", TransitionOperation.Move, "r1r2r3g4r5r6"));
        //grdT7.Activations.add(new Activation(t7, "r1r2y3r4r5r6", TransitionOperation.MakeNull, "r1r2y3r4r5r6")); // Reset
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4r5r6", TransitionOperation.Copy, "P_f4"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 5;
        pn.Transitions.add(t7);

        // ---------------------------- T8 - Phase 4 Yellow (OP4 yellow, others red) ------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2r3g4r5r6");

        Condition T8Ct1 = new Condition(t8, "r1r2r3g4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t8, "r1r2r3g4r5r6", TransitionOperation.Move, "r1r2r3y4r5r6"));
        //grdT8.Activations.add(new Activation(t8, "r1r2r3g4r5r6", TransitionOperation.MakeNull, "r1r2r3g4r5r6")); // Reset
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 5;
        pn.Transitions.add(t8);

        // ---------------------------- T9 - Phase 5 Green (OP5 green, OP4 red) ------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2r3y4r5r6");

        Condition T9Ct1 = new Condition(t9, "r1r2r3y4r5r6", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4r5r6", TransitionOperation.Move, "r1r2r3r4g5r6"));
        //grdT9.Activations.add(new Activation(t9, "r1r2r3y4r5r6", TransitionOperation.MakeNull, "r1r2r3y4r5r6")); // Reset
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4r5r6", TransitionOperation.Copy, "P_f5"));
        grdT9.Activations.add(new Activation(t9, "green", TransitionOperation.SendOverNetwork, "OP5"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));
        t9.GuardMappingList.add(grdT9);

        t9.Delay = 5;
        pn.Transitions.add(t9);

        // ---------------------------- T10 - Phase 5 Yellow (OP5 yellow, others red) ------------------------------------
        PetriTransition t10 = new PetriTransition(pn);
        t10.TransitionName = "T10";
        t10.InputPlaceName.add("r1r2r3r4g5r6");

        Condition T10Ct1 = new Condition(t10, "r1r2r3r4g5r6", TransitionCondition.NotNull);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t10, "r1r2r3r4g5r6", TransitionOperation.Move, "r1r2r3r4y5r6"));
        //grdT10.Activations.add(new Activation(t10, "r1r2r3r4g5r6", TransitionOperation.MakeNull, "r1r2r3r4g5r6")); // Reset
        grdT10.Activations.add(new Activation(t10, "yellow", TransitionOperation.SendOverNetwork, "OP5"));
        t10.GuardMappingList.add(grdT10);

        t10.Delay = 5;
        pn.Transitions.add(t10);

        // ---------------------------- T11 - Phase 6 Green (OP6 green, OP5 red) ------------------------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "T11";
        t11.InputPlaceName.add("r1r2r3r4y5r6");

        Condition T11Ct1 = new Condition(t11, "r1r2r3r4y5r6", TransitionCondition.NotNull);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new

                Activation(t11, "r1r2r3r4y5r6", TransitionOperation.Move, "r1r2r3r4r5g6"));
        //grdT11.Activations.add(new Activation(t11, "r1r2r3r4y5r6", TransitionOperation.MakeNull, "r1r2r3r4y5r6")); // Reset
        grdT11.Activations.add(new Activation(t11, "r1r2r3r4y5r6", TransitionOperation.Copy, "P_f6"));
        grdT11.Activations.add(new Activation(t11, "green", TransitionOperation.SendOverNetwork, "OP6"));
        grdT11.Activations.add(new Activation(t11, "red", TransitionOperation.SendOverNetwork, "OP5"));
        t11.GuardMappingList.add(grdT11);

        t11.Delay = 5;
        pn.Transitions.add(t11);

        // ---------------------------- T12 - Phase 6 Yellow (OP6 yellow, others red) ------------------------------------
        PetriTransition t12 = new PetriTransition(pn);
        t12.TransitionName = "T12";
        t12.InputPlaceName.add("r1r2r3r4r5g6");

        Condition T12Ct1 = new Condition(t12, "r1r2r3r4r5g6", TransitionCondition.NotNull);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t12, "r1r2r3r4r5g6", TransitionOperation.Move, "r1r2r3r4r5y6"));
        //grdT12.Activations.add(new Activation(t12, "r1r2r3r4r5g6", TransitionOperation.MakeNull, "r1r2r3r4r5g6")); // Reset
        grdT12.Activations.add(new Activation(t12, "yellow", TransitionOperation.SendOverNetwork, "OP6"));
        t12.GuardMappingList.add(grdT12);

        t12.Delay = 5;
        pn.Transitions.add(t12);

        // ---------------------------- T13 - Return to All Red ------------------------------------
        PetriTransition t13 = new PetriTransition(pn);
        t13.TransitionName = "T13";
        t13.InputPlaceName.add("r1r2r3r4r5y6");

        Condition T13Ct1 = new Condition(t13, "r1r2r3r4r5y6", TransitionCondition.NotNull);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(t13, "r1r2r3r4r5y6", TransitionOperation.Move, "r1r2r3r4r5r6"));
        //grdT13.Activations.add(new Activation(t13, "r1r2r3r4r5y6", TransitionOperation.MakeNull, "r1r2r3r4r5y6")); // Reset
        grdT13.Activations.add(new Activation(t13, "red", TransitionOperation.SendOverNetwork, "OP6"));
        t13.GuardMappingList.add(grdT13);

        t13.Delay = 5;
        pn.Transitions.add(t13);

        // ---------------------------- T_f1 - Asynchronous Transition for Phase 1 ------------------------------------
        PetriTransition t_f1 = new PetriTransition(pn);
        t_f1.TransitionName = "T_f1";
        t_f1.InputPlaceName.add("P_f1");
        t_f1.InputPlaceName.add("IN1");
        t_f1.IsAsync = true;

        Condition T_f1Ct1 = new Condition(t_f1, "P_f1", TransitionCondition.NotNull);
        Condition T_f1Ct2 = new Condition(t_f1, "IN1", TransitionCondition.IsNull);
        T_f1Ct1.SetNextCondition(LogicConnector.AND, T_f1Ct2);

        GuardMapping grdT_f1_1 = new GuardMapping();
        grdT_f1_1.condition = T_f1Ct1;
        grdT_f1_1.Activations.add(new Activation(t_f1, "Five", TransitionOperation.DynamicDelay, ""));
        t_f1.GuardMappingList.add(grdT_f1_1);
        Condition T_f1Ct3 = new Condition(t_f1, "IN1", TransitionCondition.NotNull);
        Condition T_f1Ct4 = new Condition(t_f1, "P_f1", TransitionCondition.NotNull);
        T_f1Ct3.SetNextCondition(LogicConnector.AND, T_f1Ct4);

        GuardMapping grdT_f1_2 = new GuardMapping();
        grdT_f1_2.condition = T_f1Ct3;
        grdT_f1_2.Activations.add(new

                Activation(t_f1, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f1.GuardMappingList.add(grdT_f1_2);

        pn.Transitions.add(t_f1);

        // ---------------------------- T_f2 - Asynchronous Transition for Phase 2 ------------------------------------
        PetriTransition t_f2 = new PetriTransition(pn);
        t_f2.TransitionName = "T_f2";
        t_f2.InputPlaceName.add("P_f2");
        t_f2.InputPlaceName.add("IN2");
        t_f2.IsAsync = true;

        Condition T_f2Ct1 = new Condition(t_f2, "P_f2", TransitionCondition.NotNull);
        Condition T_f2Ct2 = new Condition(t_f2, "IN2", TransitionCondition.IsNull);
        T_f2Ct1.SetNextCondition(LogicConnector.AND, T_f2Ct2);

        GuardMapping grdT_f2_1 = new GuardMapping();
        grdT_f2_1.condition = T_f2Ct1;
        grdT_f2_1.Activations.add(new

                Activation(t_f2, "Five", TransitionOperation.DynamicDelay, ""));
        t_f2.GuardMappingList.add(grdT_f2_1);

        Condition T_f2Ct3 = new Condition(t_f2, "IN2", TransitionCondition.NotNull);
        Condition T_f2Ct4 = new Condition(t_f2, "P_f2", TransitionCondition.NotNull);
        T_f2Ct3.SetNextCondition(LogicConnector.AND, T_f2Ct4);

        GuardMapping grdT_f2_2 = new GuardMapping();
        grdT_f2_2.condition = T_f2Ct3;
        grdT_f2_2.Activations.add(new

                Activation(t_f2, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f2.GuardMappingList.add(grdT_f2_2);

        pn.Transitions.add(t_f2);

        // ---------------------------- T_f3 - Asynchronous Transition for Phase 3 ------------------------------------
        PetriTransition t_f3 = new PetriTransition(pn);
        t_f3.TransitionName = "T_f3";
        t_f3.InputPlaceName.add("P_f3");
        t_f3.InputPlaceName.add("IN3");
        t_f3.IsAsync = true;

        Condition T_f3Ct1 = new Condition(t_f3, "P_f3", TransitionCondition.NotNull);
        Condition T_f3Ct2 = new Condition(t_f3, "IN3", TransitionCondition.IsNull);
        T_f3Ct1.SetNextCondition(LogicConnector.AND, T_f3Ct2);

        GuardMapping grdT_f3_1 = new GuardMapping();
        grdT_f3_1.condition = T_f3Ct1;
        grdT_f3_1.Activations.add(new

                Activation(t_f3, "Five", TransitionOperation.DynamicDelay, ""));
        t_f3.GuardMappingList.add(grdT_f3_1);

        Condition T_f3Ct3 = new Condition(t_f3, "IN3", TransitionCondition.NotNull);
        Condition T_f3Ct4 = new Condition(t_f3, "P_f3", TransitionCondition.NotNull);
        T_f3Ct3.SetNextCondition(LogicConnector.AND, T_f3Ct4);

        GuardMapping grdT_f3_2 = new GuardMapping();
        grdT_f3_2.condition = T_f3Ct3;
        grdT_f3_2.Activations.add(new

                Activation(t_f3, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f3.GuardMappingList.add(grdT_f3_2);

        pn.Transitions.add(t_f3);

        // ---------------------------- T_f4 - Asynchronous Transition for Phase 4 ------------------------------------
        PetriTransition t_f4 = new PetriTransition(pn);
        t_f4.TransitionName = "T_f4";
        t_f4.InputPlaceName.add("P_f4");
        t_f4.InputPlaceName.add("IN4");
        t_f4.IsAsync = true;

        Condition T_f4Ct1 = new Condition(t_f4, "P_f4", TransitionCondition.NotNull);
        Condition T_f4Ct2 = new Condition(t_f4, "IN4", TransitionCondition.IsNull);
        T_f4Ct1.SetNextCondition(LogicConnector.AND, T_f4Ct2);

        GuardMapping grdT_f4_1 = new GuardMapping();
        grdT_f4_1.condition = T_f4Ct1;
        grdT_f4_1.Activations.add(new

                Activation(t_f4, "Five", TransitionOperation.DynamicDelay, ""));
        t_f4.GuardMappingList.add(grdT_f4_1);

        Condition T_f4Ct3 = new Condition(t_f4, "IN4", TransitionCondition.NotNull);
        Condition T_f4Ct4 = new Condition(t_f4, "P_f4", TransitionCondition.NotNull);
        T_f4Ct3.SetNextCondition(LogicConnector.AND, T_f4Ct4);

        GuardMapping grdT_f4_2 = new GuardMapping();
        grdT_f4_2.condition = T_f4Ct3;
        grdT_f4_2.Activations.add(new

                Activation(t_f4, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f4.GuardMappingList.add(grdT_f4_2);

        pn.Transitions.add(t_f4);

        // ---------------------------- T_f5 - Asynchronous Transition for Phase 5 ------------------------------------
        PetriTransition t_f5 = new PetriTransition(pn);
        t_f5.TransitionName = "T_f5";
        t_f5.InputPlaceName.add("P_f5");
        t_f5.InputPlaceName.add("IN5");
        t_f5.IsAsync = true;

        Condition T_f5Ct1 = new Condition(t_f5, "P_f5", TransitionCondition.NotNull);
        Condition T_f5Ct2 = new Condition(t_f5, "IN5", TransitionCondition.IsNull);
        T_f5Ct1.SetNextCondition(LogicConnector.AND, T_f5Ct2);

        GuardMapping grdT_f5_1 = new GuardMapping();
        grdT_f5_1.condition = T_f5Ct1;
        grdT_f5_1.Activations.add(new

                Activation(t_f5, "Five", TransitionOperation.DynamicDelay, ""));
        t_f5.GuardMappingList.add(grdT_f5_1);

        Condition T_f5Ct3 = new Condition(t_f5, "IN5", TransitionCondition.NotNull);
        Condition T_f5Ct4 = new Condition(t_f5, "P_f5", TransitionCondition.NotNull);
        T_f5Ct3.SetNextCondition(LogicConnector.AND, T_f5Ct4);

        GuardMapping grdT_f5_2 = new GuardMapping();
        grdT_f5_2.condition = T_f5Ct3;
        grdT_f5_2.Activations.add(new

                Activation(t_f5, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f5.GuardMappingList.add(grdT_f5_2);

        pn.Transitions.add(t_f5);

        // ---------------------------- T_f6 - Asynchronous Transition for Phase 6 ------------------------------------
        PetriTransition t_f6 = new PetriTransition(pn);
        t_f6.TransitionName = "T_f6";
        t_f6.InputPlaceName.add("P_f6");
        t_f6.InputPlaceName.add("IN6");
        t_f6.IsAsync = true;

        Condition T_f6Ct1 = new Condition(t_f6, "P_f6", TransitionCondition.NotNull);
        Condition T_f6Ct2 = new Condition(t_f6, "IN6", TransitionCondition.IsNull);
        T_f6Ct1.SetNextCondition(LogicConnector.AND, T_f6Ct2);

        GuardMapping grdT_f6_1 = new GuardMapping();
        grdT_f6_1.condition = T_f6Ct1;
        grdT_f6_1.Activations.add(new

                Activation(t_f6, "Five", TransitionOperation.DynamicDelay, ""));
        t_f6.GuardMappingList.add(grdT_f6_1);

        Condition T_f6Ct3 = new Condition(t_f6, "IN6", TransitionCondition.NotNull);
        Condition T_f6Ct4 = new Condition(t_f6, "P_f6", TransitionCondition.NotNull);
        T_f6Ct3.SetNextCondition(LogicConnector.AND, T_f6Ct4);

        GuardMapping grdT_f6_2 = new GuardMapping();
        grdT_f6_2.condition = T_f6Ct3;
        grdT_f6_2.Activations.add(new

                Activation(t_f6, "Ten", TransitionOperation.DynamicDelay, ""));
        t_f6.GuardMappingList.add(grdT_f6_2);

        pn.Transitions.add(t_f6);

// -------------------------------------------------------------------------------------
// ---------------------------- PN Start and GUI Setup ---------------------------------
// -------------------------------------------------------------------------------------

        System.out.println("6-Phase Controller started\n------------------------------");

// Set the delay for transitions in the Petri net
        pn.Delay = 2000;

        // Initialize and display the PetriNetWindow
        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}