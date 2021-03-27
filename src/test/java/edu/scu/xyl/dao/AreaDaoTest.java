package edu.scu.xyl.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.scu.xyl.BaseTest;
import edu.scu.xyl.entity.Area;

public class AreaDaoTest extends BaseTest{
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		System.out.print(areaList.get(0).getArea_name());
		assertEquals(2, areaList.size());
	}
}
