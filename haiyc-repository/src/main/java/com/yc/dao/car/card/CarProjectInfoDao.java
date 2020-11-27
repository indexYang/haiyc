package com.yc.dao.car.card;

import com.yc.dto.car.card.CarProjectInfoDto;
import com.yc.entity.car.card.CarProjectInfoEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 汽修-项目信息dao
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:40:39
 */
public interface CarProjectInfoDao extends Mapper<CarProjectInfoEntity>, MySqlMapper<CarProjectInfoEntity> {

    /**
     * 查询项目信息列表
     * @param params
     * @Date 2020-11-18 14:54
     * @return List<CarProjectInfoDto>
     */
    List<CarProjectInfoDto> listCarProjectInfo(Map params);

    /**
     * 查询项目信息总数
     * @param params
     * @Date 2020-11-18 14:55
     * @return int
     */
    int countCarProjectInfo(Map params);

    /**
     * 查询项目名是否已经存在
     * @param id 主键
     * @param projectName 项目名
     * @Date 2020-11-18 14:56
     * @return CarProjectInfoEntity
     */
    CarProjectInfoEntity findProjectName(Long id, String projectName);

    /**
     * 查询项目信息详情
     * @param id 主键
     * @Date 2020-11-18 14:58
     * @return CarProjectInfoDto
     */
    CarProjectInfoDto getCarProjectInfo(Long id);
}
