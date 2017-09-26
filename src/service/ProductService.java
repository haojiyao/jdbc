package service;

import java.util.List;

import entity.Product;

public interface ProductService {
			//根据分类级别id查询该分类下的上商品
			public List<Product> getProByL1orL2orL3(String level1,String level2,String level3);
			//根据商品id查询商品
			public Product getProById(int id);
			public List<Product> getProBy(String level1,String level2,String level3,String pageNo,String pageSize);
			
			
			public boolean delectProduct(int id);
			
			public boolean add(Product pro);
			
			public boolean update(Product product);
}
