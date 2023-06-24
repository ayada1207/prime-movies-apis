package com.prime.movies.common;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseBuilder {

    public ResponseEntity<ApiResponse> buildResponse(int httpStatusCode, String message, boolean success,Object data,
                                                     Map<String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder<>(httpStatusCode,message,success).
                withData(data).withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(
            int httpStatusCode, String message,boolean success,Map <String, Object> otherParams) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message,success)
                .withOtherParams(otherParams).build();
    }

    public ResponseEntity <ApiResponse> buildResponse(int httpStatusCode, String message,boolean success, Object data) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message,success)
                       .withData(data).build();
    }
}
