package edu.scu.xyl.dao;

import java.util.List;

import edu.scu.xyl.entity.Area;

public interface AreaDao {
	/**
	 * back all areas
	 * @return areaList
	 */
	List<Area> queryArea();

}
