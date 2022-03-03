package com.auto.eventwisher.graphql.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

//https://medium.com/swlh/understanding-graphql-error-handling-mechanisms-in-spring-boot-604301c9bedb
public class CustomMongoException extends  RuntimeException implements GraphQLError {
    public CustomMongoException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

}
