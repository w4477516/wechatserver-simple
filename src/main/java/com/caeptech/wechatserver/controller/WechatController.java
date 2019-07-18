package com.caeptech.wechatserver.controller;

import com.caeptech.wechatserver.impl.CustomWechat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WechatController {
    @RequestMapping(value="/wx", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomWechat myWechat = new CustomWechat(request);
        String result = myWechat.executeGet();
        response.getOutputStream().write(result.getBytes());
    }

    @RequestMapping(value="/wx", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomWechat myWechat = new CustomWechat(request);
        String result = myWechat.executePost();
        response.getOutputStream().write(result.getBytes());
    }
}
