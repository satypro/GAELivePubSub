package org.gdg.datastore;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PubSubJPAEMF {

	    private static final EntityManagerFactory emfInstance =
	        Persistence.createEntityManagerFactory("transactions-optional");

	    private PubSubJPAEMF() {}
	    
	    public static EntityManagerFactory get() {
	        return emfInstance;
	    }
}
