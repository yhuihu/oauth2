package com.demo.oauth2.service.Impl;

import com.demo.oauth2.domain.TbPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.demo.oauth2.mapper.TbPermissionMapper;
import com.demo.oauth2.service.TbPermissionService;

import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService{

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long id) {
        return tbPermissionMapper.selectByUserId(id);
    }
}
