package modellayer;

public class PZone {
	
	// Id of actual parking zone
	private int id;
	private String name;

	// Hard coded value
	public PZone() {
		this.id = 2;
		this.name = "Zone B";
	}
	
	// Dynamically set parking zone
	public PZone(int pZoneIdent, String pZoneName) {
		this.id = pZoneIdent;
		this.name = pZoneName;
	}	
	
	public int getpZoneId() {
		return id;
	}

	public void setpZoneId(int pZoneId) {
		this.id = pZoneId;
	}
	
	//TODO: Add getter/setter for name
	
}
