package com.demo.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api
@Controller
public class UserController {
    @ApiOperation(
            value = "打招呼",
            httpMethod = "GET",
            produces = "text/plain"
    )
    @GetMapping("hello")
    @ResponseBody
    public String hello(
            @ApiParam(name = "name",value = "名字", required = true)
            @RequestParam("name") String name) {
        return "Hello " + name + "!";
    }
}
