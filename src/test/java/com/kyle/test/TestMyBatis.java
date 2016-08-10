package com.kyle.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kyle.pojo.User;
import com.kyle.pojo.mapper.UserMapper;

public class TestMyBatis extends TestCase {

	@Test
	public void testMyBatis() {
		String source = "mybatis-config.xml";
		SqlSession session = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(source);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			session = sqlSessionFactory.openSession();
			
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.getUser(2);
			System.out.println(user);
		} catch (IOException e) {
			e.printStackTrace();
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
