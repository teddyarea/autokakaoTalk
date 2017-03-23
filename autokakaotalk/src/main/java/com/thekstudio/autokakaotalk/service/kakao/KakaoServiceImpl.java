package com.thekstudio.autokakaotalk.service.kakao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KakaoServiceImpl implements KakaoService{
	@Autowired
	private KakaoDao kakaoDao;
	
	/* (non-Javadoc)
	 * @see com.thekstudio.autokakaotalk.service.kakao.KakaoService#getMessage(java.util.HashMap)
	 */
	public HashMap<String, Object> getMessage(HashMap<String, Object> param) throws IOException, SQLException{
		return this.kakaoDao.getMessage(param);
	}
}