package com.mobile.mynews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 所有Fragment的抽象封装类。
 * 
 * @author gao
 * 
 */
public abstract class BaseFragment extends Fragment {
	public View view;
	public Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		context = getActivity();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = initView(inflater);
		return view;
	}

	/**
	 * 设置界面数据的抽象方法
	 * 
	 * @param savedInstanceState
	 */
	public abstract void initData(Bundle savedInstanceState);

	/**
	 * 绘制界面的抽象方法。
	 * 
	 * @param inflater
	 * @return
	 */
	public abstract View initView(LayoutInflater inflater);
}
