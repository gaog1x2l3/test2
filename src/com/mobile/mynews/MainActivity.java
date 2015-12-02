package com.mobile.mynews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mobile.mynews.fragment.Fragment1;
import com.mobile.mynews.fragment.HomeFragment;
import com.mobile.mynews.fragment.MenuFragment;
import com.mobile.mynews.fragment.MenuFragment2;

public class MainActivity extends SlidingFragmentActivity {
	private SlidingMenu sm;
	private MenuFragment2 menuFragment;
	/**
	 * 1 得到滑动菜单 
	 * 2 设置滑动菜单是在左边出来还是右边出来
	 *  3 设置滑动菜单出来之后，内容页，显示的剩余宽度 
	 *  4 设置滑动菜单的阴影设置阴影，阴影需要在开始的时候，特别暗，慢慢的变淡 
	 *  5 设置阴影的宽度 
	 *  6 设置滑动菜单的范围
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu);
		setContentView(R.layout.content);

		Fragment fragment1 = new Fragment1();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment1).commit();

		sm = getSlidingMenu();
		// 2 设置滑动菜单是在左边出来还是右边出来
		// 参数可以设置左边LEFT，也可以设置右边RIGHT ，还能设置左右LEFT_RIGHT
		sm.setMode(SlidingMenu.LEFT);
		// 3 设置滑动菜单出来之后，内容页，显示的剩余宽度
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		// 4 设置滑动菜单的阴影 设置阴影，阴影需要在开始的时候，特别暗，慢慢的变淡
		sm.setShadowDrawable(R.drawable.shadow);
		// 5 设置阴影的宽度
		sm.setShadowWidth(R.dimen.shadow_width);
		// 6 设置滑动菜单的范围
		// 第一个参数 SlidingMenu.TOUCHMODE_FULLSCREEN 可以全屏滑动
		// 第二个参数 SlidingMenu.TOUCHMODE_MARGIN 只能在边沿滑动
		// 第三个参数 SlidingMenu.TOUCHMODE_NONE 不能滑动
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		// 创建fragment
		MenuFragment menuFragment = new MenuFragment();
		// 获取fragment的管理者
		getSupportFragmentManager()
		// 开启事物
				.beginTransaction()
				// 替换
				.replace(R.id.menu_frame, menuFragment, "Menu")
				// 提交
				.commit();

		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, homeFragment, "Home").commit();
		/**
		 * 下面的代码是右边侧滑，需要将setMode(Slidingmenu.LEFT_RIGHT);设置左右都可以滑动
		 */
		// sm.setSecondaryMenu(R.layout.right_menu);
		// sm.setSecondaryShadowDrawable(R.drawable.shadowright);
		// RightMenuFragment rightMenuFragment = new RightMenuFragment();
		// getSupportFragmentManager().beginTransaction().replace(R.id.right_menu_frame,
		// rightMenuFragment).commit();
	}

	/**
	 *  回调:暴露出来的方法。供Fragment调用。
	 */
	public void switchFragment(Fragment f) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, f).commit();
		// 自动切换,让切换更自然。
		sm.toggle();
	}

	
	/**
	 * 获取菜单
	 */
	public MenuFragment2 getMenuFragment2() {
		menuFragment = (MenuFragment2) getSupportFragmentManager()
				.findFragmentByTag("Menu");
		return menuFragment;
	}

}
