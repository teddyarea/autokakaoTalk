package com.thekstudio.autokakaotalk.service.kakao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface KakaoDao {
	//  �ֱ� 90�� �̳��� ����Ʈ �ǰŷ��� 4�� �˻�
	public List<HashMap<String, Object>> getDealPriceList(HashMap<String, Object> param) ;
}
