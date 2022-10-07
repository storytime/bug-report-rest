package com.github.storytime.lambda.backup.http;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URI;


@ApplicationScoped
public class HttpService {

    @Inject
    Logger logger;


    private final DataService dataServiceSlow;

    private final DataService dataServiceFast;


    public HttpService() {
        // TEST server will wait 60 SECs before it will return any data
        dataServiceSlow = RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://c87605ef-5cbf-4858-9f23-3751f0251d36.mock.pstmn.io/"))
                .build(DataService.class);

        // TEST server will return data without any delay
        dataServiceFast = RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://77139bb7-6591-4c98-8b9a-dabfeca47b31.mock.pstmn.io"))
                .build(DataService.class);

        //response save for both end-points

/**
 {
 "serverTimestamp": 1000000,
 "user": [
 {
 "id": 1000
 }
 ]
 }
 */
    }

    public void getZenDataMapped() {
        try {
            TestRequestBody body = new TestRequestBody(10000, 0L);
            ReqOptions options = new ReqOptions();

            Response fast = dataServiceFast.getAsObject(options, body);
            logger.infof("Fast all ok: [%s]", fast.user);

            Response slow = dataServiceSlow.getAsObject(options, body);
            logger.infof("Slow all ok: [%s]", slow.user);

        } catch (Exception e) {
            logger.errorf("fatal error: ", e);
        }
    }
}
