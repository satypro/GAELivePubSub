package org.gdg.datastore;

import org.gdg.entity.ChannelToken;

public class PubSubGoogleJDO implements IPubsubDatabase {

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

	@Override
	public ChannelToken GeTokenState(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void PersistToken(ChannelToken tokens) {
		// TODO Auto-generated method stub
		
	}

}
