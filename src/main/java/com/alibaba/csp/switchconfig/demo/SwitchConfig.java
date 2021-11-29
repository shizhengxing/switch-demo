package com.alibaba.csp.switchconfig.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.csp.ahas.switchcenter.anotation.Switch;
import com.taobao.csp.switchcenter.annotation.AppSwitch;

@Switch
public class SwitchConfig {

	@AppSwitch(des = "控制台访问白名单开关")
	public static Set<String> USER_WHITE_LIST = new HashSet<String>();

	@AppSwitch(des = "公告栏相关文章配置")
	public static List<Article> ARTICLES = new ArrayList<Article>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Article("文章1", "链接1"));
			add(new Article("文章2", "链接2"));
			add(new Article("文章4", "链接3"));
		}
	};
}
