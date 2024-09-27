package org.agilo.configuration.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log<T> {
    private final Logger logger;

    public Log(Class<T> logClass) {
        logger = LoggerFactory.getLogger(logClass);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * Logs details of an incoming API request.
     *
     * @param method   HTTP method (GET, POST, etc.)
     * @param endpoint API endpoint being accessed
     * @param params   Request parameters or payload
     */
    public void logApiRequest(String method, String endpoint, String params) {
        logger.info("API Request - Method: {}, Endpoint: {}, Params: {}", method, endpoint, params);
    }

    /**
     * Logs details of an outgoing API response.
     *
     * @param method      HTTP method (GET, POST, etc.)
     * @param endpoint    API endpoint that was accessed
     * @param statusCode HTTP status code of the response
     * @param duration    Time taken to process the request (in milliseconds)
     */
    public void logApiResponse(String method, String endpoint, int statusCode, long duration) {
        logger.info("API Response - Method: {}, Endpoint: {}, StatusCode: {}, Duration: {}ms",
                method, endpoint, statusCode, duration);
    }

    /**
     * Logs details of an error that occurred during API processing.
     *
     * @param method      HTTP method (GET, POST, etc.)
     * @param endpoint    API endpoint that was accessed
     * @param errorMessage Description of the error
     * @param throwable    Exception that was thrown
     */
    public void logApiError(String method, String endpoint, String errorMessage, Throwable throwable) {
        logger.error("API Error - Method: {}, Endpoint: {}, Error: {}", method, endpoint, errorMessage, throwable);
    }

    /**
     * Logs audit information for API calls.
     *
     * @param method     HTTP method (GET, POST, etc.)
     * @param endpoint   API endpoint being accessed
     * @param userId     ID of the user making the request
     * @param action     Action being performed
     * @param timestamp  Time of the action
     */
    public void logApiAudit(String method, String endpoint, String userId, String action, String timestamp) {
        logger.info("API Audit - UserID: {}, Method: {}, Endpoint: {}, Action: {}, Timestamp: {}",
                userId, method, endpoint, action, timestamp);
    }
}
