package edu.scu.xyl.service;

import java.io.File;

import edu.scu.xyl.dto.ShopExecution;
import edu.scu.xyl.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop, File shopImg);

}
