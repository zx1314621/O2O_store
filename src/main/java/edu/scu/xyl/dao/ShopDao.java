package edu.scu.xyl.dao;

import edu.scu.xyl.entity.Shop;

public interface ShopDao {
	/*
	 * add shop
	 * positive means insert rows
	 * -1 means insert fail
	 */
	int insertShop(Shop shop);
	
	
	/*
	 * 
	 * update shop
	 */
	int updateShop(Shop shop);

}
