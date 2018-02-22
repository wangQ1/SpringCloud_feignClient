package cn.et;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//Eureka是一个服务发现框架,其中包含两个组件：Eureka Server和Eureka Client， Eureka Server提供服务注册服务
//各个节点启动后，会在Eureka Server中进行注册。Eureka Client是一个java客户端，用于在注册中心注册服务，简化与Eureka Server的交互
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients//启用feign客户端
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
