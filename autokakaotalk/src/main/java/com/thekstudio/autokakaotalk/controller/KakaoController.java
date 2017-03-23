package com.thekstudio.autokakaotalk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thekstudio.autokakaotalk.service.kakao.KakaoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class KakaoController {
	
	@Autowired
	private KakaoService	 kakaoService;
	
	private static final Logger logger = LoggerFactory.getLogger(KakaoController.class);
	
	@ResponseBody
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET)
	public HashMap<String, Object> keyboard(){
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		ArrayList<String> mainButtons = new ArrayList<String>(); 
		List<HashMap<String, Object>> list;
		
		try {
			list = kakaoService.getMainButtons();
			
			for(int i = 0; i < list.size(); i++){
				mainButtons.add(list.get(i).get("CONTENT").toString());
			}
			
			hashMap.put("type", "buttons");
			hashMap.put("buttons", mainButtons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("{}", hashMap);
		
		return hashMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public HashMap<String, Object> message(HttpServletRequest request) throws Exception {
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
			
			HashMap<String, Object> param = new HashMap<String, Object>();
			
			param.put("user_key", user_key);
			param.put("content", content);
			
			hashMap = messageChk(param);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			message.put("text", "잘못된 명령어 입니다.");
			hashMap.put("message", message);
		}
		
		return hashMap;
	}
	
	private HashMap<String,Object> messageChk(HashMap<String, Object> param){
		HashMap<String, Object> result = new HashMap<String,Object>();
		HashMap<String, Object> message = new HashMap<String,Object>();
		
		try {
			HashMap<String, Object> kakaoMap = kakaoService.getMessage(param);
			
			if(kakaoMap.get("TEXT") != null){
				message.put("text", kakaoMap.get("TEXT"));
			}
			
			if(kakaoMap.get("PHOTO") != null){
				message.put("photo", kakaoMap.get("PHOTO"));
			}
			
			result.put("message", message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}