package com.java2nb.novel.domain;

import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java2nb.common.jsonserializer.LongToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * 小说类别表
 * 
 * @author antigravity
 * @date 2026-06-01
 */
public class BookCategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Integer id;
    // 作品方向，0：男频，1：女频
    private Integer workDirection;
    // 分类名
    private String name;
    // 排序
    private Integer sort;

    @JsonSerialize(using = LongToStringSerializer.class)
    private Long createUserId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonSerialize(using = LongToStringSerializer.class)
    private Long updateUserId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setWorkDirection(Integer workDirection) {
        this.workDirection = workDirection;
    }

    public Integer getWorkDirection() {
        return workDirection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
}
