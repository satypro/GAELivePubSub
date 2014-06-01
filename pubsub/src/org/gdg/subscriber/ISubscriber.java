/**
 * @author Satendra Singh
 */
package org.gdg.subscriber;

import org.gdg.publisher.Message;

public interface ISubscriber {
	/**
	 * 
	 * To be implemented by all the subscriber , it will be trigger whenever any publisher
	 * the subscriber is attached to broadcast any new updatesSs
	 */
	void update(Message message);
}
