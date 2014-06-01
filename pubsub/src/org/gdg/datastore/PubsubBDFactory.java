package org.gdg.datastore;

public class PubsubBDFactory implements IPubsubDBFactory {

	@Override
	public IPubsubDatabase getJDOFactory() {
		return new PubSubGoogleJDO();
	}

	@Override
	public IPubsubDatabase getJPAFactory() {
		return new PubSubGoogleJPA();
	}

}
