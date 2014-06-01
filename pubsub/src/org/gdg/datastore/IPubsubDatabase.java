package org.gdg.datastore;

import org.gdg.entity.ChannelToken;

public interface IPubsubDatabase {

	<T> boolean PersistEntity(Object object,Class<T> type);
	<T> T RetrieveSingleEntity(Class<T> type);
	ChannelToken GeTokenState(String  user);
	void PersistToken(ChannelToken tokens);
}
