package em.createEvent;

import java.util.Date;

//implementation of EventDetails class
public class EventDetails {


	private int eID; 
	private String name; 
	private String type;
	private Date sd;
	private Date st; 
	private Date ed; 
	private Date et;
	private Double budget; 
	private Double tp; 
	private int ti; 
	private int ts; 
	private int uID;
	
	//implementation of Constructor 
	public EventDetails(int eID, String name, String type, Date sd, Date st, Date ed, Date et, Double budget, Double tp,
			int ti, int ts, int uID) {
		super();
		this.eID = eID;
		this.name = name;
		this.type = type;
		this.sd = sd;
		this.st = st;
		this.ed = ed;
		this.et = et;
		this.budget = budget;
		this.tp = tp;
		this.ti = ti;
		this.ts = ts;
		this.uID = uID;
	}
	
	//implementation of Constructor 
	public EventDetails(String name, String type) {
		this.name = name;
		this.type = type;
	}

	
	//implementation of getters
	public int geteID() {
		return eID;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Date getSd() {
		return sd;
	}

	public Date getSt() {
		return st;
	}

	public Date getEd() {
		return ed;
	}

	public Date getEt() {
		return et;
	}

	public Double getBudget() {
		return budget;
	}

	public Double getTp() {
		return tp;
	}

	public int getTi() {
		return ti;
	}

	public int getTs() {
		return ts;
	}

	public int getuID() {
		return uID;
	}	
	
}


