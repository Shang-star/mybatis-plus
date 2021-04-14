package com.shang.sys.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shang.sys.entity.Student;
import com.shang.sys.mapper.StudentMapper;
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
public class StudentDao extends ServiceImpl<StudentMapper, Student> {

}
