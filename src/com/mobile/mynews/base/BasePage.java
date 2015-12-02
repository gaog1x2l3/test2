package com.mobile.mynews.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
/**
 * 所有页面的抽象封装类。
 * @author gao
 *
 */
public abstract class BasePage {
	private View view;
	public Context context;

	/*
	 * 当对象创建后就画出界面。
	 * 1:画界面 
	 * 2:初始化数据
	 */
	public BasePage(Context context) {
		this.context = context;
		System.out.println(context);
		//通过得到系统服务得到LayoutInflater独享。
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = initView(inflater);
	}
	/**
	 * 返回当前的View
	 * @return
	 */
	public View getRootView() {
		return view;
	}
	/**
	 * 由子类来构建界面。
	 * @param inflater
	 * @return  View
	 */
	public abstract View initView(LayoutInflater inflater);
	/**
	 * 由子类来初始化界面的数据。
	 */
	public abstract void initData();

}
