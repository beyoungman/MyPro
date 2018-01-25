package com.manager.service;

import java.util.List;

import com.manager.beans.Ot;
import com.manager.dao.OtDao;

public class OtService{
	
	OtDao odao = new OtDao();

	
	public List<Ot> getOtsBySid(int sid) {
		
		return odao.select(sid);
	}

	public int updateOt(Ot ot) {
		
		return odao.update(ot);
	}

	public int delOtByOid(int oid) {
		return odao.deleteOt(oid);
	}

	public int addOt(Ot ot) {
		return odao.insertOt(ot);
	}
	
}
