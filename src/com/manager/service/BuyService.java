package com.manager.service;

import java.util.List;

import com.manager.beans.Buy;
import com.manager.dao.BuyDao;
import com.manager.tools.PageHelper;

public class BuyService {
	
	BuyDao bdao = new BuyDao();

	public List<Buy> selectBuyByUid(int id) {
		
		return bdao.selectBuyUid(id);
	}

	public int insertBuy(Buy buy) {
		return bdao.insertBuy(buy);
	}

	public int updateBuy(Buy buy) {
		return bdao.updateBuy(buy);
	}

	public int delBuybyBuyid(int buy_id) {
		return bdao.deleteBuy(buy_id);
	}

	public List<Buy> selectBuyByUidLimit(int id, PageHelper bph) {
		return bdao.selectBuyUidLimit(id, bph);
	}

	public int selectTotolWeight(int id) {
		return bdao.selectTotolWeight(id);
	}

	public int selectTotolMoney(int id) {
		return bdao.selectTotolMoney(id);
	}

	public int selectTotolWeigh_Money(int id) {
		return bdao.selectTotolWeigh_Money(id);
	}
}
