package cn.et.controller;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("sendMail")//告诉客户端微服务的名字
public interface StoreClient {

	@GetMapping("/user/{userId}")
	public Map<String, String> getUser(@PathVariable("userId") String userId);
	
	@PostMapping("/send")
	public String sendMail(@RequestBody Map<String, String> map);
}
