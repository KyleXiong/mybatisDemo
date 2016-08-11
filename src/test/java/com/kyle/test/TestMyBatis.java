package com.kyle.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import com.kyle.pojo.User;
import com.kyle.pojo.mapper.UserMapper;

public class TestMyBatis extends TestCase {
    
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Override
	protected void setUp() throws Exception {
		try {
			String source = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void testSelect() {
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUser(2);
			System.out.println(user);
		} 
		finally
		{
			if(null != session)
			{
				session.close();
			}
		}
	}
	
	@Test
	public void testSelectUsers() {
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			List<User> users = mapper.getUsers();
			if(null != users)
			{
				for(User u : users)
				{
					System.out.println(u);
				}
			}
		} 
		finally
		{
			if(null != session)
			{
				session.close();
			}
		}
	}
	
	@Ignore
    @Test
	public void testInsert() {
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setName("许三多");
			user.setAge(26);
			mapper.insertUser(user);
			session.commit();
			System.out.println("insert successfully!");
		} 
		finally
		{
			if(null != session)
			{
				session.close();
			}
		}
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setAge(20);
			user.setId(5);
			mapper.updateUser(user);
			session.commit();
			System.out.println("update successfully!");
		} 
		finally
		{
			if(null != session)
			{
				session.close();
			}
		}
	}
	
	@Ignore
	@Test
	public void testDelete() {
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = new User();
			user.setId(5);
			mapper.deleteUser(user);
			session.commit();
			System.out.println("delete successfully!");
		} 
		finally
		{
			if(null != session)
			{
				session.close();
			}
		}
	}
}
