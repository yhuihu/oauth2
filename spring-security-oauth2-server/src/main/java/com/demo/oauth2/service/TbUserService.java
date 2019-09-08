package com.demo.oauth2.service;

import com.demo.oauth2.domain.TbUser;

public interface TbUserService{
    TbUser getByUsername(String username);

}
