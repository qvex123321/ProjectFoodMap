package com.eeit.FoodMap.dao;

import java.sql.Connection;

public interface IResultDao {
	public String queryLunch(Connection conn, int prid, int walktime, int[] fstid);
	public String queryDinner(Connection conn, int prid, int walktime, int[] fstid);
//	public String queryDrink(Connection conn, int walktime) throws SQLException;
	public String queryDessert(Connection conn, int prid, int walktime);
	public int queryTotalTagsNumber(Connection conn);
	String queryDrink(Connection conn, int prid, int walktime);
}
