package com.xxxx.yygh.cmn.controller;

import com.xxxx.yygh.cmn.service.DictService;
import com.xxxx.yygh.common.result.Result;
import com.xxxx.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *  数据字典Controller
 *
 * @author Sooocen
 * @since 2021-08-08
 */
@Api(tags = "数据字典Api")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    DictService dictService;

    @ApiOperation( value = "根据id查询子数据列表")
    @GetMapping("/findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
        List<Dict> dicts =dictService.findChildData(id);
        return Result.ok(dicts);
    }

    @ApiOperation( value = "导入数据字典")
    @PostMapping("/importDict")
    public Result importDict(MultipartFile file) {
        dictService.importDict(file);
        return Result.ok();
    }

    @ApiOperation( value = "导出数据字典")
    @GetMapping("/exportDict")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDict(response);
    }
}
