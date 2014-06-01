package org.gdg.pubsub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gdg.publisher.FileModificationPublisher;
import org.gdg.publisher.IPublisher;
import org.gdg.subscriber.LiveFileChangeNotifier;

public class SendUpdate extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	    IPublisher publisher = new FileModificationPublisher();
		new LiveFileChangeNotifier(publisher);
		publisher.broadcast();
		
		
	}
}
