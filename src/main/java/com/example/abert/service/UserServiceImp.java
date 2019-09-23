package com.example.abert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.abert.entity.User;
import com.example.abert.repository.UserRepository;


import java.util.List;
@Service
public class UserServiceImp implements UserService
{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }



//    @Override
//    public User findUserByName(String name)
//    {
//        return userRepository.findByName(name);
//    }
//    public User findUserByNameAndScore(String name, int score)
//    {
//        return userRepository.findByNameAndScore(name,score);
//    }






}
