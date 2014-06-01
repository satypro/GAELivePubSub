/**
 * @author Satendra Singh
 * 
 * The source code is free to use for any purpose, commercial and non commercial
 * 
 * This is the interface to be implemented by all the concrete publisher who wishes to publish and update 
 * to all the subscriber who subscribed them
 */
package org.gdg.publisher;

import org.gdg.subscriber.ISubscriber;

public interface IPublisher {
     
	/**
	 * @param subscriber the subscriber who wishes to subscribe to the publication
	 */
	void attach(ISubscriber subscriber);
	
	/**
	 * 
	 * @param subscriber the subscriber who wishes to detach it self from the publisher and no longer wishes to get notifications
	 */
	void detach(ISubscriber subscriber);
	
	/**
	 * All concrete publisher should broad cast message in this method and call subscriber update method
	 */
	void broadcast();
}
