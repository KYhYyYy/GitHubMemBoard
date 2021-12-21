package com.icia.githubmemboard.controller;

import com.icia.githubmemboard.dto.ApiDTO;
import com.icia.githubmemboard.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApiController {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private ApiService svc;

    @RequestMapping(value = "/kmap1", method = RequestMethod.GET)
    public String kmap1(){
        return "kmap1";
    }

    @RequestMapping(value = "/kmap2", method = RequestMethod.GET)
    public String kmap2(){
        return "kmap2";
    }

    // insertMap
    @RequestMapping(value = "/insertMap", method = RequestMethod.GET)
    public ModelAndView insertMap(@ModelAttribute ApiDTO api){
        mav = svc.insertMap(api);
        return mav;
    }

    // kmap3
    @RequestMapping(value = "/kmap3", method = RequestMethod.GET)
    public ModelAndView kmap3(){
        mav = svc.kmap3();
        return mav;
    }

    // kmap4
    @RequestMapping(value = "/kmap4", method = RequestMethod.GET)
    public ModelAndView kmap4(@RequestParam("storeName") String storeName){
        mav = svc.kmap4(storeName);
        return mav;
    }

}
