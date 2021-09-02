package com.xxxx.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.yygh.model.hosp.HospitalSet;

/**
 * <p>
 *  HospitalSet服务接口
 * </p>
 *
 * @author Sooocen
 * @since 2021-08-08
 */
public interface HospitalSetService extends IService<HospitalSet> {
    //根据Id获取签名Key
    String getSignKey(String hoscode);
}
