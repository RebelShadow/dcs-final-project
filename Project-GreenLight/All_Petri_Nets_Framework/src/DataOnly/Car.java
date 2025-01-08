package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Overriding clone() method of Object class
	public Car clone() throws CloneNotSupportedException {
		return (Car) super.clone();
	}

	public String Model;
	public String Number;
	public List<String> Targets;

	// New attributes for priority, bus, and taxi
	public boolean priority;
	public boolean bus;
	public boolean taxi;

	// Updated constructor with new attributes
	public Car(String Model, String Number, ArrayList<String> Targets, boolean priority, boolean bus, boolean taxi) {
		this.Model = Model;
		this.Number = Number;
		this.Targets = new ArrayList<String>();
		this.Targets.addAll(Targets);
		this.priority = priority;
		this.bus = bus;
		this.taxi = taxi;
	}

	// Updated constructor with new attributes
	public Car(String Model, String Number, String[] Targets, boolean priority, boolean bus, boolean taxi) {
		this.Model = Model;
		this.Number = Number;
		this.Targets = new ArrayList<String>();
		for (String string : Targets) {
			this.Targets.add(string);
		}
		this.priority = priority;
		this.bus = bus;
		this.taxi = taxi;
	}

	// toString method to display Car information
	public String toString() {
		return Model + "-" + Number;
	}
};