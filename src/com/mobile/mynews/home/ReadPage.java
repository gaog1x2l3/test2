package com.mobile.mynews.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mobile.mynews.base.BasePage;
/**
 * 阅读页
 * @author gao
 *
 */
public class ReadPage extends BasePage {

	public ReadPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		TextView textview = new TextView(context);
		textview.setText("我是阅读页面");
		return textview;// TODO Auto-generated method stub
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
