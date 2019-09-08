package com.demo.oauth2.controller;

import com.demo.oauth2.domain.TbContent;
import com.demo.oauth2.dto.ResponseResult;
import com.demo.oauth2.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @GetMapping("content")
    public ResponseResult<List<TbContent>> getContent(){
        return new ResponseResult<List<TbContent>>(HttpStatus.OK.value(),tbContentService.selectAll());
    }
}
