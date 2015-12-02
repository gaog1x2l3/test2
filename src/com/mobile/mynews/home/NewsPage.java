package com.mobile.mynews.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mobile.mynews.base.BasePage;

/**
 * 新闻
 * 
 * @author gao
 * 
 */
public class NewsPage extends BasePage {

	public NewsPage(Context context) {
		super(context);
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
