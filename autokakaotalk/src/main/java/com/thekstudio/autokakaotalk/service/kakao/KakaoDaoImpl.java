package com.thekstudio.autokakaotalk.service.kakao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thekstudio.autokakaotalk.mybatis.mappers.KakaoMapper;


@Repository
public class KakaoDaoImpl implements KakaoDao {

	@Autowired
	@Resource(name="sqlSession")
	private SqlSession sqlSession;
	


	private static final Logger logger = LoggerFactory.getLogger(KakaoDaoImpl.class);
	

	//  최근 90일 이내의 아파트 실거래가 4건 검색
	public List<HashMap<String, Object>> getDealPriceList(HashMap<String, Object> param) {
		try {
			return sqlSession.getMapper(KakaoMapper.class).getDealPriceList(param);
		} catch (Exception e) {
			return new ArrayList<HashMap<String, Object>>();
		}
	}
}
