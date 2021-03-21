package edu.scu.xyl.web.shopadmin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.scu.xyl.dto.ShopExecution;
import edu.scu.xyl.entity.PersonInfo;
import edu.scu.xyl.entity.Shop;
import edu.scu.xyl.enums.ShopStateEnum;
import edu.scu.xyl.exceptions.ShopOperationException;
import edu.scu.xyl.service.ShopService;
import edu.scu.xyl.util.HttpServletRequestUtil;
import edu.scu.xyl.util.ImageUtil;
import edu.scu.xyl.util.PathUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request){
		
		Map<String, Object> modelMap = new HashMap<>();
		// 1. accept and transfer parameters
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
			shopImg = (CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "shopimg cannot be empty");
			return modelMap;
		}
		// 2. register shop
		if (shop != null && shopImg != null) {
			PersonInfo owner = new PersonInfo();
			//session TODO
			owner.setUser_id(1L);
			shop.setOwner(owner);
			
			ShopExecution se;
			try {
				se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "please enter shop information");
			return modelMap;
		}
		
		// return result
	}
	
//	private static void InputStreamToFile(InputStream ins, File file) {
//		FileOutputStream os = null;
//		try {
//			os = new FileOutputStream(file);
//			int byteRead = 0;
//			byte[] buffer = new byte[1024];
//			while ((byteRead = ins.read(buffer)) != -1) {
//				os.write(buffer, 0,byteRead);
//			}
//		} catch(Exception e) {
//			throw new RuntimeException("InputStreamToFile create failed:" + e.getMessage());
//		} finally {
//			try {
//				if (os != null)
//					os.close();
//				if (ins != null) 
//					ins.close();
//			} catch(IOException e) {
//				throw new RuntimeException("InputStreamToFile close failed:" + e.getMessage());
//			}
//		}
//	}
}
