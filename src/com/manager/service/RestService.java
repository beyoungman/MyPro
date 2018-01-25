package com.manager.service;

import java.util.List;

import com.manager.beans.Rest;
import com.manager.dao.RestDao;

public class RestService{
	
	RestDao rdao = new RestDao();

	public List<Rest> selectRestBySid(int sid) {
		return rdao.selectRest(sid);
	}

	public int delRestByRid(int rid) {
		return rdao.deleteRest(rid);
	}

	public int addRest(Rest re) {
		return rdao.insertRest(re);
	}

	public int updateRest(Rest rest) {
		return rdao.updateRest(rest);
	}
}
