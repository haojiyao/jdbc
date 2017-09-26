package service;

import java.util.List;

import entity.ProductCategory;

public interface ProCateService {
		//根据级别和父类id查询商品分类
		public List<ProductCategory> getProductCategory(int parentId,int type);
}
