package com.mobile.mynews.bean;

import java.util.List;

public class TopicListBean2 {
	public List<TopicList_News> T1348647853363;

	public static class TopicList_News {
		public List<TopicList_News_Ads> ads;
		public String alias;
		public String cid;
		public String digest;
		public String docid;
		public String ename;
		public int hasAD;
		public boolean hasCover;
		public int hasHead;
		public boolean hasIcon;
		public int hasImg;
		public List<TopicList_News_Imgextra> imgextra;
		public String imgsrc;
		public String lmodify;
		public int order;
		public String photosetID;
		public int priority;
		public String ptime;
		public int replyCount;
		public String skipID;
		public String skipType;
		public String template;
		public String title;
		public String tname;
		public String boardid;
		public String source;
		public String specialID;
		public String subtitle;
		public String url;
		public String url_3w;
		public int votecount;

	}

	public static class TopicList_News_Imgextra {
		public String imgsrc;
	}

	public static class TopicList_News_Ads {
		public String imgsrc;
		public String subtitle;
		public String tag;
		public String title;
		public String url;
	}

}
