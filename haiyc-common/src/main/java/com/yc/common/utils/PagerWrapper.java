package com.yc.common.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * @Description 翻页包封装
 * @Author 村子里最好的剑
 * @Date 2020-10-29 17:10
 */
@Getter
@Setter
public class PagerWrapper<T> {

    @ApiModelProperty(value = "实际返回结果list")
    private Collection<T> list;

    @ApiModelProperty(value = "总条数")
    private int totalCnt;

    @ApiModelProperty(value = "当前页码")
    private int page;

    @ApiModelProperty(value = "每页大小")
    private int size;

    @ApiModelProperty(value = "翻页最大尺寸")
    private static final int MAX_SIZE = 1000;

    public PagerWrapper() {
        this.list = Collections.emptyList();
    }

    public static <T> PagerWrapper<T> create() {
        return new PagerWrapper<T>();
    }

    public static <T> PagerWrapper<T> create(Collection<T> list, int pageNo, int pageSize) {
        PagerWrapper<T> t = new PagerWrapper<T>();
        t.setList(list);
        t.setPage(pageNo);
        t.setSize(pageSize);
        return t;
    }

    public PagerWrapper<T> putTotalCnt(int totalCnt){
        this.totalCnt =  totalCnt;
        return this;
    }

    public void setList(Collection<T> list) {
        this.list = list;
    }

    /**
     * 修正页数参数
     * @param page page
     * @return 修正后的值 1-MAX
     */
    public static int correctPage(int page) {
        if (page < 1) {
            return 1;
        }
        return page;
    }

    /**
     * 修正每页数量参数
     * @param size size
     * @return 修正后的值 1-MAX_SIZE
     */
    public static int correctSize(int size) {
        if (size < 1) {
            return 1;
        }
        if (size > MAX_SIZE) {
            return MAX_SIZE;
        }
        return size;
    }

    /**
     * 修正页数参数
     *
     * @param page page
     * @return 修正后的值 1-MAX
     */
    public static int correctStart(int page, int size) {
        return (page - 1) * size;
    }

}

