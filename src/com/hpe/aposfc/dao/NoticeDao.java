package com.hpe.aposfc.dao;

import java.util.List;

import com.hpe.aposfc.po.Notice;

public interface NoticeDao {
	List<Notice> selectNotice();
	void addNotice(Notice notice);
	void deleteNotice(Notice notice);
	Notice selectNoticeById(int id);
	Notice selectNoticeByName(String name);
}
