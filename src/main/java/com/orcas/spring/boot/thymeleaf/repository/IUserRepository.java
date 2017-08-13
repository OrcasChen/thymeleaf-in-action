package com.orcas.spring.boot.thymeleaf.repository;
/**
 * 
 * @author xcw
 *
 */

import java.util.List;

import com.orcas.spring.boot.thymeleaf.domain.User;

public interface IUserRepository {
	/**
	 * 创建或修改用户
	 * @param user
	 * @return
	 */
	User saveOrUpadateUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void deleteUser(Long id);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> listUsers();
}
