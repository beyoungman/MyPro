package com.manager.service;

import java.util.List;

import com.manager.beans.Buy;
import com.manager.beans.Sale;
import com.manager.dao.SaleDao;
import com.manager.tools.PageHelper;

public class SaleService {
	SaleDao sdao = new SaleDao();

	
	public List<Sale> selectSaleBySid(int id) {
		return sdao.selectSaleSid(id);
	}

	public int insertSale(Sale sale) {
		return sdao.insertSale(sale);
	}

	public int updateSale(Sale sale) {
		return sdao.updateSale(sale);
	}

	public int delSaleBySaleid(int sale_id) {
		return sdao.deleteSale(sale_id);
	}

	public List<Sale> selectSaleBySidLimit(int userid, PageHelper sph) {
		return sdao.selectSaleSidLimit(userid,sph);
	}

	public int selectTotolWeight(int id) {
		return sdao.selectTotolWeight(id);
	}

	public int selectTotolMoney(int id) {
		return sdao.selectTotolMoney(id);
	}
}
