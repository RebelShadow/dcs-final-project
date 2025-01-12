package Enumerations;

import java.io.Serializable;

public enum TransitionCondition implements Serializable {
	Undefined,
	Equal,
	NotEqual,
	MoreThan,
	MoreThanOrEqual,
	LessThan,
	LessThanOrEqual,
	Contains,
	NotContains,
	IsNull,
	NotNull,
	HaveCarForMe,
	CanAddCars,
	CanNotAddCars,
	HaveCar,
	HaveREL,
	SubPetriStopped,
	
	Equal_FloatFloat,            //the transition conditions for floatfloat
	MoreThan_FloatFloat,         //the transition conditions for floatfloat
	MoreThanOrEqual_FloatFloat,  //the transition conditions for floatfloat
	LessThan_FloatFloat,         //the transition conditions for floatfloat
	LessThanOrEqual_FloatFloat,  //the transition conditions for floatfloat
	FLRS,

	// Added conditions for PriorityCar, Bus, and Taxi
	IsPriorityCar,
	IsBus,
	IsTaxi,
	HavePriorityCar,
	HaveBus,
	HaveTaxi
}