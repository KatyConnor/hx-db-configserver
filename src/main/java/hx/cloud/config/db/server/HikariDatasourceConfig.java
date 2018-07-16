package hx.cloud.config.db.server;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @Author mingliang
 * @Date 2018-07-09 17:31
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class HikariDatasourceConfig {

    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.hikari.jdbc-url}")
    private String jdbcUrl;
    @Value("${spring.datasource.hikari.username}")
    private String username;
    @Value("${spring.datasource.hikari.password}")
    private String password;
    @Value("${spring.datasource.hikari.minimum-idle}")
    private int minimumIdle;
    @Value("${spring.datasource.hikari.auto-commit}")
    private boolean isAutoCommit;
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maxPoolSize;
    @Value("${spring.datasource.hikari.idle-timeout}")
    private long idleTimeout;
    @Value("${spring.datasource.hikari.pool-name}")
    private String poolName;
    @Value("${spring.datasource.hikari.max-lifetime}")
    private long maxLifetime;
    @Value("${spring.datasource.hikari.connection-timeout}")
    private long connectionTimeout;
    @Value("${spring.datasource.hikari.connection-test-query}")
    private String connectionTestQuery;
    @Value("${spring.datasource.hikari.data-source-class-name}")
    private String dataSourceClassName;
    @Value("${spring.datasource.hikari.validation-timeout}")
    private long validationTimeout;
    @Value("${spring.datasource.hikari.leak-detection-threshold}")
    private long leakDetectionThreshold;
    @Value("${spring.datasource.hikari.initialization-fail-timeout}")
    private long initializationFailTimeout;
    @Value("${spring.datasource.hikari.connection-init-sql}")
    private String connectionInitSql;
    @Value("${spring.datasource.hikari.data-source-j-n-d-i}")
    private String dataSourceJndiName;
    @Value("${spring.datasource.hikari.schema}")
    private String schema;
    @Value("${spring.datasource.hikari.transaction-isolation}")
    private String transactionIsolationName;
    @Value("${spring.datasource.hikari.register-mbeans}")
    private boolean isRegisterMbeans;
    @Value("${spring.datasource.hikari.read-only}")
    private boolean isReadOnly;

//    @Value("${spring.datasource.hikari.password}")
//    private boolean isIsolateInternalQueries;
//    @Value("${spring.datasource.hikari.password}")
//    private boolean isAllowPoolSuspension;
//    @Value("${spring.datasource.hikari.password}")
//    private DataSource dataSource;
//    @Value("${spring.datasource.hikari.password}")
//    private Properties dataSourceProperties;
//    @Value("${spring.datasource.hikari.password}")
//    private ThreadFactory threadFactory;
//    @Value("${spring.datasource.hikari.password}")
//    private ScheduledExecutorService scheduledExecutor;
//    @Value("${spring.datasource.hikari.password}")
//    private MetricsTrackerFactory metricsTrackerFactory;
//    @Value("${spring.datasource.hikari.password}")
//    private Object metricRegistry;
//    @Value("${spring.datasource.hikari.password}")
//    private Object healthCheckRegistry;
//    @Value("${spring.datasource.hikari.password}")
//    private Properties healthCheckProperties;

    @Bean(name = "hikariDataSource")
    @Qualifier("hikariDataSource")
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(com.zaxxer.hikari.HikariDataSource.class).build();
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("hikariDataSource") DataSource dataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sessionFactory.getObject();
//    }
}
