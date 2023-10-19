package com.wzm.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzm.oneapicommon.model.entity.InterfaceInfo;

/**
 * 接口信息服务
 *
 * @author wzm
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
