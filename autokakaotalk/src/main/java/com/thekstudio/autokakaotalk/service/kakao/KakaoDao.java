package com.thekstudio.autokakaotalk.service.kakao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface KakaoDao {
	
	/**
	  * @Method Name : getMainButtons
	  * @�ۼ��� : 2017. 3. 23.
	  * @�ۼ��� : kiyong
	  * @�����̷� : 
	  * @Method ���� :
	  * @param param
	  * @return
	  */
	public List<HashMap<String, Object>> getMainButtons() ;
	
	/**
	  * @Method Name : getMessage
	  * @�ۼ��� : 2017. 3. 23.
	  * @�ۼ��� : kiyong
	  * @�����̷� : 
	  * @Method ���� :
	  * @param param
	  * @return
	  */
	public HashMap<String, Object> getMessage(HashMap<String, Object> param) ;
}
