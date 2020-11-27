package com.yc.dao.car.card;

import com.yc.dto.car.card.CarCardInfoDto;
import com.yc.entity.car.card.CarCardInfoEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 车修-卡会员信息dao
 * @Author 村子里最好的剑
 * @Date 2020-11-18 11:40:39
 */
public interface CarCardInfoDao extends Mapper<CarCardInfoEntity>, MySqlMapper<CarCardInfoEntity> {

    /**
     * 查询卡会员信息列表
     * @param params
     * @Date 2020-11-18 14:37
     * @return List<CarCardInfoDto>
     */
    List<CarCardInfoDto> listCarCardInfo(Map params);

    /**
     * 查询卡会员信息总数
     * @param params
     * @Date 2020-11-18 14:38
     * @return int
     */
    int countCarCardInfo(Map params);

    /**
     * 校验卡号是否已经存在
     * @param id 编号
     * @param cardNo 卡号
     * @Date 2020-11-18 14:39
     * @return CarCardInfoEntity
     */
    CarCardInfoEntity findCardNo(Long id, String cardNo);

    /**
     * 校验手机号码是否已经存在
     * @param id 编号
     * @param phone 手机号码
     * @Date 2020-11-18 14:40
     * @return CarCardInfoEntity
     */
    CarCardInfoEntity findPhone(Long id, String phone);

    /**
     * 查询卡会员详情
     * @param id 编号
     * @Date 2020-11-18 14:41
     * @return CarCardInfoDto
     */
    CarCardInfoDto getCarCardInfo(Long id);
}
