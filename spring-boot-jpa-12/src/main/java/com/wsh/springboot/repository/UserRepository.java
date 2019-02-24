package com.wsh.springboot.repository;

import com.wsh.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author jue
 * @date 2019/2/24 16:19
 * @describe
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
