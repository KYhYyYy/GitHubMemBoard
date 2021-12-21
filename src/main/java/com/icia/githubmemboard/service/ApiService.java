package com.icia.githubmemboard.service;

import com.icia.githubmemboard.dao.ApiDAO;
import com.icia.githubmemboard.dto.ApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ApiService {

    private ModelAndView mav = new ModelAndView();

    @Autowired
    private ApiDAO dao;

    public ModelAndView insertMap(ApiDTO api) {
        int result = dao.insertMap(api);

        if(result>0){
            mav.setViewName("redirect:/kmap3");
        } else {
            mav.setViewName("index");
        }
        return mav;
    }

    public ModelAndView kmap3() {
        List<ApiDTO> store = dao.storeList();
        mav.addObject("store", store);
        mav.setViewName("kmap3");
        return mav;
    }

    public ModelAndView kmap4(String storeName) {
        ApiDTO store = dao.store(storeName);
        mav.addObject("store", store);
        mav.setViewName("kmap4");
        return mav;
    }
}
