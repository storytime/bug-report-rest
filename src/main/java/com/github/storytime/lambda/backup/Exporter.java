package com.github.storytime.lambda.backup;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.github.storytime.lambda.backup.http.HttpService;
import io.smallrye.common.constraint.NotNull;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Exporter implements RequestHandler<SQSEvent, Integer> {
    @Inject
    Logger logger;

    @Inject
    HttpService httpService;


    @Override
    public Integer handleRequest(final @NotNull SQSEvent message, final Context context) {
        logger.infof("Start");
//        steps
//        1. get sqs msg
//        2. find based on message data in dyn db
//        3. do req to external services
//        4. save part of data on s3.


        //3.
        httpService.getZenDataMapped();
        logger.infof("Finish");
        return 0;
    }
}