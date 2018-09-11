package com.hpe.aposfc.util;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * ���ݿ����ӳ� 
 * @author Administrator
 *
 */
public class DBDataSource {
	public static String drivername; //	����
	public static String url;
	public static String username;
	public static String password;
	
	public static int maxPoolSize; //������ӳ���
	public static int minPoolSize;//��С���ӳ���
	public static int initialPoolSize;//��ʼ�����ӳ���
	public static int checkoutTimeout;//��ʱ
	
	private static ComboPooledDataSource cpDataSource = null;
	//��������
	static {
		Properties p = new Properties();
		try {
			//��ȡ�����ļ�������JDBC�Ĵ����
			p.load(DBDataSource.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			drivername = p.getProperty("drivername");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			
			maxPoolSize = Integer.parseInt(p.getProperty("maxPoolSize"));
			minPoolSize = Integer.parseInt(p.getProperty("minPoolSize"));
			initialPoolSize = Integer.parseInt(p.getProperty("initialPoolSize"));
			checkoutTimeout = Integer.parseInt(p.getProperty("checkoutTimeout"));
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	/**
	 * c3p0 ���ݿ����ӳ� ��������
	 * @throws Exception
	 */
	private static void c3p0DataSource() throws Exception {
		cpDataSource = new ComboPooledDataSource();
		cpDataSource.setDriverClass(drivername);
		cpDataSource.setJdbcUrl(url);
		cpDataSource.setUser(username);
		cpDataSource.setPassword(password);
		cpDataSource.setMaxPoolSize(maxPoolSize);
		cpDataSource.setMinPoolSize(minPoolSize);
		cpDataSource.setInitialPoolSize(initialPoolSize);
		cpDataSource.setCheckoutTimeout(checkoutTimeout);
		
	}
	/**
	 * c3p0���ݿ�������
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnectionC3P0() throws Exception {
		if (cpDataSource == null) {
			c3p0DataSource();
		}
		Connection conn = null;
		if (cpDataSource != null) {
			conn = cpDataSource.getConnection();
		}
		return conn;
	}

}
