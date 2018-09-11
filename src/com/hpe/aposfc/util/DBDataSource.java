package com.hpe.aposfc.util;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据库连接池 
 * @author Administrator
 *
 */
public class DBDataSource {
	public static String drivername; //	驱动
	public static String url;
	public static String username;
	public static String password;
	
	public static int maxPoolSize; //最大连接池数
	public static int minPoolSize;//最小连接池数
	public static int initialPoolSize;//初始化连接池数
	public static int checkoutTimeout;//超时
	
	private static ComboPooledDataSource cpDataSource = null;
	//加载驱动
	static {
		Properties p = new Properties();
		try {
			//读取配置文件，加载JDBC四大参数
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * c3p0 数据库连接池 启动方法
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
	 * c3p0数据库连接入
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
