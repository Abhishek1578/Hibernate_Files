package com.book;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static SessionFactory getConfiguration()
	{
		Configuration conf=new Configuration().configure().addAnnotatedClass(Book.class);
	    SessionFactory sf=conf.buildSessionFactory();
	    return sf;
	}
	public static void createBook(Session s,Transaction t)
	{
		Book b1 = new Book(101,"Book1",800,"D. morgan","Available");
		Book b2 = new Book(102,"Book2",300,"King pirates","Available");
		Book b3 = new Book(103,"Book3",750,"A.K Shaha","Available");
		Book b4 = new Book(104,"Book4",1000,"Sonali Sambare","Not Available");
		Book b5 = new Book(105,"Book5",900,"Sandeep Kamble","Not Available");

		s.save(b1);
		s.save(b2);
		s.save(b3);
		s.save(b4);
		s.save(b5);
		t.commit();
		
	}
	public static void getBook(Session s,Transaction t)
	{
		Query query = s.createQuery("from Book");
		List<Book> books = ((org.hibernate.query.Query) query).list();
		for(Book getBook:books)
		{
			System.out.println("book availibilty"+getBook.getAvailability()+ "Book id "+getBook.getBook_id()+" Book name "+getBook.getBook_name()+" book price "+getBook.getBook_price()+" book library name "+getBook.getLibraryName());
		}
	}
	public static void updateBook(Session s,Transaction t)
	{
		t.begin();
		Book updatebook =s.find(Book.class,1);
		updatebook.setBook_name("Wings Of Fire");
		s.save(updatebook);
		t.commit();
	}
	public static void deleteBook(Session s,Transaction t)
	{
		t.begin();
		Book deletebook =s.find(Book.class, 2);
		s.delete(deletebook);
		t.commit();
	}
    public static void main( String[] args )
    {
       SessionFactory sf=getConfiguration();
       Session s=sf.openSession();
       Transaction t=s.beginTransaction();
       createBook(s, t);
       getBook(s, t);
       updateBook(s, t);
       deleteBook(s, t);
    }
}
