package com.hpe.aposfc.dao.impl;

import java.util.List;

import com.hpe.aposfc.dao.NoticeDao;
import com.hpe.aposfc.po.Notice;
import com.hpe.aposfc.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao{
	private DBUtil dbUtil = new DBUtil();
		@Override
		public List<Notice> selectNotice() {
			String sql = "select * from notice";
			List list = null;
			Object[] params = {};
			try {
				list = dbUtil.getQueryList(Notice.class, sql, params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		@Override
		public void addNotice(Notice notice) {
			String sql = "insert into notice(name,content,times) values(?,?,?)";
			Object[] params = { notice.getName(),notice.getContent(),notice.getTimes() };
			try {
				dbUtil.execute(sql, params,true);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		@Override
		public void deleteNotice(Notice notice) {
			String sql = "delete from notice where id = ?";
			Object[] params = { notice.getId() };
			try {
				dbUtil.execute(dbUtil.getConnection(),sql, params);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
		@Override
		public Notice selectNoticeById(int id) {
			String sql = "select * from notice where id=?";
			Object[] params = { id };
			Notice notice = null;
			try {
				notice = (Notice) dbUtil.getObject(Notice.class,sql, params);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}		
			return notice;
		}
		@Override
		public Notice selectNoticeByName(String name) {
			String sql = "select * from notice where name=?";
			Object[] params = { name };
			Notice notice = null;
			try {
				notice = (Notice) dbUtil.getObject(Notice.class,sql, params);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}		
			return notice;
		}
}
