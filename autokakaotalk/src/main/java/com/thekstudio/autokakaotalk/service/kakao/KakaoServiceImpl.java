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
	
	//  최근 90일 이내의 아파트 실거래가 4건 검색
	public List<HashMap<String, Object>> getDealPriceList(HashMap<String, Object> param) throws IOException, SQLException{
		return this.kakaoDao.getDealPriceList(param);
	}
}