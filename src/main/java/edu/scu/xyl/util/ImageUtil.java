package edu.scu.xyl.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random rd = new Random();
	private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
	
	// transfer CommonsMultipartFile to File
	public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
		File newFile = new File(cFile.getOriginalFilename());
		try {
			cFile.transferTo(newFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.toString());
			e.printStackTrace();
		} 
		return newFile;
	}
	/**
	 * Processing thumbnails, return the relative path of the new image
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String generateThumbnail(/*CommonsMultipartFile*/File thumbnail, String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbnail);
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("current relativeAddr is:" + relativeAddr);
		logger.debug("current completeAddr is:" + PathUtil.getImgBasePath() + relativeAddr);
		try {
			//Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
			Thumbnails.of(thumbnail).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
			throw new RuntimeException("create Thumbnails failed" + e.toString());
		}
		return relativeAddr;
	}

	/**
	 * create image relative folder
	 * if target path is  /Users/dylan/Desktop/coding/xxx.jpg
	 * we create Users,dylan,desktop,coding folders
	 * @param args
	 * @throws IOException
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
	}

	/**
	 * year + month + day + hour + minutes + second + five random digits
	 * 
	 * @return
	 */
	private static String getRandomFileName() {
		// guarantee five digits
		int rannum = rd.nextInt(90000) + 10000;
		String nowTimeStr = sDateFormat.format(new Date());
		
		return nowTimeStr + rannum;
		
	}
	
	private static String getFileExtension(/*CommonsMultipartFile*/File cFile) {
//		String originalFileName = cFile.getOriginalFilename();
		String originalFileName = cFile.getName();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}

	public static void main(String[] args) throws IOException {
		Thumbnails.of(new File("/Users/dylan/Desktop/coding/TestLeetCode/image/yosemite.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("/Users/dylan/Desktop/test.jpg");

	}
}
