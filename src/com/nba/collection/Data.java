package com.nba.collection;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Data extends Activity {
	private ListView listview;
	private int cur_pos = 0;// 当前显示的一行

	private String[] items_text = {  "迈克尔·乔丹", "科比-布莱恩特 ",  "特雷西·麦克格雷迪", "德怀恩·韦德","阿伦·埃泽尔·艾弗森","凯文·加内特" };
	private int[] items_img = { R.drawable.nbaplayer, R.drawable.nbaplayer,
			R.drawable.nbaplayer, R.drawable.nbaplayer,R.drawable.nbaplayer,
			R.drawable.nbaplayer };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data);
		listview = (ListView) findViewById(R.id.listview);

		final MyAdapter adapter = new MyAdapter(this);
		listview.setAdapter(adapter);

		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);// 一定要设置这个属性，否则ListView不会刷新
		listview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				cur_pos = position;// 更新当前行
			}
		});
	}

	private class MyAdapter extends BaseAdapter {
		private LayoutInflater inflater;

		public MyAdapter(Context context) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public int getCount() {
			return items_text.length;
		}

		public Object getItem(int position) {
			return items_text[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Log.e("TEST", "refresh once");
			convertView = inflater.inflate(R.layout.listplayer, null, false);
			ImageView img = (ImageView) convertView
					.findViewById(R.id.list_child_img);// 用于显示图片
			TextView tv = (TextView) convertView
					.findViewById(R.id.list_child_text);// 显示文字
			tv.setText(items_text[position]);
			img.setImageResource(items_img[position]);
			if (position == cur_pos) {// 如果当前的行就是ListView中选中的一行，就更改显示样式
				convertView.setBackgroundColor(Color.LTGRAY);//更改整行的背景色
				tv.setTextColor(Color.RED);// 更改字体颜色
			}
			return convertView;
		}
	}
}
