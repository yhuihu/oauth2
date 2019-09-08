package com.demo.oauth2.service.Impl;

import com.demo.oauth2.domain.TbContent;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.oauth2.mapper.TbContentMapper;
import com.demo.oauth2.service.TbContentService;

import java.util.List;

@Service
public class TbContentServiceImpl implements TbContentService{

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }
}
