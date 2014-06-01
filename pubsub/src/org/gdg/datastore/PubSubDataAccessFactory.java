package org.gdg.datastore;

public class PubSubDataAccessFactory {

	private static IPubsubDBFactory pf=null;
	
	public static IPubsubDBFactory getFactory(){
		
		//if we want a singleton object, here we have to decide whether we want a pool of object
		if(pf ==null)
		   pf = new PubsubBDFactory();
		return pf;
	}
	
}
