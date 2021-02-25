package databaselayer;

import modellayer.PZone;
public interface IDbPZone {
	
	//get zone by the Id of it
	public PZone getZonebyId(int zoneId) throws DatabaseLayerException;
}
