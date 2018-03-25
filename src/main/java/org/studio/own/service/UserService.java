package org.studio.own.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.studio.own.entity.User;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 18:38 2018/3/25
 */
public interface UserService {

    public User getUser(String name);

    public Page<User> findUserByPage(Pageable pageInfo);

    public User getUserById(Long id);

    public User updateUser(User user);

    public void deleteUser(User user);

    public User addUser(User user);
}