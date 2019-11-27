package dev.service;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class AppService {

	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);

	public void executer(String gnap) {
		LOG.debug("Traitement 1 : param = {GNAP}", gnap);
	}
}
