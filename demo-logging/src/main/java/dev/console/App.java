package dev.console;

import org.slf4j.LoggerFactory;

import dev.service.AppService;

import org.slf4j.Logger;

public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Bonjour Slf4J !");
		LOG.info("Implementation Logback");

		AppService gnap = new AppService();
		gnap.executer("GNAP !");
	}

}
