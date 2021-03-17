package edu.scu.xyl.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.scu.xyl.BaseTest;
import edu.scu.xyl.dto.ShopExecution;
import edu.scu.xyl.entity.Area;
import edu.scu.xyl.entity.PersonInfo;
import edu.scu.xyl.entity.Shop;
import edu.scu.xyl.entity.ShopCategory;
import edu.scu.xyl.enums.ShopStateEnum;

public class ShopServiceTest extends BaseTest{

	@Autowired
	private ShopService shopService;
	
	@Test
	public void testAddShop() {
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
		shop.setShop_name("测试的店铺1");
		shop.setShop_desc("test1");
		shop.setShop_addr("test1");
		shop.setPhone("test1");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		
		File shopImg = new File("/Users/dylan/Desktop/coding/TestLeetCode/image/yosemite.jpg");
		ShopExecution se = shopService.addShop(shop, shopImg);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}
