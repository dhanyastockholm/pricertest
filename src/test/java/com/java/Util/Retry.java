package com.java.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Retry implements IRetryAnalyzer {

    private static final int millisBetweenTest = 1000;
    private static final int retryDurationInSeconds = 90;

    private static Logger log = LoggerFactory.getLogger(Retry.class);
    private Instant end = Instant.now().plus(retryDurationInSeconds, ChronoUnit.SECONDS);

    @Override
    public boolean retry(ITestResult result) {
        if (Instant.now().isAfter(end)) {
            return false;
        }
        try {
            Thread.sleep(millisBetweenTest);
        } catch (InterruptedException e) {
            log.error("Sleep failed", e);
        }
        return true;
    }
}