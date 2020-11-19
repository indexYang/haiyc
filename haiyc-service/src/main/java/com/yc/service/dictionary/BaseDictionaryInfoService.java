package com.yc.service.dictionary;

import com.yc.entity.dictionary.BaseDictionaryInfoEntity;

import java.util.List;

/**
 * @Description 字典service
 * @Author 村子里最好的剑
 * @Date 2020-11-12 04:01:38
 */
public interface BaseDictionaryInfoService {

    /**
     * 查询字典类型所对应数据字典
     * @param typeCode code类型
     * @Date 2020-11-13 10:02
     * @return List<BaseDictionaryInfoEntity>
     */
    List<BaseDictionaryInfoEntity> queryDictionaryType(String typeCode);
}
