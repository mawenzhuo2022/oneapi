package com.wzm.oneapicommon.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.wzm.oneapicommon.model.entity.Post;

/**
 * post view
 *
 * @author wzm
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostVO extends Post {

    /**
     * whether has thumb
     */
    private Boolean hasThumb;

    private static final long serialVersionUID = 1L;
}