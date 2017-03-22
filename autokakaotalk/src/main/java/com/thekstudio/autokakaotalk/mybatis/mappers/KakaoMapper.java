package com.thekstudio.autokakaotalk.mybatis.mappers;

import java.util.HashMap;
import java.util.List;

public interface KakaoMapper {
	//  최근 90일 이내의 아파트 실거래가 4건 검색
	public List<HashMap<String, Object>> getDealPriceList(HashMap<String, Object> param) ;
}