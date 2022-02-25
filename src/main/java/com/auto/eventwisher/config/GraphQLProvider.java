package com.auto.eventwisher.config;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLProvider {

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.Date;
    }
}
