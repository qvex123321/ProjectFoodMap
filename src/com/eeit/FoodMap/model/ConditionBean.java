package com.eeit.FoodMap.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConditionBean {
	private int number;
	private int prid;
	private int distance;
	private int type;
	private int[] tags;
	public ConditionBean() {}
	
	public ConditionBean(String jsonStr) {
		System.out.println(jsonStr);
		try {
			JSONObject jo = new JSONObject(jsonStr);
			setNumber(jo.getInt("number"));
			setPrid(jo.getInt("priceID"));
			setDistance(jo.getInt("walkTime"));
			setType(jo.getInt("foodType"));
			JSONArray ja = (JSONArray) jo.get("foodStyle");
			int[] tags = new int[ja.length()];
			for(int i = 0; i<tags.length;i+=1) {
				tags[i] = ja.getInt(i);
			}
			setTags(tags);
		} catch (JSONException e) {
			setTags(null);
			e.printStackTrace();
		}
		
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrid() {
		return prid;
	}

	public void setPrid(int prid) {
		this.prid = prid;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int[] getTags() {
		return tags;
	}

	public void setTags(int[] tags) {
		this.tags = tags;
	}
	
}
