package com.yc.service.car.card;

import com.yc.dto.car.card.CarCardInfoDto;
import com.yc.entity.car.card.CarCardInfoEntity;

import java.util.List;

/**
 * @Description 车修-卡会员信息service
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:40:55
 */
public interface CarCardInfoService {

    /**
     * 查询卡会员信息
     * @param correctPage 起始页
     * @param correctSize 页大小
     * @param carCardInfoDto
     * @Date 2020-11-18 14:37
     * @return List<CarCardInfoDto>
     */
    List<CarCardInfoDto> listCarCardInfo(int correctPage, int correctSize, CarCardInfoDto carCardInfoDto);

    /**
     * 查询卡会员信息总数
     * @param carCardInfoDto
     * @Date 2020-11-18 14:38
     * @return int
     */
    int countCarCardInfo(CarCardInfoDto carCardInfoDto);

    /**
     * 新增卡会员信息
     * @param carCardInfoDto
     * @Date 2020-11-18 14:39
     * @return int
     */
    void addCarCardInfo(CarCardInfoDto carCardInfoDto);

    /**
     * 修改卡会员信息
     * @param carCardInfoDto
     * @Date 2020-11-18 14:40
     * @return int
     */
    void modifyCarCardInfo(CarCardInfoDto carCardInfoDto);

    /**
     * 查询卡会员信息详情
     * @param id 编号
     * @Date 2020-11-18 14:41
     * @return CarCardInfoDto
     */
    CarCardInfoDto getCarCardInfo(Long id);

    /**
     * 删除卡会员信息
     * @param carCardInfoEntity
     * @Date 2020-11-18 14:42
     * @return void
     */
    void delCarCardInfo(CarCardInfoEntity carCardInfoEntity);
}
