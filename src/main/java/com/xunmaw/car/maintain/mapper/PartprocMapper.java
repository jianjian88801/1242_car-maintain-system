package com.xunmaw.car.maintain.mapper;

import com.xunmaw.car.maintain.entity.Partproc;
import com.xunmaw.car.maintain.views.PartProcView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartprocMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Partproc record);

    int insertSelective(Partproc record);

    Partproc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Partproc record);

    int updateByPrimaryKey(Partproc record);
    
    List<PartProcView> selectPartProc(
    		@Param("keyworld") String keyworld,
    		@Param("purchstatus") String purchstatus,
    		@Param("starttime") String starttime,
    		@Param("endtime") String endtime);
    
    List<Partproc> selectProced(
    		@Param("starttime") String starttime,
    		@Param("endtime") String endtime);
}