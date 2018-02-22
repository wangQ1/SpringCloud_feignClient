package cn.et.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

@Controller
public class SendController {
	@Autowired
	private StoreClient storeClient;
	@ResponseBody
	@GetMapping("/invokeUser")
    public String invokeUser(String id) {
		//String result=restTemplate.getForObject("http://SENDMAIL/user/{id}", String.class,id);
		Map<String, String> result = storeClient.getUser(id);
		return result.get("name").toString();
	}
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/sendClient")
	public String sendMail(String email_to, String email_subject, String email_content){
		//通过注册中心客户端负载均横  获取并调用一个sendMail服务
		try {
			Map<String, String> map = new HashMap();
			map.put("email_to", email_to);
			map.put("email_subject", email_subject);
			map.put("email_content", email_content);
			storeClient.sendMail(map);
		} catch (RestClientException e) {
			e.printStackTrace();
			return "redirect:/failed.html";//请求重定向，html默认不支持请求转发
		}
		return "redirect:/suc.html";//请求重定向，html默认不支持请求转发
	}
}
