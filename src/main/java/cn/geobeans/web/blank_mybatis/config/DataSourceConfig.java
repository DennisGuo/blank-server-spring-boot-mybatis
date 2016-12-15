package cn.geobeans.web.blank_mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by ghx on 2016/12/14.
 */
@Configuration
@EnableAutoConfiguration
public class DataSourceConfig {

    private static final Logger logger  = LoggerFactory.getLogger(DataSourceConfig.class.getName());

    @Autowired
    private DataSourceProperties db;

    @Bean
    @Primary
    public DruidDataSource dataSource(){
        DruidDataSource source = new DruidDataSource();
        logger.info("初始化DruidDataSource：" + JSON.toJSONString(db));
        source.setDriverClassName(db.driverClassName);
        source.setUrl(db.url);
        source.setUsername(db.username);
        source.setPassword(db.password);
//        source.setDriverClassName(driverClass);
        return source;
    }

}
