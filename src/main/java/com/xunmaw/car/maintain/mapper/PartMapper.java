package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Part;
import com.xunmaw.car.maintain.views.PartsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Part record);

    int insertSelective(Part record);

    Part selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);
    
    /**
     * 通过关键字查询零件的信息
     * @param keyworld
     * @return
     */
    List<PartsInfo> selectParts(@Param("keyworld") String keyworld);
}