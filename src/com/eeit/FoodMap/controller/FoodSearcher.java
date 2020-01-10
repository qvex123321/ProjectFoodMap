package com.eeit.FoodMap.controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import com.eeit.FoodMap.dao.*;
import com.eeit.FoodMap.model.ConditionBean;

public class FoodSearcher {
	ConditionBean cb = null;
	
	public String queryStart(Connection conn, String condition) {
		cb = new ConditionBean(condition);
		IResultDao rdi = ResultDaoFactory.createResultDao();
//		ResultDaoImpl rdi = new ResultDaoImpl();
		int type = cb.getType();
		String query_result = null;
		if(type==0) {
			if(cb.getTags().length == 0)
				return "";
			if(isDinner()) {
				query_result = rdi.queryDinner(conn, cb.getPrid(), cb.getDistance(), cb.getTags());
			}
			else {
				query_result = rdi.queryLunch(conn, cb.getPrid(), cb.getDistance(), cb.getTags());
			}
		}
		else if(type==1) {
			query_result = rdi.queryDrink(conn, cb.getPrid(), cb.getDistance());
		}
		else if(type==2) {
			query_result = rdi.queryDessert(conn, cb.getPrid(), cb.getDistance());
		}
//		String output = convertResult(query_result);
//		return output;
//		System.out.println("query_result: "+query_result);
		return query_result;
	}
	
	private boolean isDinner() {
		Integer nowHour = LocalDateTime.now().getHour();
		if(nowHour >= 10 && nowHour <= 14) {
			return false;
		}
		else if (nowHour >= 16) {
			return true;
		}
		return false;
	}
	
	private String convertResult(String result) {
		return null;
	}
	
	public int getNumber() {
		return cb.getNumber();
	}
}
