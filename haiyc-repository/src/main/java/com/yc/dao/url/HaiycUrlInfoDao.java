package com.yc.dao.url;

import com.yc.dto.url.HaiycUrlInfoDto;
import com.yc.entity.url.HaiycUrlInfoEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description 网址信息dao
 * @Author 村子里最好的剑
 * @Date 2020-11-16 02:22:41
 */
public interface HaiycUrlInfoDao extends Mapper<HaiycUrlInfoEntity>, MySqlMapper<HaiycUrlInfoEntity> {

    /**
     * 查询网址信息
     * @param params
     * @Date 2020-11-16 15:25
     * @return List<HaiycUrlInfoDto>
     */
    List<HaiycUrlInfoDto> queryListUrlInfo(Map params);

    /**
     * 查询网址信息总条数
     * @param params
     * @Date 2020-11-16 15:26
     * @return int
     */
    int countUrlInfo(Map params);

    /**
     * 查询网址信息详情
     * @param id 主键
     * @Date 2020-11-16 15:29
     * @return HaiycUrlInfoDto
     */
    HaiycUrlInfoDto getUrlInfo(Long id);
}
