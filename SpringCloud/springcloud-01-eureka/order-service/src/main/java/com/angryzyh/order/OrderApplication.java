package com.angryzyh.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.angryzyh.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
    /**
     *
     * @return RestTemplate 用于向别的模块发送http请求
     */
    @Bean
    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}