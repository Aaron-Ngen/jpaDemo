package org.studio.own.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.studio.own.UserRepository.UserRepository;
import org.studio.own.entity.User;
import org.studio.own.service.UserService;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 18:39 2018/3/25
 */
@Service//注入成service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String name) {
        return new User(name);
    }


    @Override
    public Page<User> findUserByPage(Pageable pageInfo) {
        Page<User> list=userRepository.findAll(new PageRequest(pageInfo.getPageNumber(), pageInfo.getPageSize()));
        return list;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }
}