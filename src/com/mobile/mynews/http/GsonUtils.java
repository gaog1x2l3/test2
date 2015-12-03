package com.mobile.mynews.http;

import com.google.gson.Gson;

public class GsonUtils {
	public static <T> T json2bean(String json, Class<T> clz) {
		Gson gson = new Gson();
		T t = gson.fromJson(json, clz);
		return t;
	}

}
