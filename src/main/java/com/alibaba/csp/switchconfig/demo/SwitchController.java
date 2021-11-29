package com.alibaba.csp.switchconfig.demo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
//import org.apache.log4j.Level;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 楚东
 * @date 2020/03/27
 */
@RestController
public class SwitchController {

	// log4j
	// private static final Logger logger =
	// LogManager.getLogger(SwitchController.class);

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(SwitchController.class);

	// slf4j + logback
	// private static final org.slf4j.Logger logger =
	// LoggerFactory.getLogger(SwitchController.class);

	@PostConstruct
	private void init() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				String loggerClzName = logger.getClass().getName();
				while (true) {
					try {

						logger.debug("" + loggerClzName + "  debug msg");
						logger.info("" + loggerClzName + "  info msg");
						logger.warn("" + loggerClzName + "  warn msg");
						logger.error("" + loggerClzName + "  error msg");

						// logger.debug("{} debug msg", loggerClzName);
						// logger.info("{} info msg", loggerClzName);
						// logger.warn("{} warn msg", loggerClzName);
						// logger.error("{} error msg", loggerClzName);
					} finally {
						try {
							
//							Configurator.setRootLevel(level);
							Thread.sleep(1000 * 5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}).start();
	}

	@GetMapping("/access")
	public String access(@RequestParam String userId) {
		if (SwitchConfig.USER_WHITE_LIST.contains(userId)) {
			return "current user in white list";
		}

		return "user " + userId + " access denied";
	}

	@GetMapping("/articles")
	public List<Article> getArticles() {
		return SwitchConfig.ARTICLES;
	}
}
