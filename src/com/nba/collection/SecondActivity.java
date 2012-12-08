package com.nba.collection;

import com.nba.collection.data.DeteFengZhuang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {
	Intent intent = null;
	TextView textview1 = null;
	TextView textview2 = null;
	ImageView imageview = null;
	DeteFengZhuang dfz= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.vlistintent);
		intent = getIntent();
		dfz = (DeteFengZhuang)intent.getSerializableExtra("name");
		textview1 = (TextView) findViewById(R.id.txtview1);
		textview2 = (TextView) findViewById(R.id.txtview2);
		imageview = (ImageView) findViewById(R.id.imageview);
		//textview1.setText("ceshi");
	}
	@Override
	protected void onStart() {
		super.onStart();
		imageview.setImageResource(dfz.getPhoto());
		textview1.setText(dfz.getFeature().replace("@", "\n"));
		textview2.setText(((dfz.getMaked()).replace("@", "\n")));	
	}
}