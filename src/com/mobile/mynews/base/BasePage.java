package com.mobile.mynews.base;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mobile.mynews.MainActivity;
import com.mobile.mynews.R;
import com.mobile.mynews.utils.CommonUtil;
import com.mobile.mynews.utils.CustomToast;

/**
 * 所有页面的抽象类
 * 
 * @author gao
 * 
 */
public abstract class BasePage implements OnClickListener {
	protected Context ct;
	protected View contentView;
	protected Button leftBtn;
	protected ImageButton rightBtn;
	protected ImageButton leftImgBtn;
	protected ImageButton rightImgBtn;
	protected TextView titleTv;
	protected SlidingMenu sm;
	protected LinearLayout loadfailView;// 加载失败的布局。
	public boolean isLoadSuccess = false;// 是否成功加载。
	@ViewInject(R.id.loading_view)
	protected View loadingView; // 加载时的布局。

	// 在构造方法中对各个控件执行赋值
	public BasePage(Context context) {
		ct = context;
		contentView = initView((LayoutInflater) ct
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
		// 加载时的布局
		loadingView = contentView.findViewById(R.id.loading_view);
		// 记载失败的布局。
		loadfailView = (LinearLayout) contentView
				.findViewById(R.id.ll_load_fail);
		// 获得侧滑菜单
		if (ct instanceof MainActivity) {
			sm = ((MainActivity) ct).getSlidingMenu();
		}
	}

	// 初始化最上边的标题tab.
	protected void initTitleBar(View view) {
		leftBtn = (Button) view.findViewById(R.id.btn_left);
		rightBtn = (ImageButton) view.findViewById(R.id.btn_right);
		leftImgBtn = (ImageButton) view.findViewById(R.id.imgbtn_left);
		rightImgBtn = (ImageButton) view.findViewById(R.id.imgbtn_right);
		leftImgBtn.setImageResource(R.drawable.img_menu);
		titleTv = (TextView) view.findViewById(R.id.txt_title);
		leftBtn.setVisibility(View.GONE);
		rightBtn.setVisibility(View.GONE);
		if (leftImgBtn != null)
			leftImgBtn.setOnClickListener(this);

	}

	public View getContentView() {
		return contentView;
	}

	public void dismissLoadingView() {
		if (loadingView != null)
			loadingView.setVisibility(View.INVISIBLE);
	}

	protected abstract View initView(LayoutInflater inflater);

	public abstract void initData();

	protected abstract void processClick(View v);

	public void onResume() {

	}

	public void showToast(String msg) {
		showToast(msg, 0);
	}

	public void showToast(String msg, int time) {
	}

	/**
	 * 加载指定网址的数据
	 * 
	 * @param method
	 *            请求方式
	 * @param url
	 *            网址
	 * @param params
	 *            将某些数据传递到服务器端。
	 * @param callback
	 *            回调
	 */
	protected void loadData(HttpRequest.HttpMethod method, String url,
			RequestParams params, RequestCallBack<String> callback) {
		HttpUtils http = new HttpUtils();
		http.configCurrentHttpCacheExpiry(1000 * 1);
		LogUtils.allowD = true;
		if (params != null) {
			if (params.getQueryStringParams() != null)
				LogUtils.d(url + params.getQueryStringParams().toString());
		} else {
			params = new RequestParams();
		}
		// 设备ID
		// params.addHeader("x-deviceid", app.deviceId);
		// 渠道，统计用
		// params.addHeader("x-channel", app.channel);
		if (0 == CommonUtil.isNetworkAvailable(ct)) {
			showToast("无网络，请检查网络连接！");
		} else {
			// 发送请求。并将数据交由callback来进行处理。
			http.send(method, url, params, callback);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgbtn_left:
			// 单击左侧的按钮时。
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {

				@Override
				public void run() {
					sm.toggle();

				}
			}, 100);

			break;

		default:
			break;
		}

	}
}
