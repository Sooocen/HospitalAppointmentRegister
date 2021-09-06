package com.xxxx.yygh.cmn.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xxxx.yygh.cmn.mapper.DictMapper;
import com.xxxx.yygh.model.cmn.Dict;
import com.xxxx.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;

/**
 * 医院端 Excel导入数据时逐行扫描
 */
public class DictListener extends AnalysisEventListener<DictEeVo> {

    DictMapper dictMapper;
    public DictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //逐行扫描
    @Override
    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
        Dict dict = new Dict();
        BeanUtils.copyProperties(dictEeVo,dict);
        dictMapper.insert(dict);
    }

    //扫描完毕后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
