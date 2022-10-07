package com.github.storytime.lambda.backup.http;

import javax.ws.rs.HeaderParam;

public class ReqOptions {
    @HeaderParam("Authorization")
    String auth = "Bearer XXX";
}
