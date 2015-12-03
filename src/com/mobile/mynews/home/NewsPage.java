package com.mobile.mynews.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;
import com.mobile.mynews.base.BasePage;
import com.mobile.mynews.bean.TopicListBean2;
import com.mobile.mynews.http.GsonUtils;
import com.mobile.mynews.utils.Constants;

/**
 * 新闻
 * 
 * @author gao
 * 
 */
public class NewsPage extends BasePage {

	public NewsPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		TextView textview = new TextView(context);
		textview.setText("我是新闻页");
		return textview;
	}

	@Override
	public void initData() {
		// 从网络中拿出数据。
		test();
	}

	public void test() {
		HttpUtils http = new HttpUtils();
		http.send(
				HttpRequest.HttpMethod.GET,
				"http://c.m.163.com/nc/article/headline/T1348647853363/0-20.html",
				new RequestCallBack<String>() {
					@Override
					public void onLoading(long total, long current,
							boolean isUploading) {
					}

					@Override
					public void onSuccess(ResponseInfo<String> responseInfo) {
						System.out.println("======");
						LogUtils.d(responseInfo.result);
						ProgressData(responseInfo.result);
					}

					@Override
					public void onStart() {
					}

					@Override
					public void onFailure(HttpException error, String msg) {
					}
				});
	}

	protected void ProgressData(String result) {
		TopicListBean2 topbeans = GsonUtils.json2bean(result,
				TopicListBean2.class);
		for (int i = 0; i < topbeans.T1348647853363.size(); i++) {
			System.out.println(topbeans.T1348647853363.get(i).title);
		}
	}

}
