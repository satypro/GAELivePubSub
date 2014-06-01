package org.gdg.datastore;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.gdg.entity.ChannelToken;


public class PubSubGoogleJPA implements IPubsubDatabase {

	private static final Logger log = Logger.getLogger(PubSubGoogleJPA.class.getName());
	
	private static EntityManagerFactory emf;
	  
    public PubSubGoogleJPA(){
    	   if(emf ==null)
    	      emf  = PubSubJPAEMF.get();
       }

	@Override
	public <T> boolean PersistEntity(Object object, Class<T> type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T RetrieveSingleEntity(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ChannelToken GeTokenState(String  user)
	 {
	 	  
	 	    EntityManager em = emf.createEntityManager();
	 		try
	 		{
	 		
	 		TypedQuery<ChannelToken> query = em.createQuery(
	 		        "SELECT c FROM ChannelToken c WHERE c.user=:users", ChannelToken.class);
	 		
	 		query.setParameter("users", user);
	 		
	 	  
	 		ChannelToken response = query.getSingleResult();
	 	    
	 		return 	response;
	 		
	 		} 
	 		catch(Exception ex)
	 		{
	 			
	 			log.severe("Error Occured for ChannelTokens"+user+" "+ex.getMessage());
	 			return null;
	 		}
	 		finally{
	 			
	 			if(em.isOpen())
	 				em.close();
	 		}
	 	
	 }
 
	public void PersistToken(ChannelToken tokens){
	    	
	    	EntityManager em = emf.createEntityManager();
			try
			{
			  
			   em.persist(tokens);
			   
			}
			catch(Exception ex)
			{
				log.severe("Error in Persisting the channel token");
			}
			finally{
				
				if(em != null && em.isOpen())
					em.close();
			}
	    	
	    }
	 
}
