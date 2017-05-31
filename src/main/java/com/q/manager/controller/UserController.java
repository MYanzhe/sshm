package com.q.manager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.q.manager.entity.User;
import com.q.manager.service.UserService;

//要使用Controller 必须加@Controller注解也可以用@Controller("path")这里面的path相当于本Controller的根路径
//如果配置成@Controller("path"),那么访问的地址应该是：http://localhost:8080/path/test
@Controller
public class UserController {

	// 和Service结合，实现数据库操作。这里是注入的Service，其实直接注入Dao也是可以的
	// TIPS：Service使用了事务，所以不要直接try catch，不然事务会失效
	@Autowired
	private UserService service;

	// 映射JSP测试
	@RequestMapping(value = "manager", method = { RequestMethod.GET, RequestMethod.POST })
	public String manager(Model model, String name) {
		model.addAttribute("name", name);
		return "index";
	}

	// 添加操作，添加后返回列表页面，这里为了简单演示就直接通过redirect的方式
	// 真实情况应该是根据业务需求来是重定向还是直接刷新页面等
	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	public String testGetAll(Model model, User entity) {
				
		User user = service.login(entity);
		if (user != null) {
			return "redirect:/main";
		}
		model.addAttribute("name", "loginError");
		return "index";
	}

	@RequestMapping(value = "main", method = { RequestMethod.GET, RequestMethod.POST })
	public String main(Model model, String name) {
		return "main";
	}

	// 获取列表
	@ResponseBody
	@RequestMapping(value = "manager/user/getList", method = { RequestMethod.GET, RequestMethod.POST })
	public List<User> userGetList(Model model, String name) {
		List<User> list = service.getAll();
		return list;
	}

	// 添加操作，添加后返回列表页面，这里为了简单演示就直接通过redirect的方式
	// 真实情况应该是根据业务需求来是重定向还是直接刷新页面等
	@ResponseBody
	@RequestMapping(value = "manager/user/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAdd(Model model, User entity, HttpServletRequest request) {
		service.add(entity);
		return "success";
	}
}
