package com.prime.movies.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpHeaders;
import java.util.Collections;
import java.util.Map;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private final int httpStatusCode;
    private final String message;
    private final boolean success;
    private final T data;
    private final Map<String, Object> otherParams;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpStatusCode = builder.httpStatusCode;
        this.message = builder.message;
        this.success= builder.success;
        this.data = (T) builder.data;
        this.otherParams = builder.otherParams;
    }


    public static class ApiResponseBuilder<T> {
        private final int httpStatusCode;
        private final String message;
        private final boolean success;
        private T data;

        private Map<String, Object> otherParams = Collections.emptyMap();


        public ApiResponseBuilder(int httpStatusCode, String message,boolean success) {
            this.httpStatusCode = httpStatusCode;
            this.message = message;
            this.success = success;
        }

        public ApiResponseBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public ApiResponseBuilder<T> withOtherParams(Map<String, Object> otherParams) {
            this.otherParams = otherParams;
            return this;
        }

        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.getHttpStatusCode())
                    .body(apiResponse);
        }
    }
}
