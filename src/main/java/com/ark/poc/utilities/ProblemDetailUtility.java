package com.ark.poc.utilities;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class ProblemDetailUtility {

    public ProblemDetail setProblemDetail(HttpStatusCode statusCode, String message, String description) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(statusCode, message);
        problemDetail.setProperty("description", description);

        return problemDetail;
    }

}
