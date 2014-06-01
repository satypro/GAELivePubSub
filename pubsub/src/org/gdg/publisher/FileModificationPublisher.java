package org.gdg.publisher;

import java.util.ArrayList;
import java.util.List;
import org.gdg.subscriber.ISubscriber;

public class FileModificationPublisher implements IPublisher {

	private List<ISubscriber> subscriberList;
	
	public FileModificationPublisher()
	{
		subscriberList = new ArrayList<ISubscriber>();
	}
	
	@Override
	public void attach(ISubscriber subscriber) {
		subscriberList.add(subscriber);
	}

	@Override
	public void detach(ISubscriber subscriber) {
       subscriberList.remove(subscriber);		
	}

	@Override
	public void broadcast() {
		
		Message message = new Message();
		message.setSendTo("pubsub");
		message.setMessage("got the message");
		message.setSubjet("Modification Message");
		
		for (ISubscriber subscriber : subscriberList) {
			 subscriber.update(message);
		}
	}

}
