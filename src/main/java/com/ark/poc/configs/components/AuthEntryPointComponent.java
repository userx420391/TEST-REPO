package com.ark.poc.configs.components;

import com.ark.poc.utilities.ProblemDetailUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthEntryPointComponent implements AuthenticationEntryPoint {

    private final ProblemDetailUtility problemDetail = new ProblemDetailUtility();

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authenticationException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(
            response.getOutputStream(),
            problemDetail.setProblemDetail(
                HttpStatusCode.valueOf(HttpServletResponse.SC_UNAUTHORIZED),
                authenticationException.getMessage(),
                "Authentication of web security blocked this request."
            ));
    }

}
