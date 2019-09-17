package com.interceptor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {


	@RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() throws Exception {
        return "PONG";
    }

}
