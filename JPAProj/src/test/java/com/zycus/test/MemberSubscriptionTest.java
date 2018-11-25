package com.zycus.test;

import java.util.Date;

import org.junit.Test;

import com.zycus.dao.GenericDao;
import com.zycus.entity.Member;
import com.zycus.entity.MemberSubscriptionLink;
import com.zycus.entity.MemberSubscriptionLink2;
import com.zycus.entity.MemberSubscriptionLinkId;
import com.zycus.entity.Subscription;

public class MemberSubscriptionTest {

	@Test
	public void addMember() {
		GenericDao dao = new GenericDao();
		Member m = new Member();
		m.setName("Majrul");
		m.setEmail("majrul@gmail.com");
		dao.add(m);
	}

	@Test
	public void addSubscription() {
		GenericDao dao = new GenericDao();
		Subscription s = new Subscription();
		s.setMonthlyFees(799);
		s.setSubscriptionFor("Internet TV");
		dao.add(s);
	}
	
	@Test
	public void subscribe() {
		GenericDao dao = new GenericDao();
		Member m = dao.fetchById(Member.class, 1);
		Subscription s = dao.fetchById(Subscription.class, 1);
		
		MemberSubscriptionLink msl = new MemberSubscriptionLink();
		msl.setMember(m);
		msl.setSubscription(s);
		msl.setSubscriptionDate(new Date());
		msl.setDuration(12);
		dao.add(msl);
	}

	@Test
	public void subscribe2() {
		GenericDao dao = new GenericDao();
		Member m = dao.fetchById(Member.class, 1);
		Subscription s = dao.fetchById(Subscription.class, 1);
		
		MemberSubscriptionLink2 msl = new MemberSubscriptionLink2();
		MemberSubscriptionLinkId id = new MemberSubscriptionLinkId();
		id.setMember(m);
		id.setSubscription(s);
		msl.setId(id);
		msl.setSubscriptionDate(new Date());
		msl.setDuration(12);
		dao.add(msl);
	}
}







