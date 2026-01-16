package com.chuanlong.shenai.controller;

import com.chuanlong.shenai.common.BaseResponse;
import com.chuanlong.shenai.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public BaseResponse<String> testCheck() {
        return ResultUtils.success("ok");
    }
}