package cc.zy.base.businesses.controller;

import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.ModuleType;
import cc.zy.base.common.entity.OssProperties;
import cc.zy.base.common.utils.OssUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * @author 第4组-文件上传
 * @date 2021-01-30 11:03:36
 */
@RestController
public class OssController {
    @Autowired
    private OssProperties ossProperties;
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public FebsResponse upload(@ApiParam(value = "文件",required = true) @RequestParam(value = "file") MultipartFile file)throws Exception{
        //module可以选择IMG_PHOTO、IMG_IDEN、IMG_CHANGE、IMG_CERTIFICATE
        String uploadUrl= OssUtil.upload(file,ossProperties,ModuleType.IMG_PHOTO.getPath());
        System.out.println("uploadUrl:"+uploadUrl);
        return new FebsResponse().success().message("文件上传成功").put("url",uploadUrl);
    }
}