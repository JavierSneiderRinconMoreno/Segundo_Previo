package modelo;

public class Bill {
	
	private  int id; 	
	private  int date_bill; 	
	private  int user_id; 	
	private  double value; 	
	private int type; 	
	private  String observation;
	
	
	public Bill(int date_bill, String observation, double value ) {
		super();
		this.date_bill = date_bill;
		this.value = value;
		this.observation = observation;
	}

	public Bill(int id, int date_bill, int user_id, double value, int type, String observation) {
		super();
		this.id = id;
		this.date_bill = date_bill;
		this.user_id = user_id;
		this.value = value;
		this.type = type;
		this.observation = observation;
	}
	
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDate_bill() {
		return date_bill;
	}
	public void setDate_bill(int date_bill) {
		this.date_bill = date_bill;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	} 
	
	
	
	
	
	

}
