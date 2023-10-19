package com.wzm.oneapicommon.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user calls interface relationship
 *
 * @author wzm
 */
@TableName(value ="user_interface_info")
@Data
public class UserInterfaceInfo implements Serializable {
    /**
     * key
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * user id
     */
    private Long userId;

    /**
     * interface id
     */
    private Long interfaceInfoId;

    /**
     * total num
     */
    private Integer totalNum;

    /**
     * left num
     */
    private Integer leftNum;

    /**
     * status 0-normal，1-Disable
     */
    private Integer status;

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