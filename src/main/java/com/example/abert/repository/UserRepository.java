package com.example.abert.repository;

import com.example.abert.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>
{
    //查询用户的所有信息
//    List<User> findAll();

    //查询一个人的信息
    User findByName(String name);
    //增添一个人的注册信息
    //修改个人人信息
    //删除个人信息
//    void deleteByName(String name);
//
//    //查询
//    User findByNameAndScore(String name, int score);*/
/*
   User findById(long id);
    void deleteById(Long id);
*/


}
