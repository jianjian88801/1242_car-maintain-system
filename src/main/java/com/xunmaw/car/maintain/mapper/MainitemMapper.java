package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Mainitem;
import com.xunmaw.car.maintain.views.MainItemView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mainitem record);

    int insertSelective(Mainitem record);

    Mainitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mainitem record);

    int updateByPrimaryKey(Mainitem record);
    
    /**
     * 通过类别的编号查询维修项目
     * @param projcategory			维修项目类别表的编号
     * @return
     */
    List<Mainitem> selectMainitembyCategory(@Param("projcategory") String projcategory);
    
    
    /**
     * 查询所有的维修项目
     * @return
     */
    List<MainItemView> selectallMainitem();
}