package com.manager.service;

import java.util.List;

import com.manager.beans.Bmoney;
import com.manager.dao.BmDao;

public class BmService{
	
	BmDao bdao = new BmDao();

	public List<Bmoney> selectBmBySid(int sid) {
		return bdao.selectBm(sid);
	}

	public int updateBm(Bmoney bm) {
		return bdao.updateBm(bm);
	}

	public int delBmByBid(int bid) {
		return bdao.deleteBm(bid);
	}

	public int addBm(Bmoney bm) {
		return bdao.insertBm(bm);
	}
}
