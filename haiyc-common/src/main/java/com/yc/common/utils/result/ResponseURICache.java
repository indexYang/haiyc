package com.yc.common.utils.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description url缓存器
 * @Author 村子里最好的剑
 * @Date 2020-10-30 15:27
 */
public class ResponseURICache {

    //缓存map
    private Map<String, Boolean> cacheMap = new HashMap<String, Boolean>();

    //禁止指令重排优化
    private static volatile ResponseURICache URICACHE;

    private ResponseURICache(){}

    public static ResponseURICache getInstance(){
        if(null == URICACHE){
            synchronized(ResponseURICache.class){
                if(null == URICACHE){
                    URICACHE = new ResponseURICache();
                }
            }
        }
        return URICACHE;
    }

    /**
     *  设置缓存值
     * @param key
     * @param value
     */
    public void set(String key, Boolean value) {
        cacheMap.put(key, value);
    }

    /**
     *  获取缓存key的value值
     * @param key
     * @return
     */
    public Boolean get(String key) {
        if (!cacheMap.containsKey(key)) {
            return false;
        }
        return cacheMap.get(key);
    }
}

