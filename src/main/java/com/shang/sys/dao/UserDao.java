package com.shang.sys.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.sys.entity.User;
import com.shang.sys.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
* @author shang
* @since 2021-04-14
*/
@Repository
@Slf4j
@AllArgsConstructor
public class UserDao extends ServiceImpl<UserMapper, User> {

}
