package com.hpe.aposfc.test;

import java.sql.Connection;

import java.sql.SQLException;

import com.hpe.aposfc.util.DBDataSource;

public class TestSource {
	public static void main(String[] args) throws Exception {
		
		Connection cnn = DBDataSource.getConnectionC3P0();
		try {
			if(!cnn.isClosed()){
				System.out.println("���ӳɹ�");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
