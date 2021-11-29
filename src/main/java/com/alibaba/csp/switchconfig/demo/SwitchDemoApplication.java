package com.alibaba.csp.switchconfig.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * switch demo 应用, 启动时需要配置以下几个-D参数: -Dahas.namespace=default
 * -Dproject.name=AppName -Dahas.license='如果非region内，请到控制台公网查看license'
 * 
 * <code>com.alibaba.csp.switchconfig.demo.SwitchConfig<code> 类中埋了两个开关 1.
 * USER_WHITE_LIST 模仿用户白名单开关，在此开关的用户，才允许通过。可通过访问
 * http://localhost:8080/access?userId=${userId} 查看访问结果。 2.
 * ARTICLES，模仿后端去前端请求首页文章列表数据开关，返回基础配置。可通过访问 http://localhost:8080/articles
 * 查看访问结果。
 */
@SpringBootApplication
public class SwitchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwitchDemoApplication.class, args);
	}
}
