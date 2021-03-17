package edu.scu.xyl.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.scu.xyl.dao.ShopDao;
import edu.scu.xyl.dto.ShopExecution;
import edu.scu.xyl.entity.Shop;
import edu.scu.xyl.enums.ShopStateEnum;
import edu.scu.xyl.exceptions.ShopOperationException;
import edu.scu.xyl.service.ShopService;
import edu.scu.xyl.util.ImageUtil;
import edu.scu.xyl.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDao shopDao;
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, File shopImg) {
		// input justify
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// default value
			// 0 is in review
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastUpdateTime(new Date());
			// insert shop to database
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new ShopOperationException("shop create failed");
			} else {
				if (shopImg != null) {
					// store Image
					try {
						addShopImg(shop, shopImg);
					}catch (Exception e) {
						throw new ShopOperationException("addShopImg error" + e.getMessage());
					}
					
					// update shopImage address
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("update shopImg address failed");
					}
				}
			}
			
		} catch(Exception e) {
			throw new ShopOperationException("addShop error" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}
	private void addShopImg(Shop shop, File shopImg) {
		// get shop image directory relative path
		String dest = PathUtil.getShopImagePath(shop.getShop_id());
		String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
		shop.setShopImg(shopImgAddr);
	}

}
