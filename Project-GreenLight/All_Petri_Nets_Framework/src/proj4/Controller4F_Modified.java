package proj4;

import Components.*;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller4F_Modified {

    public static void main (String []args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Controller";
        pn.SetName("Controller");
        pn.NetworkPort = 1081;

        DataString ini = new DataString();
        //ini.Printable = false;
        ini.SetName("ini");
        ini.SetValue("red");
        pn.ConstantPlaceList.add(ini);

        DataString red = new DataString();
        //red.Printable = false;
        red.SetName("red");
        red.SetValue("red");
        pn.ConstantPlaceList.add(red);

        DataString green = new DataString();
        //green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString yellow = new DataString();
        //yellow.Printable = false;
        yellow.SetName("yellow");
        yellow.SetValue("yellow");
        pn.ConstantPlaceList.add(yellow);

        DataInteger Five = new DataInteger();
        Five.SetName("FIVE");
        Five.SetValue(5);
        pn.ConstantPlaceList.add(Five);

        DataInteger Ten = new DataInteger();
        Ten.SetName("TEN");
        Ten.SetValue(10);
        pn.ConstantPlaceList.add(Ten);

        // State Places for the controller

        DataString r1r2r3r4 = new DataString();
        r1r2r3r4.SetName("r1r2r3r4");
        r1r2r3r4.SetValue("signal");
        pn.PlaceList.add(r1r2r3r4);

        DataString g1r2r3r4 = new DataString();
        g1r2r3r4.SetName("g1r2r3r4");
        pn.PlaceList.add(g1r2r3r4);

        DataString y1r2r3r4 = new DataString();
        y1r2r3r4.SetName("y1r2r3r4");
        pn.PlaceList.add(y1r2r3r4);

        DataString r1g2r3r4 = new DataString();
        r1g2r3r4.SetName("r1g2r3r4");
        pn.PlaceList.add(r1g2r3r4);

        DataString r1y2r3r4 = new DataString();
        r1y2r3r4.SetName("r1y2r3r4");
        pn.PlaceList.add(r1y2r3r4);

        DataString r1r2g3r4 = new DataString();
        r1r2g3r4.SetName("r1r2g3r4");
        pn.PlaceList.add(r1r2g3r4);

        DataString r1r2y3r4 = new DataString();
        r1r2y3r4.SetName("r1r2y3r4");
        pn.PlaceList.add(r1r2y3r4);

        DataString r1r2r3g4 = new DataString();
        r1r2r3g4.SetName("r1r2r3g4");
        pn.PlaceList.add(r1r2r3g4);

        DataString r1r2r3y4 = new DataString();
        r1r2r3y4.SetName("r1r2r3y4");
        pn.PlaceList.add(r1r2r3y4);

        DataString in1 = new DataString();
        in1.SetName("in1");
        pn.PlaceList.add(in1);

        DataString in2 = new DataString();
        in2.SetName("in2");
        pn.PlaceList.add(in2);

        DataString in3 = new DataString();
        in3.SetName("in3");
        pn.PlaceList.add(in3);

        DataString in4 = new DataString();
        in4.SetName("in4");
        pn.PlaceList.add(in4);

        DataString p_f1 = new DataString();
        p_f1.SetName("p_f1");
        pn.PlaceList.add(p_f1);

        DataString p_f2 = new DataString();
        p_f2.SetName("p_f2");
        pn.PlaceList.add(p_f2);

        DataString p_f3 = new DataString();
        p_f3.SetName("p_f3");
        pn.PlaceList.add(p_f3);

        DataString p_f4 = new DataString();
        p_f4.SetName("p_f4");
        pn.PlaceList.add(p_f4);

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost", "1080" , "TL1");
        pn.PlaceList.add(OP1);

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost", "1080" , "TL2");
        pn.PlaceList.add(OP2);

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost", "1080" , "TL3");
        pn.PlaceList.add(OP3);

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost", "1080" , "TL4");
        pn.PlaceList.add(OP4);


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
        grdiniT.Activations.add(new Activation(iniT, "", TransitionOperation.MakeNull, "ini"));

        iniT.GuardMappingList.add(grdiniT);

        iniT.Delay = 0;
        pn.Transitions.add(iniT);



        //----------------------------T1------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("r1r2r3r4");


        Condition T1Ct1 = new Condition(t1, "r1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Copy, "p_f1"));
        grdT1.Activations.add(new Activation(t1, "r1r2r3r4", TransitionOperation.Move, "g1r2r3r4"));
        grdT1.Activations.add(new Activation(t1, "green", TransitionOperation.SendOverNetwork, "OP1"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 5;
        pn.Transitions.add(t1);

        //----------------------------T2------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("g1r2r3r4");


        Condition T2Ct1 = new Condition(t2, "g1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t2, "g1r2r3r4", TransitionOperation.Move, "y1r2r3r4"));
        grdT2.Activations.add(new Activation(t2, "yellow", TransitionOperation.SendOverNetwork, "OP1"));

        t2.GuardMappingList.add(grdT2);

        t2.Delay = 5;
        pn.Transitions.add(t2);


        //----------------------------T3------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("y1r2r3r4");



        Condition T3Ct1 = new Condition(t2, "y1r2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;
        grdT1.Activations.add(new Activation(t1, "y1r2r3r4", TransitionOperation.Copy, "p_f2"));
        grdT3.Activations.add(new Activation(t3, "y1r2r3r4", TransitionOperation.Move, "r1g2r3r4"));
        grdT3.Activations.add(new Activation(t3, "red", TransitionOperation.SendOverNetwork, "OP1"));
        grdT3.Activations.add(new Activation(t3, "green", TransitionOperation.SendOverNetwork, "OP2"));

        t3.GuardMappingList.add(grdT3);

        t3.Delay = 5;
        pn.Transitions.add(t3);


        //----------------------------T4------------------------------------
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("r1g2r3r4");


        Condition T4Ct1 = new Condition(t4, "r1g2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition= T4Ct1;
        grdT4.Activations.add(new Activation(t4, "r1g2r3r4", TransitionOperation.Move, "r1y2r3r4"));
        grdT4.Activations.add(new Activation(t4, "yellow", TransitionOperation.SendOverNetwork, "OP2"));

        t4.GuardMappingList.add(grdT4);

        t4.Delay = 5;
        pn.Transitions.add(t4);


        //----------------------------T5------------------------------------
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("r1y2r3r4");


        Condition T5Ct1 = new Condition(t2, "r1y2r3r4", TransitionCondition.NotNull);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT1.Activations.add(new Activation(t1, "r1y2r3r4", TransitionOperation.Copy, "p_f3"));
        grdT5.Activations.add(new Activation(t5, "r1y2r3r4", TransitionOperation.Move, "r1r2g3r4"));
        grdT5.Activations.add(new Activation(t5, "red", TransitionOperation.SendOverNetwork, "OP2"));
        grdT5.Activations.add(new Activation(t5, "green", TransitionOperation.SendOverNetwork, "OP3"));


        t5.GuardMappingList.add(grdT5);

        t5.Delay = 5;
        pn.Transitions.add(t5);

        //----------------------------T6------------------------------------
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("r1r2g3r4");


        Condition T6Ct1 = new Condition(t2, "r1r2g3r4", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition= T6Ct1;
        grdT6.Activations.add(new Activation(t6, "r1r2g3r4", TransitionOperation.Move, "r1r2y3r4"));
        grdT6.Activations.add(new Activation(t6, "yellow", TransitionOperation.SendOverNetwork, "OP3"));


        t6.GuardMappingList.add(grdT6);

        t6.Delay = 5;
        pn.Transitions.add(t6);

        //----------------------------T7------------------------------------
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("r1r2y3r4");


        Condition T7Ct1 = new Condition(t2, "r1r2y3r4", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT1.Activations.add(new Activation(t1, "r1r2y3r4", TransitionOperation.Copy, "p_f4"));
        grdT7.Activations.add(new Activation(t7, "r1r2y3r4", TransitionOperation.Move, "r1r2r3g4"));
        grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP4"));
        grdT7.Activations.add(new Activation(t7, "red", TransitionOperation.SendOverNetwork, "OP3"));


        t7.GuardMappingList.add(grdT7);

        t7.Delay = 5;
        pn.Transitions.add(t7);

        //----------------------------T8------------------------------------
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("r1r2r3g4");


        Condition T8Ct1 = new Condition(t8, "r1r2r3g4", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition= T8Ct1;
        grdT8.Activations.add(new Activation(t8, "r1r2r3g4", TransitionOperation.Move, "r1r2r3y4"));
        grdT8.Activations.add(new Activation(t8, "yellow", TransitionOperation.SendOverNetwork, "OP4"));


        t8.GuardMappingList.add(grdT8);

        t8.Delay = 5;
        pn.Transitions.add(t8);

        //----------------------------T9------------------------------------
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("r1r2r3y4");


        Condition T9Ct1 = new Condition(t8, "r1r2r3y4", TransitionCondition.NotNull);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition= T9Ct1;
        grdT9.Activations.add(new Activation(t9, "r1r2r3y4", TransitionOperation.Move, "r1r2r3r4"));
        grdT9.Activations.add(new Activation(t9, "red", TransitionOperation.SendOverNetwork, "OP4"));


        t9.GuardMappingList.add(grdT9);

        t9.Delay = 5;
        pn.Transitions.add(t9);

        //----------------------------T_F1------------------------------------
        PetriTransition t_f1 = new PetriTransition(pn);
        t_f1.TransitionName = "t_f1";
        t_f1.InputPlaceName.add("p_f1");
        t_f1.InputPlaceName.add("in1");
        t_f1.IsAsync = true;

        Condition T_f1_1_Ct1 = new Condition(t_f1, "p_f1", TransitionCondition.NotNull);
        Condition T_f1_1_Ct2 = new Condition(t_f1, "in1", TransitionCondition.IsNull);
        T_f1_1_Ct1.SetNextCondition(LogicConnector.AND, T_f1_1_Ct2);

        GuardMapping grdt_f1_1 = new GuardMapping();
        grdt_f1_1.condition= T_f1_1_Ct1;
        grdt_f1_1.Activations.add(new Activation(t2, "FIVE", TransitionOperation.DynamicDelay,""));

        t_f1.GuardMappingList.add(grdt_f1_1);

        Condition T_f1_2_Ct1 = new Condition(t_f1, "p_f1", TransitionCondition.NotNull);
        Condition T_f1_2_Ct2 = new Condition(t_f1, "in1", TransitionCondition.NotNull);
        T_f1_2_Ct1.SetNextCondition(LogicConnector.AND, T_f1_2_Ct2);

        GuardMapping grdt_f1_2 = new GuardMapping();
        grdt_f1_2.condition= T_f1_2_Ct1;
        grdt_f1_2.Activations.add(new Activation(t2, "TEN", TransitionOperation.DynamicDelay,""));
        t_f1.GuardMappingList.add(grdt_f1_2);

        t_f1.Delay = 0;
        pn.Transitions.add(t_f1);

        //----------------------------T_F2------------------------------------
        PetriTransition t_f2 = new PetriTransition(pn);
        t_f2.TransitionName = "t_f2";
        t_f2.InputPlaceName.add("p_f2");
        t_f2.InputPlaceName.add("in2");
        t_f2.IsAsync = true;

        Condition T_f2_1_Ct1 = new Condition(t_f2, "p_f2", TransitionCondition.NotNull);
        Condition T_f2_1_Ct2 = new Condition(t_f2, "in2", TransitionCondition.IsNull);
        T_f2_1_Ct1.SetNextCondition(LogicConnector.AND, T_f2_1_Ct2);

        GuardMapping grdt_f2_1 = new GuardMapping();
        grdt_f2_1.condition= T_f2_1_Ct1;
        grdt_f2_1.Activations.add(new Activation(t4, "FIVE", TransitionOperation.DynamicDelay,""));

        t_f2.GuardMappingList.add(grdt_f2_1);

        Condition T_f2_2_Ct1 = new Condition(t_f2, "p_f2", TransitionCondition.NotNull);
        Condition T_f2_2_Ct2 = new Condition(t_f2, "in2", TransitionCondition.NotNull);
        T_f2_2_Ct1.SetNextCondition(LogicConnector.AND, T_f2_2_Ct2);

        GuardMapping grdt_f2_2 = new GuardMapping();
        grdt_f2_2.condition= T_f2_2_Ct1;
        grdt_f2_2.Activations.add(new Activation(t4, "TEN", TransitionOperation.DynamicDelay,""));

        t_f2.GuardMappingList.add(grdt_f2_2);

        t_f2.Delay = 0;
        pn.Transitions.add(t_f2);

        //----------------------------T_F3------------------------------------
        PetriTransition t_f3 = new PetriTransition(pn);
        t_f3.TransitionName = "t_f3";
        t_f3.InputPlaceName.add("p_f3");
        t_f3.InputPlaceName.add("in3");
        t_f3.IsAsync = true;

        Condition T_f3_1_Ct1 = new Condition(t_f3, "p_f3", TransitionCondition.NotNull);
        Condition T_f3_1_Ct2 = new Condition(t_f3, "in3", TransitionCondition.IsNull);
        T_f3_1_Ct1.SetNextCondition(LogicConnector.AND, T_f3_1_Ct2);

        GuardMapping grdt_f3_1 = new GuardMapping();
        grdt_f3_1.condition= T_f3_1_Ct1;
        grdt_f3_1.Activations.add(new Activation(t6, "FIVE", TransitionOperation.DynamicDelay,""));

        t_f3.GuardMappingList.add(grdt_f3_1);

        Condition T_f3_2_Ct1 = new Condition(t_f3, "p_f3", TransitionCondition.NotNull);
        Condition T_f3_2_Ct2 = new Condition(t_f3, "in3", TransitionCondition.NotNull);
        T_f3_2_Ct1.SetNextCondition(LogicConnector.AND, T_f3_2_Ct2);

        GuardMapping grdt_f3_2 = new GuardMapping();
        grdt_f3_2.condition= T_f3_2_Ct1;
        grdt_f3_2.Activations.add(new Activation(t6, "TEN", TransitionOperation.DynamicDelay,""));

        t_f3.GuardMappingList.add(grdt_f3_2);

        //----------------------------T_F4------------------------------------
        PetriTransition t_f4 = new PetriTransition(pn);
        t_f4.TransitionName = "t_f4";
        t_f4.InputPlaceName.add("p_f4");
        t_f4.InputPlaceName.add("in4");
        t_f4.IsAsync = true;

        Condition T_f4_1_Ct1 = new Condition(t_f4, "p_f4", TransitionCondition.NotNull);
        Condition T_f4_1_Ct2 = new Condition(t_f4, "in4", TransitionCondition.IsNull);
        T_f4_1_Ct1.SetNextCondition(LogicConnector.AND, T_f4_1_Ct2);

        GuardMapping grdt_f4_1 = new GuardMapping();
        grdt_f4_1.condition= T_f4_1_Ct1;
        grdt_f4_1.Activations.add(new Activation(t8, "FIVE", TransitionOperation.DynamicDelay,""));

        t_f4.GuardMappingList.add(grdt_f4_1);

        Condition T_f4_2_Ct1 = new Condition(t_f4, "p_f4", TransitionCondition.NotNull);
        Condition T_f4_2_Ct2 = new Condition(t_f4, "in4", TransitionCondition.NotNull);
        T_f4_2_Ct1.SetNextCondition(LogicConnector.AND, T_f4_2_Ct2);

        GuardMapping grdt_f4_2 = new GuardMapping();
        grdt_f4_2.condition= T_f4_2_Ct1;
        grdt_f4_2.Activations.add(new Activation(t8, "TEN", TransitionOperation.DynamicDelay,""));

        t_f4.GuardMappingList.add(grdt_f4_2);

        t_f4.Delay = 0;
        pn.Transitions.add(t_f4);


        // -------------------------------------------------------------------------------------
        // ----------------------------PN Start-------------------------------------------------
        // -------------------------------------------------------------------------------------

        System.out.println("Controller started \n ------------------------------");
        pn.Delay = 2000;
        // pn.Start();

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);





    }
}
