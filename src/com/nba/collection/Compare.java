package com.nba.collection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.nba.collection.data.Data;
import com.nba.collection.data.DatabaseHelper;
import com.nba.collection.data.DeteFengZhuang;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Compare extends ListActivity{
	DatabaseHelper dbh = null;
	SQLiteDatabase db = null;
	private Cursor c=null;
	private static final String TAG="SpiritualTest";
	private static final String DATABASE_PATH="data/data/com.nba.collection/databases";
	private static final String DATABASE_FILENAME="nbadata.db";
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//SimpleAdapter adapter = new SimpleAdapter(FistActivity.this, getData(),R.layout.vlist, new String[]{"title","info","img"}, new int[]{R.id.title,R.id.info,R.id.img});
		//setListAdapter(adapter);
		dbh=new DatabaseHelper(this);
		waitLoad();
		
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		db=dbh.getReadableDatabase();
		//query中必须查询_id,排序都是要写，最新的数据置顶
		c=db.query(Data.TABLE_NAME,null,null,null,null
				,null, Data._ID+" DESC");
		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,
				R.layout.compare, 
				c,
				new String[]{Data.PHOTOGRAPH,Data.NAMES,Data.JANJIE},
				new int[]{R.id.img,R.id.title,R.id.info});
		setListAdapter(adapter);	
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Log.d("----------", String.valueOf(id));
		//Cursor移动
		c.moveToPosition(position);
		int photo=c.getInt(c.getColumnIndex(Data.PHOTOGRAPH));
		String feature=c.getString(c.getColumnIndex(Data.Feature));
		String maked=c.getString(c.getColumnIndex(Data.MAKED));
		DeteFengZhuang np = new DeteFengZhuang(photo,feature,maked);
		//进行跳转
		Toast.makeText(Compare.this, String.valueOf(id),Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(Compare.this,SecondActivity.class);
		intent.putExtra("name",np);
		startActivity(intent);
	}
	  public void waitLoad(){
		   new Thread(new Runnable() {


		public void run() {
		String databasefilename=DATABASE_PATH + "/" + DATABASE_FILENAME;
		//是否存在
		if(new File(databasefilename).exists()){
		try {
		Thread.sleep(3000);

		} catch (InterruptedException e) {

		e.printStackTrace();
		} 

		}else{
		openDatabase();
		try {
		Thread.sleep(3000);

		} catch (InterruptedException e) {

		e.printStackTrace();
		} 
		}
		startGotoLogin();

		}
		}).start();
		   }
		   /**
		 * 跳转到主界面
		 */
		public void startGotoLogin()
		{

		}
		protected void openDatabase() {
		//获得Spiritualteaser.db的绝对路径
		try {
		String databaseFilename =DATABASE_PATH + "/" + DATABASE_FILENAME;
		File dir = new File(DATABASE_PATH);
		if (!dir.exists())
		{
		dir.mkdir();
		}
		// 如果在/sdcard/Spiritualteaserdictionary目录中不存在
		// Spiritualteaser.db文件，则从res\raw目录中复制这个文件到
		// SD卡的目录（/sdcard/Spiritualteaser）
		if(!(new File(databaseFilename)).exists()){
		// 获得封装dictionary.db文件的InputStream对象

		InputStream is= getResources().openRawResource(R.raw.nbadata);
		FileOutputStream fos = new FileOutputStream(databaseFilename);
		byte[] buffer = new byte[8192];
		int count = 0;

		// 开始复制dictionary.db文件
		while ((count = is.read(buffer)) > 0) {
		fos.write(buffer, 0, count);
		}
		System.out.println("ok");
		fos.close();
		is.close();
		} 
		else
		{
		}
		}catch (Exception e) {
		e.printStackTrace();
		}
		}
			
}
