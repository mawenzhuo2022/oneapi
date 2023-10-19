package com.wzm.oneapicommon.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user view
 *
 * @author wzm
 */
@Data
public class UserVO implements Serializable {
    /**
     * id
     */
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
     * createTime
     */
    private Date createTime;

    /**
     * updateTime
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}