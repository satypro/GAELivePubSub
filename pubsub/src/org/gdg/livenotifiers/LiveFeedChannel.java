package org.gdg.livenotifiers;

import org.gdg.publisher.Message;
import org.gdg.util.PubsubJSONSerializer;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


public class LiveFeedChannel {

	 /*Channel API Specific Codes*/	
	 public static String getChannelKey(String user) {
		 Key key = KeyFactory.createKey(user, user);
		    return KeyFactory.keyToString(key);
		  }
	
	public static void sendUpdateToUser(Message  model) {
	    if (model.getSendTo() != null && model.getSendTo()!="") {
	      
		      PubsubJSONSerializer<Message> serialize = new PubsubJSONSerializer<Message>();
		      String messagePayload = serialize.POJOSerializer(model);
		      ChannelService channelService = ChannelServiceFactory.getChannelService();
		      String channelKey = LiveFeedChannel.getChannelKey(model.getSendTo());
		      channelService.sendMessage(new ChannelMessage(channelKey, messagePayload));
	      
	    }
	  }
}
