package edu.scu.xyl.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.scu.xyl.BaseTest;
import edu.scu.xyl.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
		for (ShopCategory s : shopCategoryList) {
			System.out.print(s.getShopCategoryId());
			System.out.print(s.getShopCategoryName());
			System.out.print(s.getCreateTime());
		}
		assertEquals(1, shopCategoryList.size());
		
//		ShopCategory shopCategory = new ShopCategory();
//		ShopCategory parent = new ShopCategory();
//		parent.setShopCategoryId(1L);
//		shopCategory.setParent(parent);
//		shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
//		assertEquals(1, shopCategoryList.size());
//		System.out.print(shopCategoryList.get(0).getShopCategoryName());
	}
	  
}
