package com.mobile.mynews.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mobile.mynews.R;
import com.mobile.mynews.base.BaseFragment;
import com.mobile.mynews.base.BasePage;
import com.mobile.mynews.home.DiscoverPage;
import com.mobile.mynews.home.ListenPage;
import com.mobile.mynews.home.MinePage;
import com.mobile.mynews.home.NewsPage;
import com.mobile.mynews.home.ReadPage;
import com.mobile.mynews.view.CustomViewPager;
import com.mobile.mynews.view.QfViewPager;
import com.mobile.mynews.view.QfViewPager.OnPageChangeListener;

public class HomeFragment extends BaseFragment {
	private List<BasePage> pages = new ArrayList<BasePage>();
	@ViewInject(R.id.viewpager)
	private CustomViewPager viewPager;
	@ViewInject(R.id.main_radio)
	private RadioGroup main_radio;
	private int checkedId = R.id.rb_news;

	@Override
	public void initData(Bundle savedInstanceState) {
		// 将所有的page添加
		pages.add(new NewsPage(context));
		pages.add(new ReadPage(context));
		pages.add(new ListenPage(context));
		pages.add(new DiscoverPage(context));
		pages.add(new MinePage(context));
		// 创建适配器
		HomeAdapter adapter = new HomeAdapter(context, pages);
		viewPager.setAdapter(adapter);
		//viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				if (0 == position) {
					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				} else {
					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				}
				BasePage page = pages.get(position);
				page.initData();
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub

			}
		});
		// 如何禁止ViewPager滑动来改变下面的tab 。---截断事件。
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_news:
					// 直接加载第一页。设置为false表示不用加载中间的页，直接加载当前页。
					viewPager.setCurrentItem(0, false);
					checkedId = 0;
					break;
				case R.id.rb_read:
					viewPager.setCurrentItem(1, false);
					checkedId = 1;
					break;
				case R.id.rb_listen:
					viewPager.setCurrentItem(2, false);
					checkedId = 2;
					break;
				case R.id.rb_discover:
					viewPager.setCurrentItem(3, false);
					checkedId = 3;
					break;
				case R.id.rb_mine:
					viewPager.setCurrentItem(4, false);
					checkedId = 4;
				default:
					break;
				}

			}
		});

	}

	@Override
	public View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_home2, null);
		/*
		 * viewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
		 * main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
		 */
		ViewUtils.inject(this, view); // 注入view和事件
		return view;
	}

	class HomeAdapter extends PagerAdapter {
		private Context context;
		private List<BasePage> list;

		public HomeAdapter(Context context, List<BasePage> list) {
			this.context = context;
			this.list = list;
		}

		@Override
		public int getCount() {
			return pages.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			((QfViewPager) container).addView(
					pages.get(position).getRootView(), 0);
			return pages.get(position).getRootView();
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((QfViewPager) container).removeView(pages.get(position)
					.getRootView());
		}

	}
}
