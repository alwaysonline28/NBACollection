package com.nba.collection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.nba.collection.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class TestActivity extends Activity {
	private static final String TAG="SpiritualTest";
	private static final String DATABASE_PATH="data/data/com.nba.collection/databases";
	private static final String DATABASE_FILENAME="nbadata.db";
	  
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.main);
	      //  startGotoLogin();
	        waitLoad();
	        
	    }
	    //加载页面
	    //耗时操作
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
