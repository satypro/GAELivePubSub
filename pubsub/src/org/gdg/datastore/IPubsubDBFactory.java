package org.gdg.datastore;

public interface IPubsubDBFactory {
	
	IPubsubDatabase getJDOFactory();
	IPubsubDatabase getJPAFactory();
}
