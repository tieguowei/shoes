package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.ZlyShoeBrand;
import com.hzcf.shoes.model.ZlyShoeBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZlyShoeBrandMapper {
    int countByExample(ZlyShoeBrandExample example);

    int deleteByExample(ZlyShoeBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZlyShoeBrand record);

    int insertSelective(ZlyShoeBrand record);

    List<ZlyShoeBrand> selectByExample(ZlyShoeBrandExample example);

    ZlyShoeBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZlyShoeBrand record, @Param("example") ZlyShoeBrandExample example);

    int updateByExample(@Param("record") ZlyShoeBrand record, @Param("example") ZlyShoeBrandExample example);

    int updateByPrimaryKeySelective(ZlyShoeBrand record);

    int updateByPrimaryKey(ZlyShoeBrand record);
    
    /**
	 * 查询鞋厂的所有货号
	 * @param id
	 * @return
	 */
	List<ZlyShoeBrand> getBrandListById(Integer id);
	 /**
		 * 删除鞋厂的所有货号
		 * @param id
		 * @return
		 */
	void delBrandByFactoryId(Integer id);
}