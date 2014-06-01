package org.gdg.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChannelToken {
	
	@Id
	String          user;
	Date 			leaseStartTime;
    String          channelToken;
    
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getLeaseStartTime() {
		return leaseStartTime;
	}
	public void setLeaseStartTime(Date leaseStartTime) {
		this.leaseStartTime = leaseStartTime;
	}
	public String getChannelToken() {
		return channelToken;
	}
	public void setChannelToken(String channelToken) {
		this.channelToken = channelToken;
	}
	
}
