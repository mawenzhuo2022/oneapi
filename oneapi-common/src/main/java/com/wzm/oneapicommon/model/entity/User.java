package com.wzm.oneapicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 *
 * @author wzm
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * userName
     */
    private String userName;

    /**
     * userAccount
     */
    private String userAccount;

    /**
     * userAvatar
     */
    private String userAvatar;

    /**
     * gender
     */
    private Integer gender;

    /**
     * userRole: user, admin
     */
    private String userRole;

    /**
     * userPassword
     */
    private String userPassword;

    /**
     * sign accessKey
     */
    private String accessKey;

    /**
     * sign secretKey
     */
    private String secretKey;

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * isDelete
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}