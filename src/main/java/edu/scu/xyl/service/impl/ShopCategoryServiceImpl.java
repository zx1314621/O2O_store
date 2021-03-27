package edu.scu.xyl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.scu.xyl.dao.ShopCategoryDao;
import edu.scu.xyl.entity.ShopCategory;
import edu.scu.xyl.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{

	@Autowired ShopCategoryDao shopCategoryDao;
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// TODO Auto-generated method stub
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
