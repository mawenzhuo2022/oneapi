package com.wzm.oneapicommon.service;

import com.wzm.oneapicommon.model.entity.User;


/**
 * Internal user services
 *
 * @author wzm
 */
public interface InnerUserService {

    /**
     * Check in the database whether the key has been assigned to the user（accessKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
