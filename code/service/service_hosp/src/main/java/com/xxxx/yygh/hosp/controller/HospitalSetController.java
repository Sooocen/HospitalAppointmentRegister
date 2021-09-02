package com.xxxx.yygh.hosp.controller;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxxx.yygh.common.result.Result;
import com.xxxx.yygh.common.utils.MD5;
import com.xxxx.yygh.hosp.service.HospitalSetService;
import com.xxxx.yygh.model.hosp.HospitalSet;
import com.xxxx.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 *  医院设置Controller
 *
 * @author Sooocen
 * @since 2021-08-08
 */
@Api (tags = "医院设置管理Api")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@CrossOrigin
public class HospitalSetController {

    //注入Service
    @Autowired
    HospitalSetService hospitalSetService;

    //1. 查询所有信息
    @ApiOperation( value = "获取所有医院设置信息接口")
    @GetMapping("/findAll")
    public Result findAll(){
        List<HospitalSet> hospitalSets = hospitalSetService.list();
        return Result.ok(hospitalSets);
    }

    //2. 逻辑删除医院设置
    @ApiOperation( value = "逻辑删除医院设置信息接口")
    @DeleteMapping("deleteHospitalSet/{id}")
    public Result removeHospSet(@PathVariable Long id){
        boolean flag = hospitalSetService.removeById(id);
        if( flag == true){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    //3. 条件查询(含分页)
    @ApiOperation( value = "利用条件查询医院设置 含分页")
    @PostMapping("/findPage/{current}/{limit}")
    public Result findPageHospSet(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo){
        //创建一个Page对象 传递当前页 传递每页记录数
        Page<HospitalSet> page = new Page<>(current,limit);
        //构建条件
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        String hoscode = hospitalSetQueryVo.getHoscode();//医院编号
        String hosname = hospitalSetQueryVo.getHosname();//医院名称
        //条件不为空 为条件构造器添加对应条件
        if(!StringUtils.isEmpty(hoscode)){
            queryWrapper.eq("hoscode", hoscode);
        };
        if(!StringUtils.isEmpty(hosname)){
            queryWrapper.like("hosname", hosname);
        };
        //调用方法实现分页查询
        Page<HospitalSet> pageHospitalSet = hospitalSetService.page(page, queryWrapper);
        //返回分页数据
        return Result.ok(pageHospitalSet);
    }

    //4. 添加医院设置
    @ApiOperation( value = "添加医院设置")
    @PostMapping("saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet){
        //设置状态
        hospitalSet.setStatus(1);
        //设置签名密钥
        Random random =new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+ random.nextInt(1000)));
        //Service服务进行存储
        boolean save = hospitalSetService.save(hospitalSet);
        if(save){
            return Result.ok();
        }else return Result.fail();
    }

    //5. 根据ID获取医院设置
    @ApiOperation(value = "根据Id获取医院设置")
    @GetMapping("getHospitalSet/{id}")
    public Result getHospitalSet(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    //6. 修改医院设置
    @ApiOperation(value = "根据Id修改医院设置")
    @PostMapping("updateHospitalSet")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet){
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if(flag){
            return Result.ok();
        }else return Result.fail();
    }

    //7. 批量删除医院设置
    @ApiOperation(value = "批量删除医院设置")
    @DeleteMapping("BatchRemoveHospitalSet")
    public Result BatchRemoveHospitalSet(@RequestBody List<Long> idList){
        hospitalSetService.removeByIds(idList);
        return Result.ok();
    }

    //8. 医院设置锁定和解锁
    @ApiOperation( value = "锁定/解锁医院设置")
    @PutMapping("lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable Long id,
                                  @PathVariable Integer status){
        //根据id获取医院设置
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //更改医院状态
        hospitalSet.setStatus(status);
        hospitalSetService.updateById(hospitalSet);
        return Result.ok();
    }


    //9. 发送医院签名密钥
    @ApiOperation( value = "发送医院签名密钥")
    @PutMapping("sendKey/{id}")
    public Result sendKey(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String hoscode = hospitalSet.getHoscode();
        String signKey = hospitalSet.getSignKey();
        //TODO 发送短信
        return null;
    }

}
