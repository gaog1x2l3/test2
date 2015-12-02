package com.mobile.mynews.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mobile.mynews.base.BasePage;
/**
 * 我 页面
 * @author gao
 *
 */
public class MinePage extends BasePage {

	public MinePage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		TextView textview = new TextView(context);
		textview.setText("我页面");
		return textview;// TODO Auto-generated method stub
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
