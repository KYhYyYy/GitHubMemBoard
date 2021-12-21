package com.icia.githubmemboard.controller;

import com.icia.githubmemboard.dto.SecuDTO;
import com.icia.githubmemboard.service.SecuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecuController {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private SecuService svc;

    // 가입
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ModelAndView secuJoin(@ModelAttribute SecuDTO secu){
        mav = svc.secuJoin(secu);
        return mav;
    }

    // 로그인
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView secuLogin(@ModelAttribute SecuDTO secu){
        mav = svc.secuLogin(secu);
        return mav;
    }

}
