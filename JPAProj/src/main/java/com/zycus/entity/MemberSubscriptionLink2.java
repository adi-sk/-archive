package com.zycus.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//in this example we want a composite primary key
//by combining the member_id and subscription_id
@Entity
public class MemberSubscriptionLink2 {
	
	@EmbeddedId
	private MemberSubscriptionLinkId id;
	
	private Date subscriptionDate;
	private int duration;
	
	public MemberSubscriptionLinkId getId() {
		return id;
	}
	public void setId(MemberSubscriptionLinkId id) {
		this.id = id;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
