package org.gdg.subscriber;

import org.gdg.livenotifiers.EmailNotifier;
import org.gdg.livenotifiers.LiveFeedChannel;
import org.gdg.publisher.IPublisher;
import org.gdg.publisher.Message;

public class LiveFileChangeNotifier implements ISubscriber {

	IPublisher publisher;
	
	public LiveFileChangeNotifier(IPublisher publisher)
	{
		this.publisher = publisher;
		publisher.attach(this);
	}
	
	@Override
	public void update(Message message) {
		
		LiveFeedChannel.sendUpdateToUser(message);
		EmailNotifier.sendUpdate(message, "satendrasarvagya@gmail.com");
		
	}

	
}
