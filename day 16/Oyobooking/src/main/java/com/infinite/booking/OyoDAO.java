package com.infinite.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.infinite.booking.Rooms;
import com.infinite.booking.SessionHelper;

public class OyoDAO {
SessionFactory sessionFactory;
	
	public String addroom(Rooms rooms) {
		rooms.setRoomId("R001");
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		
		Transaction tran = session.beginTransaction();
		
		session = sessionFactory.openSession();
		session.save(rooms);
		tran.commit();
		session.close();
		
		return "room booked sucess";
	}

	
	
	public List<Rooms> searchRooms(String searchtype, String searchvalue) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Rooms.class);
		if (searchtype.equals("id")) {
			int id =Integer.parseInt(searchvalue);
			cr.add(Restrictions.eq("id", id));
		} 
		if (searchtype.equalsIgnoreCase("type")) {
			cr.add(Restrictions.eq("type", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("status")) {
			cr.add(Restrictions.eq("status", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("costperday")) {
			cr.add(Restrictions.eq("costperday", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("totalrooms")) {
			cr.add(Restrictions.eq("totalrooms", searchvalue));
		}
		List<Rooms> lst = cr.list();
		return lst;
	}

	
}
