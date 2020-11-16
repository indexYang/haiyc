package com.yc.service.url;

import com.yc.dto.url.HaiycUrlInfoDto;
import com.yc.entity.url.HaiycUrlInfoEntity;

import java.util.List;

/**
 * @Description 网址信息service
 * @Author 村子里最好的剑
 * @Date 2020-11-16 02:22:53
 */
public interface HaiycUrlInfoService {

    /**
     * 查询网址信息
     * @param correctPage 当前页
     * @param correctSize 页大小
     * @param haiycUrlInfoDto
     * @Date 2020-11-16 15:25
     * @return PagerWrapper<HaiycUrlInfoDto>
     */
    List<HaiycUrlInfoDto> queryListUrlInfo(int correctPage, int correctSize, HaiycUrlInfoDto haiycUrlInfoDto);

    /**
     * 查询网址信息总条数
     * @param haiycUrlInfoDto
     * @Date 2020-11-16 15:26
     * @return int
     */
    int countUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto);

    /**
     * 新增网址信息
     * @param haiycUrlInfoDto
     * @Date 2020-11-16 15:27
     * @return int
     */
    void addUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto);

    /**
     * 修改网址信息
     * @param haiycUrlInfoDto
     * @Date 2020-11-16 15:28
     * @return void
     */
    void modifyUrlInfo(HaiycUrlInfoDto haiycUrlInfoDto);

    /**
     * 查询网址信息详情
     * @param id 主键
     * @Date 2020-11-16 15:29
     * @return HaiycUrlInfoDto
     */
    HaiycUrlInfoDto getUrlInfo(Long id);

    /**
     * 查询网址信息总条数
     * @param haiycUrlInfoEntity
     * @Date 2020-11-16 15:30
     * @return void
     */
    void delUrlInfo(HaiycUrlInfoEntity haiycUrlInfoEntity);
}
