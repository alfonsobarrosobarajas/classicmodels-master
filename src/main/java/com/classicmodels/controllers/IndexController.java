package com.classicmodels.controllers;

import com.classicmodels.utility.UrlConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UrlConstants.INDEX_URL)
public class IndexController {


    @GetMapping(UrlConstants.INDEX_URL)
    public String goIndex(){
        return "index";
    }
}
