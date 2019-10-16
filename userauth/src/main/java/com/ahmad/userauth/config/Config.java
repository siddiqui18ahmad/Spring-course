package com.ahmad.userauth.config;


import com.microsoft.azure.cosmosdb.ConnectionMode;
import com.microsoft.azure.cosmosdb.ConnectionPolicy;
import com.microsoft.azure.cosmosdb.ConsistencyLevel;
import com.microsoft.azure.cosmosdb.FeedOptions;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Value("${cosmos.host}")
    private String uri;
    @Value("${cosmos.secret.name}")
    private String key;
    @Value("${cosmos.database}")
    private String dbName;
    @Value("${azure.feedOptions.maxDegreeOfParallelism}")
    private int maxDegreeOfParallelism;
    @Value("${azure.feedOptions.maxBufferedItemCount}")
    private int maxBufferedItemCount;
    @Value("${azure.feedOptions.enableCrossPartitionQuery}")
    private boolean enableCrossPartitionQuery;
    @Value("${azure.feedOptions.maxItemCount}")
    private int maxItemCount;
    @Value("${azure.connectionPolicy.connectionMode}")
    private String connectionMode;
    @Value("${azure.connectionPolicy.maxPoolSize}")
    private int maxPoolSize;
    @Value("${azure.connectionPolicy.requestTimeoutInMillis}")
    private int requestTimeoutInMillis;
    @Value("${azure.connectionPolicy.consistencyLevel}")
    private String consistencyLevel;

    @Bean
    public FeedOptions feedOptions() {
        FeedOptions queryOptions = new FeedOptions();
        queryOptions.setMaxDegreeOfParallelism(maxDegreeOfParallelism);
        queryOptions.setMaxBufferedItemCount(maxBufferedItemCount);
        queryOptions.setMaxItemCount(maxItemCount);
        queryOptions.setEnableCrossPartitionQuery(enableCrossPartitionQuery);
        return queryOptions;
    }

    @Bean
    public AsyncDocumentClient documentClient() {
        ConnectionPolicy cp = ConnectionPolicy.GetDefault();
        cp.setConnectionMode(ConnectionMode.valueOf(connectionMode));
        cp.setMaxPoolSize(maxPoolSize);
        cp.setRequestTimeoutInMillis(requestTimeoutInMillis);
        return new AsyncDocumentClient.Builder().withServiceEndpoint(uri).withMasterKeyOrResourceToken(key).withConnectionPolicy(cp).withConsistencyLevel(ConsistencyLevel.valueOf(consistencyLevel)).build();
    }
}
