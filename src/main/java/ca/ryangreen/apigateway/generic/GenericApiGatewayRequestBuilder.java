package ca.ryangreen.apigateway.generic;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.http.HttpMethodName;

import ca.ryangreen.apigateway.util.Validate;

public class GenericApiGatewayRequestBuilder {
    private HttpMethodName httpMethod;

    private String resourcePath;

    private InputStream body;

    private Map<String, String> headers;

    private Map<String, List<String>> parameters = new LinkedHashMap<String, List<String>>();

    public GenericApiGatewayRequestBuilder withHttpMethod(HttpMethodName name) {
        this.httpMethod = name;
        return this;
    }

    public GenericApiGatewayRequestBuilder withResourcePath(String path) {
        this.resourcePath = path;
        return this;
    }

    public GenericApiGatewayRequestBuilder withBody(InputStream content) {
        this.body = content;
        return this;
    }

    public GenericApiGatewayRequestBuilder withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public GenericApiGatewayRequestBuilder withParameters(Map<String, List<String>> parameters) {
        this.parameters = parameters;
        return this;
    }

    public GenericApiGatewayRequest build() {
        Validate.notNull(this.httpMethod, "HTTP method");
        Validate.notEmpty(this.resourcePath, "Resource path");
        return new GenericApiGatewayRequest(this.httpMethod, this.resourcePath, this.body,
            this.headers, this.parameters);
    }
}