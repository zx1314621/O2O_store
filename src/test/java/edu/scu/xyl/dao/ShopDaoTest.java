package edu.scu.xyl.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.scu.xyl.BaseTest;
import edu.scu.xyl.entity.Area;
import edu.scu.xyl.entity.PersonInfo;
import edu.scu.xyl.entity.Shop;
import edu.scu.xyl.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUser_id(1L);
		area.setArea_id(2);
		shopCategory.setShopCategoryId(1L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShop_name("测试的shop");
		shop.setShop_desc("test");
		shop.setShop_addr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		
		int effectiveNum = shopDao.insertShop(shop);
		assertEquals(1, effectiveNum);
		
	}
	
	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShop_id(1L);
//		PersonInfo owner = new PersonInfo();
//		Area area = new Area();
//		ShopCategory shopCategory = new ShopCategory();
//		owner.setUser_id(1L);
//		area.setArea_id(2);
//		shopCategory.setShopCategoryId(1L);
		
		
		shop.setShop_desc("测试Dylan");
		shop.setShop_addr("测试Address");
		shop.setLastUpdateTime(new Date());
		
		
		int effectiveNum = shopDao.updateShop(shop);
		assertEquals(1, effectiveNum);
		
	}
	

}
