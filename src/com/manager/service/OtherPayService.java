package com.manager.service;

import java.util.List;

import com.manager.beans.OtherPay;
import com.manager.dao.OtherPayDao;
import com.manager.tools.PageHelper;

/**
 * 
 * 临时加上，不做过多处理
 *
 */

public class OtherPayService {
	
	OtherPayDao opo = new OtherPayDao();

	public List<OtherPay> selectOtherPayByUid(int id,PageHelper ph) {
		return opo.selectByUidLimit(id, ph);
	}
	
	public int selectAllOtherPayByUid(int id) {
		return opo.selectAllByUid(id);
	}
	public void insertOtherPay(OtherPay op) {
		opo.insertOtherPay(op);
	}
	public void deleteOtherPayById(int id) {
		opo.deleteById(id);
	}

	public int selectTotolMoney(int id) {
		return opo.selectAllMoneyByUid(id);
	}
	
}
