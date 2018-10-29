package com.baizhi.dangdang.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory = null;
	static{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	public static SqlSession openSession(){
		SqlSession session = tol.get();
		if(session == null){
			session = factory.openSession();
			tol.set(session);
		}
		return session;
	}
	
	public static void commit(){
		SqlSession session = openSession();
		session.commit(true);
		close();
	}
	
	public static void rollback(){
		SqlSession session = openSession();
		session.rollback(true);
		close();
	}
	
	
	public static void close(){
		SqlSession session = openSession();
		tol.remove();
		session.close();
	}
	
	
	public  static <T> Object getDao(Class<T> t){
		SqlSession session = openSession();
		return session.getMapper(t);
	}
}
