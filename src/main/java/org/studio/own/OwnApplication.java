package org.studio.own;

import javax.sql.DataSource;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;
@SpringBootApplication
public class OwnApplication {
	private final static Logger log = LoggerFactory.getLogger(Application.class);
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	//覆盖默认数据源，使用druid数据源
	public DataSource dataSource(){
		return new DruidDataSource();
	}

	public static void main(String[] args) {
		SpringApplication.run(OwnApplication.class, args);
		log.info("启动成功");
	}
}
