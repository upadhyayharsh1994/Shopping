package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.cardDetailsVO;
import VO.orderDetailsVO;
import VO.orderVO;
import VO.registrationVO;

public class checkoutDAO {
	public void insert(cardDetailsVO carddetailsvo)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session= sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(carddetailsvo);
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void order(orderDetailsVO ordervo)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session= sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(ordervo);
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
