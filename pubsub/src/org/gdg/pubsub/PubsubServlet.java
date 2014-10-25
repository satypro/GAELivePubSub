package org.gdg.pubsub;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.*;

import org.gdg.datastore.IPubsubDatabase;
import org.gdg.datastore.PubSubDataAccessFactory;
import org.gdg.entity.ChannelToken;
import org.gdg.livenotifiers.LiveFeedChannel;

import com.google.appengine.api.channel.ChannelService;
import com.google.appengine.api.channel.ChannelServiceFactory;


@SuppressWarnings("serial")
public class PubsubServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(PubsubServlet.class.getName());
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("application/json");
		String token = getChannelToken(req);
		resp.getWriter().println(token);
	}
	
	
	private String getChannelToken(HttpServletRequest req){
		
		String token="";
		try
		{
		   IPubsubDatabase database = PubSubDataAccessFactory.getFactory().getJPAFactory();
		   String user              = req.getParameter("user");   
		   ChannelToken savedToken  = database.GeTokenState(user);
		  
		   long diffMinutes = 0l;
		   
		   if(savedToken !=null)
		   {
			   long diff = (new Date()).getTime() - savedToken.getLeaseStartTime().getTime();
			   diffMinutes = diff / (60 * 1000); 
			   
			   //Channel API Persist the channel token for 2 hours ideally....
			   if(diffMinutes<=110)
			   {
				   token = savedToken.getChannelToken();
				   return token;
			   }
			  
		   }
		   
		   String channelKey             = LiveFeedChannel.getChannelKey(user);
		   ChannelService channelService = ChannelServiceFactory.getChannelService();
		   token                         = channelService.createChannel(channelKey); 
		   
		   ChannelToken channelToken = new ChannelToken();
	       channelToken.setChannelToken(token);
	       channelToken.setLeaseStartTime(new Date());
	       channelToken.setUser(user);
	       database.PersistToken(channelToken);
	       
		}
		catch(Exception ex)
		{
			log.log(Level.SEVERE,"Error Occured while setting up the channel API");
		}
		return token;
	}
}
