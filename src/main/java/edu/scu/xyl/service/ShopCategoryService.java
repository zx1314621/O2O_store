package edu.scu.xyl.service;

import java.util.List;

import edu.scu.xyl.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
