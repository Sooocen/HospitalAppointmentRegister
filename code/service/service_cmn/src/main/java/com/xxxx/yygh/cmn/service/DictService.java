package com.xxxx.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.yygh.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  Dict服务接口
 * </p>
 *
 * @author Sooocen
 * @since 2021-08-08
 */
public interface DictService extends IService<Dict> {
    //根据id查询子数据列表
    List<Dict> findChildData(Long id);

    //导出数据字典
    void exportDict(HttpServletResponse response);

    //导入数据字典
    void importDict(MultipartFile file);
}
