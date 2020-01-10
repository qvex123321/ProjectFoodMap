package com.eeit.FoodMap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultDaoImpl implements IResultDao {

	@Override
	public String queryLunch(Connection conn, int prid, int walktime, int[] fstid){
		String qrystmt = "SELECT DISTINCT * FROM vLunch WHERE SID IN (SELECT SID FROM vLunch ";
		try {
			PreparedStatement stmt = createMealQueryStatement(conn, qrystmt, prid, walktime, 0, fstid);

			ResultSet rs = stmt.executeQuery();
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("StoreName", rs.getString("StoreName"));
				jo.put("Distance", rs.getInt("Distance"));
				jo.put("PriceID", rs.getInt("PRID"));
				float lati = rs.getFloat("Latitude");
				float longt = rs.getFloat("Longtitude");
				float[] coordinate = { lati, longt };
				jo.put("Coordinate", coordinate);
				jo.put("Address", rs.getString("Address"));
				jsonArray.put(jo);
			}
			rs.close();
			stmt.close();
			String jsonString = jsonArray.toString();
			if (jsonString.equals("[]"))
				return "";
			else {
				return jsonString;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return qrystmt;
	}

	@Override
	public String queryDinner(Connection conn, int prid, int walktime, int[] fstid){
		String qrystmt = "SELECT DISTINCT * FROM vDinner WHERE SID IN (SELECT SID FROM vDinner ";
		try {
			PreparedStatement stmt = createMealQueryStatement(conn, qrystmt, prid, walktime, 0, fstid);
			ResultSet rs = stmt.executeQuery();
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("StoreName", rs.getString("StoreName"));
				jo.put("Distance", rs.getInt("Distance"));
				jo.put("PriceID", rs.getInt("PRID"));
				float lati = rs.getFloat("Latitude");
				float longt = rs.getFloat("Longtitude");
				float[] coordinate = { lati, longt };
				jo.put("Coordinate", coordinate);
				jo.put("Address", rs.getString("Address"));
				jsonArray.put(jo);
			}
			rs.close();
			stmt.close();
			String jsonString = jsonArray.toString();
			if (jsonString.equals("[]"))
				return "";
			else {
				return jsonString;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return qrystmt;
	}

	private PreparedStatement createMealQueryStatement(Connection conn, String header_str, int prid, int walktime,
			int foodType, int[] fstid) {
		PreparedStatement stmt = null;
		int cons_num = 0;
		if (prid != 0 || walktime != 0) {
			header_str += " where ";
			if (prid != 0) {
				header_str += "PRID = ? ";
				cons_num += 1;
			}
			if (walktime != 0 && cons_num == 1) {
				header_str += "AND TimeCost<= ? ";
				cons_num += 1;
			} else if (walktime != 0) {
				header_str += "TimeCost<= ? ";
				cons_num += 1;
			}
		}
		if(foodType == 0) {
			header_str += ") AND SID IN (SELECT DISTINCT A.SID FROM ( " + "(SELECT * FROM StoreTag WHERE FSTID IN ";
			String tag = "(";
			for (int i = 0; i < fstid.length; i += 1) {
				tag += Integer.toString(fstid[i]) + ",";
			}
			tag = tag.substring(0, tag.length() - 1) + ")";
			header_str += tag + " ) AS A " + " LEFT OUTER JOIN " + " (SELECT * FROM StoreTag WHERE FSTID NOT IN ";
			header_str += tag + " ) AS B " + "ON A.SID = B.SID) " + "WHERE B.SID IS NULL " + " )";

		} 
		try {	
			stmt = conn.prepareStatement(header_str);
			if (cons_num == 1) {
				if (prid != 0) {
					stmt.setInt(1, prid);
				} else if (walktime != 0) {
					stmt.setInt(1, walktime);
				}
			} else if (cons_num == 2) {
				stmt.setInt(1, prid);
				stmt.setInt(2, walktime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	@Override
	public String queryDrink(Connection conn, int prid, int walktime){
		String qrystmt = "SELECT * FROM vDrink ";
		try {
			PreparedStatement stmt = createMealQueryStatement(conn, qrystmt, prid, walktime, 1, null);
			ResultSet rs = stmt.executeQuery();
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("StoreName", rs.getString("StoreName"));
				jo.put("Distance", rs.getInt("Distance"));
				jo.put("PriceID", rs.getInt("PRID"));
				float lati = rs.getFloat("Latitude");
				float longt = rs.getFloat("Longtitude");
				float[] coordinate = { lati, longt };
				jo.put("Coordinate", coordinate);
				jo.put("Address", rs.getString("Address"));
				jsonArray.put(jo);
			}
			rs.close();
			stmt.close();
			String jsonString = jsonArray.toString();
			if (jsonString.equals("[]"))
				return "";
			else {
				return jsonString;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return qrystmt;
	}

	@Override
	public String queryDessert(Connection conn, int prid, int walktime){
		String qrystmt = "SELECT * FROM vDessert ";
		try {
			PreparedStatement stmt = createMealQueryStatement(conn, qrystmt, prid, walktime, 2, null);
			ResultSet rs = stmt.executeQuery();
			JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("StoreName", rs.getString("StoreName"));
				jo.put("Distance", rs.getInt("Distance"));
				jo.put("PriceID", rs.getInt("PRID"));
				float lati = rs.getFloat("Latitude");
				float longt = rs.getFloat("Longtitude");
				float[] coordinate = { lati, longt };
				jo.put("Coordinate", coordinate);
				jo.put("Address", rs.getString("Address"));
				jsonArray.put(jo);
			}
			rs.close();
			stmt.close();
			String jsonString = jsonArray.toString();
			if (jsonString.equals("[]"))
				return "";
			else {
				return jsonString;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return qrystmt;
	}

	@Override
	public int queryTotalTagsNumber(Connection conn) {
		String qrystr = "SELECT count(FSTID) AS 'TotalTags' FROM FoodStyleTag ";
		int total = 0;
		try {
			PreparedStatement state = conn.prepareStatement(qrystr);
			ResultSet rs = state.executeQuery();
			total = rs.getInt("TotalTags");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}
