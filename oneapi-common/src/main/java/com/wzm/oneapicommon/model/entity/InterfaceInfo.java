package com.wzm.oneapicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * interface info
 *
 * @author wzm
 */
@TableName(value ="interface_info")
@Data
public class InterfaceInfo implements Serializable {
    /**
     * key
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * interface url
     */
    private String url;

    /**
     * request parameter
     * [
     *   {"name": "username", "type": "string"}
     * ]
     */
    private String requestParams;

    /**
     * request header
     */
    private String requestHeader;

    /**
     * response header
     */
    private String responseHeader;

    /**
     * interface status（0-off，1-on）
     */
    private Integer status;

    /**
     * request type
     */
    private String method;

    /**
     * creator
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
     * is delete(0-no, 1-yes)
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}