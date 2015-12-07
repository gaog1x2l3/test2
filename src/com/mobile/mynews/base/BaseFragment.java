package com.mobile.mynews.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.mobile.mynews.MainActivity;

/**
 * 主页的抽象Fragment.
 * 
 * @author gao
 * 
 */
public abstract class BaseFragment extends Fragment implements OnClickListener {
	protected Context ct; // 上下文
	protected SlidingMenu sm;// 侧滑菜单
	public View rootView; // 得到Fragment布局View

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);
		// 得到所在的activity得到侧滑菜单。
		sm = ((MainActivity) getActivity()).getSlidingMenu();
		// 初始化View中的数据。
		initData(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// 得到上下文
		ct = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 调用initView方法得到布局，由于子类的布局view不是很清楚，所以由子类重写initView方法获得。
		rootView = initView(inflater);
		return rootView;
	}

	// 返回当前fragment的View.
	public View getRootView() {
		return rootView;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	// 由子类初始化View.
	protected abstract View initView(LayoutInflater inflater);

	// 由子类初始化View的数据。
	protected abstract void initData(Bundle savedInstanceState);

	protected abstract void processClick(View v);
}
