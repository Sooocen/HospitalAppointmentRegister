package com.xxxx.yygh.cmn.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.yygh.cmn.listener.DictListener;
import com.xxxx.yygh.cmn.mapper.DictMapper;
import com.xxxx.yygh.cmn.service.DictService;
import com.xxxx.yygh.model.cmn.Dict;
import com.xxxx.yygh.model.hosp.HospitalSet;
import com.xxxx.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Dict服务实现类
 * </p>
 *
 * @author Sooocen
 * @since 2021-08-08
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    //根据id查询子数据列表
    public List<Dict> findChildData(Long id) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        List<Dict> dicts = baseMapper.selectList(queryWrapper);
        //为集合中的每个实体添加hasChild属性
        for(Dict dict:dicts){
            boolean hasChildren = this.hasChildren(dict.getId());
            dict.setHasChildren(hasChildren);
        }
        return dicts;
    }

    //判断是否有子节点
    public boolean hasChildren(Long id){
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count>0;
    }

    //导入数据字典
    @Override
    public void importDict(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(),DictEeVo.class,new DictListener(baseMapper)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //导出数据字典
    @Override
    public void exportDict(HttpServletResponse response) {
        //设置下载信息
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        try {
            String FileName= URLEncoder.encode("数据字典","UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+ FileName + ".xlsx");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //查询数据字典
        List<Dict> dictList = baseMapper.selectList(null);
        //Dict -> DictEeVo对象转换
        List<DictEeVo> dictEeVoList = new ArrayList<>();
        for(Dict dict:dictList){
            DictEeVo dictEeVo = new DictEeVo();
            //将dict转换成Vo 封装了dictEeVo.setId(dict.getId());等语句
            BeanUtils.copyProperties(dict,dictEeVo);
            dictEeVoList.add(dictEeVo);
        }
        try {
            EasyExcel.write(response.getOutputStream(), DictEeVo.class).sheet("dict").doWrite(dictEeVoList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
