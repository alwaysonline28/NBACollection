package com.nba.collection.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	//构建需要数据库的版本，数据库的名字
	public DatabaseHelper(Context context) {
		super(context,Data.DB_NAME, null,Data.DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	//创建表,字符串拼接时的空格
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE IF NOT EXISTS "+ Data.TABLE_NAME +
					    " ("+Data._ID +" INTEGER PRIMARY KEY, "+
					    Data.PHOTOGRAPH +" INT, "+ 
					    Data.NAMES +" TEXT, "+
					    Data.Feature +" TEXT, "+
					    Data.MAKED +" TEXT, "+
					    Data.JANJIE +" TEXT)" );
		}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
