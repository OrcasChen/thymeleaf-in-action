package com.orcas.spring.boot.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.orcas.spring.boot.thymeleaf.domain.User;
import com.orcas.spring.boot.thymeleaf.repository.IUserRepository;

/**
 * 
 * @author xcw
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserRepository iUserRepository;
	
	/**
	 * 查询所有用户列表
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList",iUserRepository.listUsers());
		model.addAttribute("title","用户管理");
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id,Model model) {
		User user = iUserRepository.getUserById(id);
		model.addAttribute("user",user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * 获取创建表单的页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form","userModel",model);
	}
	
	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		user = iUserRepository.saveOrUpadateUser(user);
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		iUserRepository.deleteUser(id);
		return new ModelAndView("redirect:/users");
	}
	
	/**
	 * 获取修改用户的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id,Model model) {
		User user = iUserRepository.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form","userModel",model);
	}
	
	
}
