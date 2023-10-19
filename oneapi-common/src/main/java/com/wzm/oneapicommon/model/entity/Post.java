package com.wzm.oneapicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * post
 *
 * @author wzm
 */
@TableName(value = "post")
@Data
public class Post implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * age
     */
    private Integer age;

    /**
     * gender（0-male, 1-female）
     */
    private Integer gender;

    /**
     * education
     */
    private String education;

    /**
     * place
     */
    private String place;

    /**
     * job
     */
    private String job;

    /**
     * contact
     */
    private String contact;

    /**
     * loveExp
     */
    private String loveExp;

    /**
     * content
     */
    private String content;

    /**
     * photo
     */
    private String photo;

    /**
     * status（0-pending review, 1-pass, 2-refuse）
     */
    private Integer reviewStatus;

    /**
     * review message
     */
    private String reviewMessage;

    /**
     * view num
     */
    private Integer viewNum;

    /**
     * thumb num
     */
    private Integer thumbNum;

    /**
     * create user id
     */
    private Long userId;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * is delete
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}