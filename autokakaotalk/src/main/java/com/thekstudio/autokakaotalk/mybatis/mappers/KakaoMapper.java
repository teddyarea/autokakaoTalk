package com.thekstudio.autokakaotalk.mybatis.mappers;

import java.util.HashMap;
import java.util.List;

public interface KakaoMapper {
	//  �ֱ� 90�� �̳��� ����Ʈ �ǰŷ��� 4�� �˻�
	public List<HashMap<String, Object>> getDealPriceList(HashMap<String, Object> param) ;
}