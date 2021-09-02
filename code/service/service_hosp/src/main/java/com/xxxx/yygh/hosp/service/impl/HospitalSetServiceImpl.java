package com.xxxx.yygh.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.yygh.hosp.mapper.HospitalSetMapper;
import com.xxxx.yygh.hosp.service.HospitalSetService;
import com.xxxx.yygh.model.hosp.HospitalSet;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  HospitalSet服务实现类
 * </p>
 *
 * @author Sooocen
 * @since 2021-08-08
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Override
    public String getSignKey(String hoscode) {
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("hoscode",hoscode);
        HospitalSet hospitalSet = baseMapper.selectOne(queryWrapper);
        return hospitalSet.getSignKey();
    }
}
