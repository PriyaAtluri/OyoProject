package com.infinite.Oyo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.infinite.Oyo.Oyoroom;
import com.infinite.Oyo.SessionHelper;


public class OyoDAO {
SessionFactory sessionFactory;
	
	public String isseuBook(TranBook tranBook) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		if (issueOrNot(tranBook.getBookId())==1) {
			return "Book with id " +tranBook.getBookId() + " Already issued...";
		} 
		Transaction tran = session.beginTransaction();
		session.save(tranBook);
		tran.commit();
		session.close();
		session = sessionFactory.openSession();
		Books book = searchById(tranBook.getBookId());
		book.setTotalBooks(book.getTotalBooks()-1);
		tran=session.beginTransaction();
		session.saveOrUpdate(book);
		tran.commit();
		return "Book with Id " +tranBook.getBookId() + " Issued Successfully...";
	}
	public int issueOrNot(int bookId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(TranBook.class);
		cr.add(Restrictions.eq("bookId", bookId));
		return cr.list().size();
	}
	public List<Oyoroom> searchBooks(String searchtype, String searchvalue) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Oyoroom.class);
		if (searchtype.equals("id")) {
			int id =Integer.parseInt(searchvalue);
			cr.add(Restrictions.eq("id", id));
		} 
		if (searchtype.equals("id")) {
			int id =Integer.parseInt(searchvalue);
			cr.add(Restrictions.eq("id", id));
		} 
		if (searchtype.equalsIgnoreCase("custName")) {
			cr.add(Restrictions.eq("custName", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("city")) {
			cr.add(Restrictions.eq("city", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("bookDate")) {
			cr.add(Restrictions.eq("bookDate", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("chkInDate")) {
			cr.add(Restrictions.eq("chkInDate", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("chkOutDate")) {
			cr.add(Restrictions.eq("chkOutDate", searchvalue));
		}
		List<Oyoroom> lst = cr.list();
		return lst;
	}

	public Books  searchById(int id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
			cr.add(Restrictions.eq("id", id));
		List<Books> booksList = cr.list();
		return booksList.get(0);
	}

	public int loginCheck(String userName, String passWord) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Libusers.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.add(Restrictions.eq("passWord", passWord));
		List<Libusers> listUsers = cr.list();
		return listUsers.size();
	}


}
