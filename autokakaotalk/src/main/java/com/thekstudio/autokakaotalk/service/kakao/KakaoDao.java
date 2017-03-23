package com.thekstudio.autokakaotalk.service.kakao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface KakaoDao {
	
	/**
	  * @Method Name : getMainButtons
	  * @작성일 : 2017. 3. 23.
	  * @작성자 : kiyong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param param
	  * @return
	  */
	public List<HashMap<String, Object>> getMainButtons() ;
	
	/**
	  * @Method Name : getMessage
	  * @작성일 : 2017. 3. 23.
	  * @작성자 : kiyong
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param param
	  * @return
	  */
	public HashMap<String, Object> getMessage(HashMap<String, Object> param) ;
}
