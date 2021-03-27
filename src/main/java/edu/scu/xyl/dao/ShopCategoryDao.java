package edu.scu.xyl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.scu.xyl.entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
