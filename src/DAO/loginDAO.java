package DAO;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.loginVO;
import VO.registrationVO;

public class loginDAO {
	public void insert(loginVO loginvo)
	{
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session= sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(loginvo);
			tr.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List authentication(loginVO loginvo) {
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session= sessionFactory.openSession();
			
			Query q = session.createQuery("from loginVO where email='"+loginvo.getEmail()+"' and password='"+loginvo.getPassword()+"'");
			
			List ls = new ArrayList();
			
			ls = q.list();
			
			return ls;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List fetchProfile(registrationVO registrationvo) {
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session= sessionFactory.openSession();
			
			Query q = session.createQuery("from registrationVO where userId='"+registrationvo.getUserId()+"'");
			List ls = new ArrayList();
			ls = q.list();
			return ls;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
}
