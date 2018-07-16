package hx.cloud.config.db.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author mingliang
 * @Date 2018-06-28 17:57
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class HXConfigServiceApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(HXConfigServiceApplication.class,args);
        System.out.println("启动成功，耗时："+(System.currentTimeMillis() - start)+"ms");
    }
}
