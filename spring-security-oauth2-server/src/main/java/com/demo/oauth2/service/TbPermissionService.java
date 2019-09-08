package com.demo.oauth2.service;

import com.demo.oauth2.domain.TbPermission;

import java.util.List;

public interface TbPermissionService {
    List<TbPermission> selectByUserId(Long id);
}
