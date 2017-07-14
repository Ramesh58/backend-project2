package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.niit.dao.BlogPostDao;
import com.niit.dao.BlogPostDaoImpl;
import com.niit.dao.FriendDao;
import com.niit.dao.FriendDaoImpl;
import com.niit.dao.JobDao;
import com.niit.dao.JobDaoImpl;
import com.niit.dao.UsersDao;
import com.niit.dao.UsersDaoImpl;
import com.niit.model.BlogComment;
import com.niit.model.BlogPost;
import com.niit.model.Friend;
import com.niit.model.Job;
import com.niit.model.Users;





public class DBConfig

{
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("ramesh");
		dataSource.setPassword("ramesh");

		System.out.println("DataBase is connected.........!");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClasses(Users.class);
		 sessionBuilder.addAnnotatedClasses(Job.class);
		 sessionBuilder.addAnnotatedClasses(BlogPost.class);
		 sessionBuilder.addAnnotatedClasses(BlogComment.class);
		 sessionBuilder.addAnnotatedClasses(Friend.class);
		 
		/*  sessionBuilder.addAnnotatedClasses(Blog.class);
		  sessionBuilder.addAnnotatedClasses(Friend.class);
		  sessionBuilder.addAnnotatedClasses(Job.class);
		  sessionBuilder.addAnnotatedClasses(Forum.class);
		  sessionBuilder.addAnnotatedClasses(ForumComment.class);
		 sessionBuilder.addAnnotatedClasses(BlogLikes.class);*/
		 
		System.out.println("Session is crated................!");

		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction is crated............!");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="usersDao")
	public UsersDao getusersDAO(SessionFactory sessionFactory){
		
		return new UsersDaoImpl();
	}
	@Autowired
	@Bean(name="jobDao")
	public JobDao getjobDAO(SessionFactory sessionFactory){
		
		return new JobDaoImpl();
	}
	@Autowired
	@Bean(name="blogPostDao")
	public BlogPostDao getblogPostDAO(SessionFactory sessionFactory)
	{
		
		return new BlogPostDaoImpl();
	}
	@Autowired
	@Bean(name="friendDao")
	public FriendDao getfriendDao(SessionFactory sessionFactory){
		
		return new FriendDaoImpl();
	}

	
}