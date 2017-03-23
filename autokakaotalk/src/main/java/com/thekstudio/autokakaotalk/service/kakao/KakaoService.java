package com.thekstudio.autokakaotalk.service.kakao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;



public interface KakaoService {
	
	/**
	  * @Method Name : getMainButtons
	  * @�ۼ��� : 2017. 3. 23.
	  * @�ۼ��� : kiyong
	  * @�����̷� : 
	  * @Method ���� :
	  * @param param
	  * @return
	  * @throws IOException
	  * @throws SQLException
	  */
	public List<HashMap<String, Object>> getMainButtons() throws IOException, SQLException;
	
	/**
	  * @Method Name : getMessage
	  * @�ۼ��� : 2017. 3. 23.
	  * @�ۼ��� : kiyong
	  * @�����̷� : 
	  * @Method ���� :
	  * @param param
	  * @return
	  * @throws IOException
	  * @throws SQLException
	  */
	public HashMap<String, Object> getMessage(HashMap<String, Object> param) throws IOException, SQLException;
}
