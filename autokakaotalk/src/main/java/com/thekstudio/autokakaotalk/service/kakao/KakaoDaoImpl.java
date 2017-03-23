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
	

	/* (non-Javadoc)
	 * @see com.thekstudio.autokakaotalk.service.kakao.KakaoDao#getMainButtons(java.util.HashMap)
	 */
	public List<HashMap<String, Object>> getMainButtons() {
		try {
			return sqlSession.getMapper(KakaoMapper.class).getMainButtons();
		} catch (Exception e) {
			return new ArrayList<HashMap<String, Object>>();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.thekstudio.autokakaotalk.service.kakao.KakaoDao#getMessage(java.util.HashMap)
	 */
	public HashMap<String, Object> getMessage(HashMap<String, Object> param) {
		try {
			return sqlSession.getMapper(KakaoMapper.class).getMessage(param);
		} catch (Exception e) {
			return new HashMap<String, Object>();
		}
	}
}
