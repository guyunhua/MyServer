package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBManager;

//
public class Service {
	///��½
	public Boolean login(String username, String password){
		String logSql = "select * from users where username ='" + username
				+ "' and password = '" + password + "'";
		
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		try{
			ResultSet rs = sql.executeQuery(logSql);
			if(rs.next()){
				sql.closeDB();
				return true;
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		sql.closeDB();
		return false;
	}
	///ע��
	public Boolean register(String username, String password){
		String checkSql = "select * from users where username ='" + username + "'";
		String regSql = "insert into users values('" + username + "','" + password +"')";
		
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		try{
			ResultSet rs = sql.executeQuery(checkSql);
			if(rs.next()){
				sql.closeDB();
				return false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			
			sql.closeDB();
			return false;
		}
		
		int ret = sql.executeUpdate(regSql);
		if(ret != 0){
			sql.closeDB();
			return true;
			
		}
		
		sql.closeDB();
		return false;
	}
}
