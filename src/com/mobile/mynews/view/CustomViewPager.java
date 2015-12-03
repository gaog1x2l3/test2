package com.mobile.mynews.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends QfViewPager {
	private boolean isTouchMode = false;

	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (isTouchMode)
			return super.onInterceptTouchEvent(ev);
		else
			return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (isTouchMode)
			return super.onTouchEvent(ev);
		else
			return false;
	}

}
