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
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	  * @Method Name : admin
	  * @작성일 : 2017. 3. 22.
	  * @작성자 : kiyong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param param
	  * @param model
	  * @return
	  * @throws Exception
	  */
	@RequestMapping(value = "/autokakao/admin", method = RequestMethod.GET)
	public ModelAndView admin(@RequestParam HashMap<String,Object> param, ModelAndView model) throws Exception {
		
//		model.addObject("bjdongList",	addressService.getBjdongList(param));
//		model.addObject("roadList", 	addressService.getRoadNameList(param));
		
		String viewName = "";
		
		// JSP페이지
		viewName = "/admin/admin";
		
		model.setViewName(viewName);
		
		return model;
	}
}