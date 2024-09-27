package org.agilo.utils;

public final class Constants {

    private Constants() {}

    public static final class ApiConstants {
        public static final String POST = "POST";
        public static final String GET = "GET";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }

    public static final class ApiStatus {
        public static final String SUCCESS = "200";
        public static final String CREATED = "201";
        public static final String BAD_REQUEST = "400";
        public static final String UNAUTHORIZED = "401";
        public static final String FORBIDDEN = "403";
        public static final String NOT_FOUND = "404";
        public static final String INTERNAL_SERVER_ERROR = "500";
    }

    public static final class ErrorMessages {
        public static final String INVALID_INPUT = "Invalid input provided.";
        public static final String RESOURCE_NOT_FOUND = "Requested resource not found.";
        public static final String SERVER_ERROR = "An unexpected error occurred.";
    }
}
