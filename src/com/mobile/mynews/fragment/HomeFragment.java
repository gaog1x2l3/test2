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

import com.mobile.mynews.R;
import com.mobile.mynews.base.BaseFragment;
import com.mobile.mynews.base.BasePage;
import com.mobile.mynews.home.DiscoverPage;
import com.mobile.mynews.home.ListenPage;
import com.mobile.mynews.home.MinePage;
import com.mobile.mynews.home.NewsPage;
import com.mobile.mynews.home.ReadPage;
import com.mobile.mynews.view.QfViewPager;

public class HomeFragment extends BaseFragment {
	private List<BasePage> pages = new ArrayList<BasePage>();
	private QfViewPager viewPager;
	private RadioGroup main_radio;

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
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_news:
					viewPager.setCurrentItem(0, false);
					break;
				case R.id.rb_read:
					viewPager.setCurrentItem(1, false);
					break;
				case R.id.rb_listen:
					viewPager.setCurrentItem(2, false);
					break;
				case R.id.rb_discover:
					viewPager.setCurrentItem(3, false);
					break;
				case R.id.rb_mine:
					viewPager.setCurrentItem(4, false);

				default:
					break;
				}

			}
		});
	}

	@Override
	public View initView(LayoutInflater inflater) {
		View view = inflater.inflate(R.layout.frag_home2, null);
		viewPager = (QfViewPager) view.findViewById(R.id.viewpager);
		main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
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
