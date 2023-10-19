package com.wzm.oneapicommon.service;

/**
 * Internal User Interface Information Service
 *
 * @author wzm
 */
public interface InnerUserInterfaceInfoService {

    /**
     * Call interface statistics
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
