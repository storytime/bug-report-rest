package com.github.storytime.lambda.backup.http;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/diff")
@RegisterRestClient(configKey = "test-api")
public interface DataService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response getAsObject(@BeanParam ReqOptions options, TestRequestBody body);

}