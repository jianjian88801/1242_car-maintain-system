package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Qualityinspec;
import com.xunmaw.car.maintain.views.QualityView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityinspecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qualityinspec record);

    int insertSelective(Qualityinspec record);

    Qualityinspec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qualityinspec record);

    int updateByPrimaryKey(Qualityinspec record);
    
    /*查询待质检的消息纪录*/
    List<QualityView> selectZhiJian(
    		@Param("keyworld") String keyworld,
    		@Param("starttime") String starttime,
    		@Param("endtime") String endtime,
    		@Param("bustatusid") String bustatusid,
    		@Param("userinfoid") String userinfoid);
}