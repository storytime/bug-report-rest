package com.github.storytime.lambda.backup.http;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record TestRequestBody(long currentClientTimestamp, long serverTimestamp) {
}