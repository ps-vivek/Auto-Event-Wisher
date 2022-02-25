package com.auto.eventwisher.config;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Configuration
public class GraphQLProvider {

        private GraphQL graphQL;

        @PostConstruct
        public void init() throws IOException {
            URL url = Resources.getResource("graphql/eventConfig.graphqls");
            String sdl = Resources.toString(url, Charsets.UTF_8);
            GraphQLSchema graphQLSchema = buildSchema(sdl);
            this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        }

        private GraphQLSchema buildSchema(String sdl) {
            TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
            RuntimeWiring runtimeWiring = buildWiring();
            SchemaGenerator schemaGenerator = new SchemaGenerator();
            return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
        }

        private RuntimeWiring buildWiring() {
            return RuntimeWiring.newRuntimeWiring()
                    .scalar(ExtendedScalars.Date)
                    .build();
        }

        @Bean
        public GraphQL graphQL() {
            return graphQL;
        }

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.Date;
    }
}
