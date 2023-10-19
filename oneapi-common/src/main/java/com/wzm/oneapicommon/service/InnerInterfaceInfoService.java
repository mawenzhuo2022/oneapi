package com.wzm.oneapicommon.service;

import com.wzm.oneapicommon.model.entity.InterfaceInfo;

/**
 * internal interface information service
 *
 * @author wzm
 */
public interface InnerInterfaceInfoService {

    /**
     * whether the simulation interface exists from the database (request path, request method, request parameters)
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
