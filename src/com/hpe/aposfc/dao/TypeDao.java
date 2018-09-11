package com.hpe.aposfc.dao;

import java.util.List;

import com.hpe.aposfc.po.Type;


public interface TypeDao {
	List<Type> selectType();
	void addType(Type type);
	void updateType(Type type);
	void deleteType(Type type);
	Type selectTypeById(int id);
	Type selectTypeByName(String name);
}
