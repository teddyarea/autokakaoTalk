package com.thekstudio.autokakaotalk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class KakaoController {
	
	private static final Logger logger = LoggerFactory.getLogger(KakaoController.class);
	
	@ResponseBody
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public HashMap<String, Object> keyboard(){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("선택1");
		list.add("선택2");
		list.add("선택3");

		hashMap.put("type", "buttons");
		hashMap.put("buttons", list);
		
		
		logger.info("{}", hashMap);
		
		return hashMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public HashMap<String, Object> message(HttpServletRequest request){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		HashMap<String, Object> message = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		String line = null;
		String user_key = "";
		String content = "";
		
		BufferedReader reader;
		try {
			reader = request.getReader();
			
			while ((line = reader.readLine()) != null){
				sb.append(line);
			}
			
			String jsonString = sb.toString();
			
			Object obj = JSONValue.parse(jsonString);
			JSONObject json = (JSONObject)obj;
			if(json != null){
				user_key = json.get("user_key").toString();
				content = json.get("content").toString();
			}
			
			hashMap = messageChk(user_key, content);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			message.put("text", "잘못된 명령어 입니다.");
			hashMap.put("message", message);
		}
		
		return hashMap;
	}
	
	private HashMap<String,Object> messageChk(String user_key, String content){
		HashMap<String, Object> result = new HashMap<String,Object>();
		HashMap<String, Object> message = new HashMap<String,Object>();
		
		message.put("text", user_key + content);
		result.put("message", message); 
		
		return result;
	}
}