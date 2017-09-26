package service.impl;

import java.util.List;

import dao.ProductCategoryDao;
import dao.impl.ProCateDaoImpl;

import entity.ProductCategory;
import service.ProCateService;

public class ProCateServiceImpl implements ProCateService{
	ProductCategoryDao procateDao=new ProCateDaoImpl();
	
	@Override
	public List<ProductCategory> getProductCategory(int parentId, int type) {
		// TODO Auto-generated method stub
		return procateDao.getProductCategory(parentId, type);
	}

}
