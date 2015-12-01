package com.mobile.mynews.fragment;

import com.mobile.mynews.R;
import com.mobile.mynews.base.BaseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class HomeFragment extends BaseFragment {

	@Override
	public void initData(Bundle savedInstanceState) {
		

	}

	@Override
	public View initView(LayoutInflater inflater) {
		View view =inflater.inflate(R.layout.frag_home2, null);
		return view;
	}

}
