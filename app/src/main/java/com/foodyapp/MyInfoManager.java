package com.foodyapp;

import android.content.Context;

import com.foodyapp.model.usersInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyInfoManager {

	private static MyInfoManager instance = null;
	private Context context = null;
	private DataBase db = null;
	int newId=0;
	int updateId=0;

	public static MyInfoManager getInstance() {
			if (instance == null) {
				instance = new MyInfoManager();
			}
			return instance;
		}

		public static void releaseInstance() {
			if (instance != null) {
				instance.clean();
				instance = null;
			}
		}
		
		private void clean() {

		}


		public Context getContext() {
			return context;
			
		}

	public void openDataBase(Context context) {
		this.context = context;
		if (context != null) {
			db = new DataBase(context);
			db.open();
		}
	}
	public void closeDataBase() {
		if(db!=null){
			db.close();
		}
	}

	public void createHouseHold(usersInfo user) {
		if (db != null) {
			db.addHouseHold(user);
		}
	}

	public List<usersInfo> getAllHouseHolds() {
		List<usersInfo> result = new ArrayList<usersInfo>();
		if (db != null) {
			result = db.getAllHouseHolds();
		}
		return result;
	}


	public void deleteHousehold(usersInfo household) {
		if (db != null) {
			db.reomoveHouseHold(household);
		}
	}


		public void products(){
			if(db != null){
				db.Products();
			}
		}


	public void makeOrderTenuva(HashMap<String,Integer> dairy){
		if(dairy != null){
			if(db != null)
				makeOrderTenuva(dairy);
		}
	}

	public boolean checkOrderTenuva(){
		if(db != null){
			return db.checkOrderTenuva();
		}
		return false;
	}



}
