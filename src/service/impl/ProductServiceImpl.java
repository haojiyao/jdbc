package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;

import entity.Product;
import service.ProductService;

public class ProductServiceImpl  implements ProductService{
	ProductDao proDao=new ProductDaoImpl();
		
	@Override
	public List<Product> getProByL1orL2orL3(String level1, String level2,
			String level3) {
		// TODO Auto-generated method stub
		return proDao.getProByL1orL2orL3(level1, level2, level3);
	}

	@Override
	public Product getProById(int id) {
		// TODO Auto-generated method stub
		return proDao.getProById(id);
	}

	@Override
	public List<Product> getProBy(String level1, String level2, String level3,
			String pageNo, String pageSize) {
		// TODO Auto-generated method stub
		return proDao.getProBy(level1, level2, level3, pageNo, pageSize);
	}

	@Override
	public boolean delectProduct(int id) {
		// TODO Auto-generated method stub
		return proDao.delectProduct(id);
	}

	@Override
	public boolean add(Product pro) {
		// TODO Auto-generated method stub
		return proDao.add(pro);
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return proDao.update(product);
	}
	
}
