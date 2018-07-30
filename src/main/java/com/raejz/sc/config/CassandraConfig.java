package com.raejz.sc.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.google.common.collect.Lists;
import java.net.InetSocketAddress;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Cassandra DB configurations
 */
@Configuration
public class CassandraConfig {

    @Value("${database.cassandra.hosts}")
    private String hostList;

    @Value("${database.cassandra.cluster.username}")
    private String userName;

    @Value("${database.cassandra.cluster.password}")
    private String password;

    @Value("${database.cassandra.keyspace}")
    private String keyspace;

    @Value("${database.cassandra.pooltimeout}")
    private Integer poolTimeout;

    @Value("${database.cassandra.heartbeat}")
    private Integer heartbeatInterval;

    @Value("${database.cassandra.fetchsize}")
    private Integer fetchSize;

    @Bean
    public Cluster getCluster() {
        PoolingOptions poolingOptions = new PoolingOptions();
        poolingOptions.setConnectionsPerHost(HostDistance.LOCAL, 4,10);
        poolingOptions.setConnectionsPerHost(HostDistance.REMOTE, 2,4);
        poolingOptions.setPoolTimeoutMillis(poolTimeout);
        poolingOptions.setHeartbeatIntervalSeconds(heartbeatInterval);

        return Cluster.builder()
                .addContactPointsWithPorts(getHostIntetSocketAddressList(hostList))
                .withCredentials(userName, password)
                //.withClusterName(clusterName).withAuthProvider(authProvider)
                .withPoolingOptions(poolingOptions)
                .withQueryOptions(new QueryOptions()
                        .setConsistencyLevel(ConsistencyLevel.LOCAL_QUORUM))
                .withQueryOptions(new QueryOptions().setFetchSize(fetchSize))
                .build();
    }

    private List<InetSocketAddress> getHostIntetSocketAddressList(String hostList) {
        List<InetSocketAddress> cassandraHosts = Lists.newArrayList();
        for (String host : hostList.split(",")) {
            InetSocketAddress socketAddress = new InetSocketAddress(host.split(":")[0],
                    Integer.valueOf(host.split(":")[1]));
            cassandraHosts.add(socketAddress);
        }
        return cassandraHosts;
    }

    @Bean
    public Session getSession() {
        Cluster cluster = getCluster();
        //cluster.getConfiguration().getCodecRegistry().register(Times);
        return cluster.connect(keyspace);
    }

    @Bean
    public MappingManager getManager() {
        return new MappingManager(getSession());
    }
}
