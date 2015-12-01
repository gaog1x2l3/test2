package com.mobile.mynews.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mobile.mynews.base.BasePage;

public class NewsPage extends BasePage {
	private Context context;

	public NewsPage(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		TextView textview = new TextView(context);
		textview.setText("我是新闻页");
		return textview;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
