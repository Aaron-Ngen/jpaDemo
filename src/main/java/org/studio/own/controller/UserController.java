package org.studio.own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.studio.own.entity.User;
import org.studio.own.service.UserService;

import java.util.Date;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 18:29 2018/3/25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired // 依赖注入service
            UserService userService;

    @RequestMapping(value = "/findUserByPage")
    @ResponseBody
    public Page<User> getStudents(Pageable pageInfo) {
        return userService.findUserByPage(pageInfo);
    }

    @RequestMapping("/getUserById")
    protected User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/deleteUser")
    protected void deleteUser(Long id) {
        User user = new User();
        user.setId(id);
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/addUser")
    protected User addUser(User user) {
        if (user.getId() != null && user.getId() != 0) {
            return userService.updateUser(user);
        } else {
            user.setRegestDate(new Date());
            return userService.addUser(user);
        }
    }
}