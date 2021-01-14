package com.yc.service.car.card;

import com.yc.dto.car.card.CarProjectInfoDto;
import com.yc.entity.car.card.CarProjectInfoEntity;

import java.util.List;

/**
 * @Description 汽修-项目信息service
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:40:55
 */
public interface CarProjectInfoService {

    /**
     * 查询项目信息列表
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param carProjectInfoDto
     * @Date 2020-11-18 14:54
     * @return List<CarProjectInfoDto>
     */
    List<CarProjectInfoDto> listCarProjectInfo(int correctPage, int correctSize, CarProjectInfoDto carProjectInfoDto);

    /**
     * 查询项目信息总数
     * @param carProjectInfoDto
     * @Date 2020-11-18 14:55
     * @return int
     */
    int countCarProjectInfo(CarProjectInfoDto carProjectInfoDto);

    /**
     * 新增项目信息
     * @param carProjectInfoDto
     * @Date 2020-11-18 14:56
     * @return void
     */
    void addCarProjectInfo(CarProjectInfoDto carProjectInfoDto);

    /**
     * 修改项目信息
     * @param carProjectInfoDto
     * @Date 2020-11-18 14:57
     * @return void
     */
    void modifyCarProjectInfo(CarProjectInfoDto carProjectInfoDto);

    /**
     * 查询项目信息详情
     * @param id 编号
     * @Date 2020-11-18 14:58
     * @return CarProjectInfoDto
     */
    CarProjectInfoDto getCarProjectInfo(Long id);

    /**
     * 删除项目信息
     * @param carProjectInfoEntity
     * @Date 2020-11-18 14:59
     * @return void
     */
    void delCarProjectInfo(CarProjectInfoEntity carProjectInfoEntity);

    /**
     * 查询所有有限的项目
     * @Date 2021-01-13 14:34
     * @return List<CarProjectInfoEntity>
     */
    List<CarProjectInfoEntity> findAllCarProjectInfo();
}
