package org.studio.own.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studio.own.entity.User;

/**
 * @Author: Yuan Baiyu
 * @Date: Created in 18:28 2018/3/25
 */

public interface UserRepository extends JpaRepository<User,Long> {
}