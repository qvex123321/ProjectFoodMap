package com.eeit.FoodMap.dao;

public class ResultDaoFactory {
	public static IResultDao createResultDao() {
		IResultDao eDao = new ResultDaoImpl();
		return eDao;
	}
}
