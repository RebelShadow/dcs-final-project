package GreenLight;

import java.util.Arrays;

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
        
        DataString p_tl1_left = new DataString();
        p_tl1_left.SetName("TL1_L");
        pn.PlaceList.add(p_tl1_left);
        
        DataString p_ptl1 = new DataString();
        p_ptl1.SetName("PTL1");
        pn.PlaceList.add(p_ptl1);
        
        DataString UserReq_1 = new DataString();
        p_ptl1.SetName("USR_1");
        pn.PlaceList.add(UserReq_1);
        
        DataTransfer OPreq_1 = new DataTransfer();
        OPreq_1.SetName("Preq_1");
        pn.PlaceList.add(OPreq_1);
        
        DataCar p_b1 = new DataCar();
        p_b1.SetName("P_b1");
        pn.PlaceList.add(p_b1);

        DataTransfer op1 = new DataTransfer();
        op1.SetName("OP1");
        op1.Value = new TransferOperation("localhost", "1081", "IN1");
        pn.PlaceList.add(op1);


        // -------------------------------------------------------------------------------------
        // --------------------------------Lane3 - Bulevardul Unirii - dreapta -----------------
        // -------------------------------------------------------------------------------------

        DataCar p_a3 = new DataCar();
        p_a3.SetName("P_a3");
        pn.PlaceList.add(p_a3);

        DataCarQueue p_x3 = new DataCarQueue();
        p_x3.Value.Size = 3; 
        p_x3.SetName("P_x3");
        pn.PlaceList.add(p_x3);

        DataString p_tl3 = new DataString();
        p_tl3.SetName("TL2");
        pn.PlaceList.add(p_tl3);
        
        DataString p_tl3_left = new DataString();
        p_tl3_left.SetName("TL3_L");
        pn.PlaceList.add(p_tl3_left);

        DataCar p_b3 = new DataCar();
        p_b3.SetName("P_b3");
        pn.PlaceList.add(p_b3);

        DataTransfer op3 = new DataTransfer();
        op3.SetName("OP3");
        op3.Value = new TransferOperation("localhost", "1081", "IN3");
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
        p_tl2.SetName("TL3");
        pn.PlaceList.add(p_tl2);
       

        DataCar p_b2 = new DataCar(); //p8.Printable = false;
        p_b2.SetName("P_b2");
        pn.PlaceList.add(p_b2);

        DataTransfer op2 = new DataTransfer();
        op2.SetName("OP2");
        op2.Value = new TransferOperation("localhost", "1081", "IN2");
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
        DataCarQueue p_o3 = new DataCarQueue(); 
        p_o3.Value.Size = 3;
        p_o3.SetName("P_o3");
        pn.PlaceList.add(p_o3);
        
        DataCarQueue Px1_o3 = new DataCarQueue();
        Px1_o3.Value.Size = 3;
        Px1_o3.SetName("Px1_o3");
        pn.PlaceList.add(Px1_o3);
        
        DataCarQueue PS_o3 = new DataCarQueue();
        PS_o3.Value.Size = 3;
        PS_o3.SetName("PS_o3");
        pn.PlaceList.add(PS_o3);
        
        DataCarQueue Px2_o3 = new DataCarQueue();
        Px2_o3.Value.Size = 3;
        Px2_o3.SetName("Px2_o3");
        pn.PlaceList.add(Px2_o3);
        
        DataString Usreq_o3 = new DataString(); 
        Usreq_o3.SetName("Usreq_o3");
        pn.PlaceList.add(Usreq_o3);
        
        DataCar Pt2_o3 = new DataCar(); 
        Pt2_o3.SetName("Pt2_o3");
        pn.PlaceList.add(Pt2_o3);
        
        DataCar Pt3_o3 = new DataCar(); 
        Pt3_o3.SetName("Pt3_o3");
        pn.PlaceList.add(Pt3_o3);
        
        DataCar PExit_car3 = new DataCar(); 
        PExit_car3.SetName("Pexit_car3");
        pn.PlaceList.add(PExit_car3);
        

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
        p_o1exit.SetName("P_o1Exit");
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
        
     // T11 ------Entrance for lane 2-------------------
        PetriTransition t11 = new PetriTransition(pn);
        t11.TransitionName = "Ti_2";
        t11.InputPlaceName.add("P_b2");
        t11.InputPlaceName.add("P_I1");
        
		Condition T11Ct1 = new Condition(t11, "P_b2", TransitionCondition.NotNull);
		Condition T11Ct2 = new Condition(t11, "P_I1", TransitionCondition.CanAddCars);
		T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);
        
		GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t11, "P_b2", TransitionOperation.AddElement, "P_I1"));

        t11.GuardMappingList.add(grdT11);

        t11.Delay = 0;
        pn.Transitions.add(t11);
        
        
        
        
     // T14 -------------------------------------Exit for lane 1------------------------------------------

        PetriTransition t14 = new PetriTransition(pn);
        t14.TransitionName = "T_g3";
        t14.InputPlaceName.add("P_I1");
        t14.InputPlaceName.add("P_o3");

        Condition T14Ct1 = new Condition(t14, "P_I1", TransitionCondition.HaveCarForMe);
        Condition T14Ct2 = new Condition(t14, "P_o3", TransitionCondition.CanAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t14, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
        t14.GuardMappingList.add(grdT14);

        t14.Delay = 0;
        pn.Transitions.add(t14);
        
        
     // T25 -----------------------Car-------------------------
        PetriTransition t25 = new PetriTransition(pn);
        t25.TransitionName = "Tu1_o3car";
        t25.InputPlaceName.add("P_o3");
        t25.InputPlaceName.add("Pexit_car3");

        
        
        Condition T25Ct1 = new Condition(t25, "P_o3", TransitionCondition.HaveCar);

        
        GuardMapping grdT25 = new GuardMapping();
        grdT25.condition = T25Ct1;
        grdT25.Activations.add(new Activation(t25, "P_o3", TransitionOperation.PopElementWithoutTarget, "Pexit_car3"));
        
        t25.GuardMappingList.add(grdT25);

        
        t25.Delay = 0;
        pn.Transitions.add(t25);
        
        
        //Pana aici merge
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

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
        grdT8.Activations.add(new Activation(t8, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
        grdT8.Activations.add(new Activation(t8, "TL3", TransitionOperation.Move, "TL3"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 0;
        pn.Transitions.add(t8);
        

		
		// T9 ------------------------------------------------
		 PetriTransition t9 = new PetriTransition(pn);
	        t9.TransitionName = "TL1_left";
	        t9.InputPlaceName.add("P_x1");
	        t9.InputPlaceName.add("TL1_L");

	        Condition T9Ct1 = new Condition(t9, "TL1_L", TransitionCondition.Equal, "green");
	        Condition T9Ct2 = new Condition(t9, "P_x1", TransitionCondition.HaveCar);
	        T9Ct1.SetNextCondition(LogicConnector.AND, T9Ct2);

	        GuardMapping grdT9 = new GuardMapping();
	        grdT9.condition = T9Ct1;
	        grdT9.Activations.add(new Activation(t9, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
	        grdT9.Activations.add(new Activation(t9, "TL1_L", TransitionOperation.Move, "TL1_L"));

	        t9.GuardMappingList.add(grdT9);


	        t9.Delay = 0;
	        pn.Transitions.add(t9);
	        
	        
	     // T10 ------Entrance for lane 1-------------------
	        PetriTransition t10 = new PetriTransition(pn);
	        t10.TransitionName = "Ti_1";
	        t10.InputPlaceName.add("P_b1");
	        t10.InputPlaceName.add("P_I1");
	        
			Condition T10Ct1 = new Condition(t10, "P_b1", TransitionCondition.NotNull);
			Condition T10Ct2 = new Condition(t10, "P_I1", TransitionCondition.CanAddCars);
			T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);
	        
			GuardMapping grdT10 = new GuardMapping();
	        grdT10.condition = T10Ct1;
	        grdT10.Activations.add(new Activation(t10, "P_b1", TransitionOperation.AddElement, "P_I1"));

	        t10.GuardMappingList.add(grdT10);

	        t10.Delay = 0;
	        pn.Transitions.add(t10);
	        
	     
	        
	     // T12 ------Entrance for lane 3-------------------
	        PetriTransition t12 = new PetriTransition(pn);
	        t12.TransitionName = "Ti_3";
	        t12.InputPlaceName.add("P_b3");
	        t12.InputPlaceName.add("P_I1");
	        
			Condition T12Ct1 = new Condition(t12, "P_b3", TransitionCondition.NotNull);
			Condition T12Ct2 = new Condition(t12, "P_I1", TransitionCondition.CanAddCars);
			T12Ct1.SetNextCondition(LogicConnector.AND, T12Ct2);
	        
			GuardMapping grdT12 = new GuardMapping();
	        grdT12.condition = T12Ct1;
	        grdT12.Activations.add(new Activation(t12, "P_b3", TransitionOperation.AddElement, "P_I1"));

	        t12.GuardMappingList.add(grdT12);

	        t12.Delay = 0;
	        pn.Transitions.add(t12);
	        
	     // T13 ------Entrance for lane 4-------------------
	        PetriTransition t13 = new PetriTransition(pn);
	        t13.TransitionName = "Ti_4";
	        t13.InputPlaceName.add("P_b4");
	        t13.InputPlaceName.add("P_I1");
	        
			Condition T13Ct1 = new Condition(t13, "P_b4", TransitionCondition.NotNull);
			Condition T13Ct2 = new Condition(t13, "P_I1", TransitionCondition.CanAddCars);
			T13Ct1.SetNextCondition(LogicConnector.AND, T13Ct2);
	        
			GuardMapping grdT13 = new GuardMapping();
	        grdT13.condition = T13Ct1;
	        grdT13.Activations.add(new Activation(t13, "P_b4", TransitionOperation.AddElement, "P_I1"));

	        t13.GuardMappingList.add(grdT13);

	        t13.Delay = 0;
	        pn.Transitions.add(t13);
	        
	        
	     
	        
	     // T15 -------------------------------------Exit for lane 2------------------------------------------


	        PetriTransition t15 = new PetriTransition(pn);
	        t15.TransitionName = "T_g4";
	        t15.InputPlaceName.add("P_I1");
	        t15.InputPlaceName.add("P_o4");

	        Condition T15Ct1 = new Condition(t15, "P_I1", TransitionCondition.HaveCarForMe);
	        Condition T15Ct2 = new Condition(t15, "P_o4", TransitionCondition.CanAddCars);
	        T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

	        GuardMapping grdT15 = new GuardMapping();
	        grdT15.condition = T15Ct1;
	        grdT15.Activations.add(new Activation(t15, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o4"));
	        t15.GuardMappingList.add(grdT15);

	        t15.Delay = 0;
	        pn.Transitions.add(t15);
	        
	        
	     // T16 -------------------------------------Exit for lane 3------------------------------------------


	        PetriTransition t16 = new PetriTransition(pn);
	        t16.TransitionName = "T_g1";
	        t16.InputPlaceName.add("P_I1");
	        t16.InputPlaceName.add("P_o1");

	        Condition T16Ct1 = new Condition(t16, "P_I1", TransitionCondition.HaveCarForMe);
	        Condition T16Ct2 = new Condition(t16, "P_o1", TransitionCondition.CanAddCars);
	        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

	        GuardMapping grdT16 = new GuardMapping();
	        grdT16.condition = T16Ct1;
	        grdT16.Activations.add(new Activation(t16, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
	        t16.GuardMappingList.add(grdT16);

	        t16.Delay = 0;
	        pn.Transitions.add(t16);
	        
	        
	     // T17 -------------------------------------Exit for lane 4------------------------------------------


	        PetriTransition t17 = new PetriTransition(pn);
	        t17.TransitionName = "T_g2";
	        t17.InputPlaceName.add("P_I1");
	        t17.InputPlaceName.add("P_o2");

	        Condition T17Ct1 = new Condition(t17, "P_I1", TransitionCondition.HaveCarForMe);
	        Condition T17Ct2 = new Condition(t17, "P_o2", TransitionCondition.CanAddCars);
	        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

	        GuardMapping grdT17 = new GuardMapping();
	        grdT17.condition = T17Ct1;
	        grdT17.Activations.add(new Activation(t17, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o2"));
	        t17.GuardMappingList.add(grdT17);

	        t17.Delay = 0;
	        pn.Transitions.add(t17);
	        
	        
	     // T18 ------------------------------------------------
			 PetriTransition t18 = new PetriTransition(pn);
		        t18.TransitionName = "TL3_left";
		        t18.InputPlaceName.add("P_x3");
		        t18.InputPlaceName.add("TL3_L");

		        Condition T18Ct1 = new Condition(t18, "TL3_L", TransitionCondition.Equal, "green");
		        Condition T18Ct2 = new Condition(t18, "P_x3", TransitionCondition.HaveCar);
		        T18Ct1.SetNextCondition(LogicConnector.AND, T18Ct2);

		        GuardMapping grdT18 = new GuardMapping();
		        grdT18.condition = T18Ct1;
		        grdT18.Activations.add(new Activation(t18, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
		        grdT18.Activations.add(new Activation(t18, "TL3_L", TransitionOperation.Move, "TL3_L"));

		        t18.GuardMappingList.add(grdT18);


		        t18.Delay = 0;
		        pn.Transitions.add(t18);
		        
		 // T19 -----------------------Bus-------------------------
		        PetriTransition t19 = new PetriTransition(pn);
		        t19.TransitionName = "Tu1_o3";
		        t19.InputPlaceName.add("P_o3");
		        t19.InputPlaceName.add("Px1_o3");
		        
		        Condition T19Ct1 = new Condition(t19, "P_o3", TransitionCondition.NotNull);
		        Condition T19Ct2 = new Condition(t19, "Px1_o3", TransitionCondition.CanAddCars);
		        Condition T19Ct3 = new Condition(t19, "Px1_o3", TransitionCondition.IsBus);

		        T19Ct1.SetNextCondition(LogicConnector.AND, T19Ct2);
		        T19Ct2.SetNextCondition(LogicConnector.AND, T19Ct3);

		        GuardMapping grdT19 = new GuardMapping();
		        grdT19.condition = T19Ct1;
		        grdT19.Activations.add(new Activation(t19, "P_o3", TransitionOperation.Move, "Px1_o3"));
		        
		        t19.GuardMappingList.add(grdT19);
		        
		        //-----------------------Priority-------------------------
		        
		        Condition T19Ct4 = new Condition(t19, "P_o3", TransitionCondition.NotNull);
		        Condition T19Ct5 = new Condition(t19, "Px1_o3", TransitionCondition.CanAddCars);
		        Condition T19Ct6 = new Condition(t19, "Px1_o3", TransitionCondition.IsPriorityCar);

		        T19Ct4.SetNextCondition(LogicConnector.AND, T19Ct5);
		        T19Ct5.SetNextCondition(LogicConnector.AND, T19Ct6);

		        GuardMapping grdT19_new = new GuardMapping();
		        grdT19_new.condition = T19Ct4;
		        grdT19_new.Activations.add(new Activation(t19, "P_o3", TransitionOperation.Move, "Px1_o3"));
		        
		        t19.GuardMappingList.add(grdT19_new);

		        
		        t19.Delay = 0;
		        pn.Transitions.add(t19);
		        
		        
		     // T20 -----------------------Priority-------------------------
		        PetriTransition t20 = new PetriTransition(pn);
		        t20.TransitionName = "T1_o3";
		        t20.InputPlaceName.add("Px1_o3");
		        t20.InputPlaceName.add("Px2_o3");
		        
		        
		        Condition T20Ct1 = new Condition(t20, "Px2_o3", TransitionCondition.NotNull);
		        Condition T20Ct2 = new Condition(t20, "Px2_o3", TransitionCondition.CanAddCars);
		        Condition T20Ct3 = new Condition(t20, "Px1_o3", TransitionCondition.IsPriorityCar);

		        T20Ct1.SetNextCondition(LogicConnector.AND, T20Ct2);
		        T20Ct2.SetNextCondition(LogicConnector.AND, T20Ct3);
		        
		        GuardMapping grdT20 = new GuardMapping();
		        grdT20.condition = T20Ct3;
		        grdT20.Activations.add(new Activation(t20, "Px1_o3", TransitionOperation.Move, "Px2_o3"));
		        
		        t20.GuardMappingList.add(grdT20);

		        
		        t20.Delay = 0;
		        pn.Transitions.add(t20);
		        
		     // T21 -----------------------Bus-------------------------
		        PetriTransition t21 = new PetriTransition(pn);
		        t21.TransitionName = "Ts_o3";
		        t21.InputPlaceName.add("Px1_o3");
		        t21.InputPlaceName.add("Ps_o3");
		        
		        
		        Condition T21Ct1 = new Condition(t21, "Px1_o3", TransitionCondition.HaveTaxi);
		        Condition T21Ct2 = new Condition(t21, "Ps_o3", TransitionCondition.HaveCar);

		        T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);
		        
		        GuardMapping grdT21 = new GuardMapping();
		        grdT21.condition = T21Ct1;
		        grdT21.Activations.add(new Activation(t21, "Px1_o3", TransitionOperation.PopElementWithoutTarget,"Ps_o3"));
		        
		        t21.GuardMappingList.add(grdT21);

		        
		        t21.Delay = 0;
		        pn.Transitions.add(t21);
		        
		     // T22 -----------------------Bus-------------------------
		        PetriTransition t22 = new PetriTransition(pn);
		        t22.TransitionName = "Tes_o3";
		        t22.InputPlaceName.add("Px2_o3");
		        t22.InputPlaceName.add("Ps_o3");
		        t22.InputPlaceName.add("Usreq_o3");

		        
		        
		        Condition T22Ct11 = new Condition(t22, "Ps_o3", TransitionCondition.HaveCar);
		        Condition T22Ct21 = new Condition(t22, "Usreq_o3", TransitionCondition.NotNull);

		        T22Ct11.SetNextCondition(LogicConnector.AND, T22Ct21);
		        
		        GuardMapping grdT22 = new GuardMapping();
		        grdT22.condition = T22Ct11;
		        grdT22.Activations.add(new Activation(t22, "Ps_o3", TransitionOperation.PopTaxiToQueue,"Px2_o3")); // cannot pop a bus to queue
		        
		        t22.GuardMappingList.add(grdT22);

		        
		        t22.Delay = 0;
		        pn.Transitions.add(t22);
		        
		        // T23 -----------------------Bus-------------------------
		        PetriTransition t23 = new PetriTransition(pn);
		        t23.TransitionName = "T2_o3";
		        t23.InputPlaceName.add("Px2_o3");
		        t23.InputPlaceName.add("Pt2_o3");

		        
		        
		        Condition T23Ct11 = new Condition(t23, "Px2_o3", TransitionCondition.HaveCar);
		        
		        GuardMapping grdT23 = new GuardMapping();
		        grdT23.condition = T23Ct11;
		        grdT23.Activations.add(new Activation(t23, "Px2_o3", TransitionOperation.PopElementWithTarget,"Pt2_o3"));
		        
		        t23.GuardMappingList.add(grdT23);

		        
		        t23.Delay = 0;
		        pn.Transitions.add(t23);
		        
		     // T24 -----------------------Bus-------------------------
		        PetriTransition t24 = new PetriTransition(pn);
		        t24.TransitionName = "T3_o3";
		        t24.InputPlaceName.add("Px2_o3");
		        t24.InputPlaceName.add("Pt3_o3");

		        
		        
		        Condition T24Ct11 = new Condition(t24, "Px2_o3", TransitionCondition.HaveCar);
		        
		        GuardMapping grdT24 = new GuardMapping();
		        grdT24.condition = T24Ct11;
		        grdT24.Activations.add(new Activation(t24, "Px2_o3", TransitionOperation.PopElementWithTarget,"Pt3_o3"));
		        
		        t24.GuardMappingList.add(grdT24);

		        
		        t24.Delay = 0;
		        pn.Transitions.add(t24);
		        
		     
		        // T26 -----------------------Car-------------------------
		        PetriTransition t26 = new PetriTransition(pn);
		        t26.TransitionName = "Tu1_o4car";
		        t26.InputPlaceName.add("P_o4");
		        t26.InputPlaceName.add("Pexit_car4");

		        
		        
		        Condition T26Ct1 = new Condition(t26, "P_o4", TransitionCondition.HaveCar);

		        
		        GuardMapping grdT26 = new GuardMapping();
		        grdT26.condition = T26Ct1;
		        grdT26.Activations.add(new Activation(t26, "P_o4", TransitionOperation.PopElementWithoutTarget,"Pexit_car4"));
		        
		        t26.GuardMappingList.add(grdT26);

		        
		        t26.Delay = 0;
		        pn.Transitions.add(t26);   
		        

		        
		     // T28 -----------------------Car-------------------------
		        PetriTransition t28 = new PetriTransition(pn);
		        t28.TransitionName = "Tu1_o2car";
		        t28.InputPlaceName.add("P_o2");
		        t28.InputPlaceName.add("Pexit_car2");

		        
		        
		        Condition T28Ct1 = new Condition(t28, "P_o2", TransitionCondition.HaveCar);

		        
		        GuardMapping grdT28 = new GuardMapping();
		        grdT28.condition = T28Ct1;
		        grdT28.Activations.add(new Activation(t28, "P_o2", TransitionOperation.PopElementWithoutTarget,"Pexit_car2"));
		        
		        t28.GuardMappingList.add(grdT28);

		        
		        t28.Delay = 0;
		        pn.Transitions.add(t28);   
		        
		        
			     // T27 -----------------------Car-------------------------
		        PetriTransition t27 = new PetriTransition(pn);
		        t27.TransitionName = "Tu1_o1car";
		        t27.InputPlaceName.add("P_o1");
		        t27.InputPlaceName.add("P_o1Exit");

		        
		        
		        Condition T27Ct1 = new Condition(t27, "P_o1", TransitionCondition.HaveCar);

		        
		        GuardMapping grdT27 = new GuardMapping();
		        grdT27.condition = T27Ct1;
		        grdT27.Activations.add(new Activation(t27, "P_o1", TransitionOperation.PopElementWithoutTarget,"P_o1Exit"));
		        
		        t27.GuardMappingList.add(grdT27);

		        
		        t27.Delay = 0;
		        pn.Transitions.add(t27);
		        
		        
		     // T29 ------------------------------------------------
		        PetriTransition t29= new PetriTransition(pn);
		        t29.TransitionName = "T_send5";
		        t29.InputPlaceName.add("P_o1Exit");

		        Condition T29Ct1 = new Condition(t29, "P_o1Exit", TransitionCondition.NotNull);

		        GuardMapping grdT29 = new GuardMapping();
		        grdT29.condition = T29Ct1;
		        grdT29.Activations.add(new Activation(t29, "P_o1Exit", TransitionOperation.SendOverNetwork, "OP_Int2"));

		        t29.GuardMappingList.add(grdT29);

		        t29.Delay = 0;
		        pn.Transitions.add(t29);
		        

	        
	        
	        
	        
	        
	        System.out.println("Exp1 started \n ------------------------------");
	        pn.Delay = 2000;
	        // pn.Start();
	        PetriNetWindow frame = new PetriNetWindow(false);
			frame.petriNet = pn;
			frame.setVisible(true);
    }

}
