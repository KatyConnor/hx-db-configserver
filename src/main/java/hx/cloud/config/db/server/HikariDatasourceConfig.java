package hx.cloud.config.db.server;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.MetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

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
    @Value("${spring.datasource.hikari.password}")
    private long connectionTimeout;
    @Value("${spring.datasource.hikari.password}")
    private long validationTimeout;
    @Value("${spring.datasource.hikari.password}")
    private long idleTimeout;
    @Value("${spring.datasource.hikari.password}")
    private long leakDetectionThreshold;
    @Value("${spring.datasource.hikari.password}")
    private long maxLifetime;
    @Value("${spring.datasource.hikari.password}")
    private int maxPoolSize;
    @Value("${spring.datasource.hikari.password}")
    private int minimumIdle;
    @Value("${spring.datasource.hikari.password}")
    private long initializationFailTimeout;
    @Value("${spring.datasource.hikari.password}")
    private String connectionInitSql;
    @Value("${spring.datasource.hikari.password}")
    private String connectionTestQuery;
    @Value("${spring.datasource.hikari.password}")
    private String dataSourceClassName;
    @Value("${spring.datasource.hikari.password}")
    private String dataSourceJndiName;
    @Value("${spring.datasource.hikari.password}")
    private String poolName;
    @Value("${spring.datasource.hikari.password}")
    private String schema;
    @Value("${spring.datasource.hikari.password}")
    private String transactionIsolationName;
    @Value("${spring.datasource.hikari.password}")
    private boolean isAutoCommit;
    @Value("${spring.datasource.hikari.password}")
    private boolean isReadOnly;
    @Value("${spring.datasource.hikari.password}")
    private boolean isIsolateInternalQueries;
    @Value("${spring.datasource.hikari.password}")
    private boolean isRegisterMbeans;
    @Value("${spring.datasource.hikari.password}")
    private boolean isAllowPoolSuspension;
    @Value("${spring.datasource.hikari.password}")
    private DataSource dataSource;
    @Value("${spring.datasource.hikari.password}")
    private Properties dataSourceProperties;
    @Value("${spring.datasource.hikari.password}")
    private ThreadFactory threadFactory;
    @Value("${spring.datasource.hikari.password}")
    private ScheduledExecutorService scheduledExecutor;
    @Value("${spring.datasource.hikari.password}")
    private MetricsTrackerFactory metricsTrackerFactory;
    @Value("${spring.datasource.hikari.password}")
    private Object metricRegistry;
    @Value("${spring.datasource.hikari.password}")
    private Object healthCheckRegistry;
    @Value("${spring.datasource.hikari.password}")
    private Properties healthCheckProperties;

    @Bean(name = "hikariDataSource")
    @Qualifier("hikariDataSource")
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = DataSourceBuilder.create().type(com.zaxxer.hikari.HikariDataSource.class).build();
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);

        hikariDataSource.setMinimumIdle(minimumIdle);
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
