package edu.scu.xyl.service;

import java.io.File;
import java.io.InputStream;

import edu.scu.xyl.dto.ShopExecution;
import edu.scu.xyl.entity.Shop;
import edu.scu.xyl.exceptions.ShopOperationException;

public interface ShopService {
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

}
