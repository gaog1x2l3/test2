package com.mobile.mynews;

import android.os.Bundle;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	private MenuFragment mMenuFragment;
	private HomeFragment2 mHomeFragment;

	/**
	 * 1:得到滑动菜单 2：设置滑动菜单是在左边出来还是右边出来 3：设置滑动菜单出来之后，内容页，显示的剩余宽度
	 * 4：设置滑动菜单的阴影，阴影需要在开始的时候特别暗，慢慢的变淡 5：设置阴影的宽度 6：设置滑动菜单的范围。
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 去掉窗体的标题栏。
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置内容页以外的view
		setBehindContentView(R.layout.menu_frame);
		// 设置内容页
		setContentView(R.layout.content_frame);
		// 得到侧滑菜单
		SlidingMenu sm = getSlidingMenu();
		// 设置阴影的宽度
		sm.setShadowWidthRes(R.dimen.shadow_width);
		// 设置滑动菜单的阴影，设置阴影，阴影需要在开始的时候，特别暗，慢慢的变淡
		sm.setShadowDrawable(R.drawable.shadow);
		// 设置滑动菜单出来之后，内容页，显示的剩余宽度
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 设置滑动菜单的比例。
		sm.setFadeDegree(0.35f);
		// 设置滑动菜单不能够滑动。
		// 第一个参数 SlidingMenu.TOUCHMODE_FULLSCREEN 可以全屏滑动
		// 第二个参数 SlidingMenu.TOUCHMODE_MARGIN 只能在边沿滑动
		// 第三个参数 SlidingMenu.TOUCHMODE_NONE 不能滑动
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		if (savedInstanceState == null) {
			// 创建2个Fragment,并且给这些Fragment设置tag，并且提交。
			mMenuFragment = new MenuFragment();
			mHomeFragment = new HomeFragment2();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.menu_frame, mMenuFragment, "Menu").commit();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, mHomeFragment, "Home")
					.commit();

		}
		// 设置滑动菜单可以左侧滑动。
		sm.setMode(SlidingMenu.LEFT);
	}

	// 返回滑动菜单对象。
	public MenuFragment getMenuFragment() {
		mMenuFragment = (MenuFragment) getSupportFragmentManager()
				.findFragmentByTag("Menu");
		return mMenuFragment;

	}

}
