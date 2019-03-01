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
}