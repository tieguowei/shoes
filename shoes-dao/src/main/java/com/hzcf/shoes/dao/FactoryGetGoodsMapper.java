package com.hzcf.shoes.dao;

import com.hzcf.shoes.model.FactoryGetGoods;
import com.hzcf.shoes.model.FactoryGetGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface FactoryGetGoodsMapper {
    int countByExample(FactoryGetGoodsExample example);

    int deleteByExample(FactoryGetGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FactoryGetGoods record);

    int insertSelective(FactoryGetGoods record);

    List<FactoryGetGoods> selectByExample(FactoryGetGoodsExample example);

    FactoryGetGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactoryGetGoods record, @Param("example") FactoryGetGoodsExample example);

    int updateByExample(@Param("record") FactoryGetGoods record, @Param("example") FactoryGetGoodsExample example);

    int updateByPrimaryKeySelective(FactoryGetGoods record);

    int updateByPrimaryKey(FactoryGetGoods record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	Map<String, Object> selectById(Integer id);
}