package com.q.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.q.app.entity.AppUserEntity;
import com.q.app.service.AppUserService;

//要使用Controller 必须加@Controller注解也可以用@Controller("path")这里面的path相当于本Controller的根路径
//如果配置成@Controller("path"),那么访问的地址应该是：http://localhost:8080/path/test
@Controller
public class AppUserController {
	
	//和Service结合，实现数据库操作。这里是注入的Service，其实直接注入Dao也是可以的
	//TIPS：Service使用了事务，所以不要直接try catch，不然事务会失效
	@Autowired
	private AppUserService service;
	
	//获取列表
	@ResponseBody
	@RequestMapping(value = "app/user/getList", method = {
            RequestMethod.GET, RequestMethod.POST
        })
	public List<AppUserEntity> userGetList(Model model,String name) {
		List<AppUserEntity> list = service.getAll();
        return list;
    }
	
	//添加操作，添加后返回列表页面，这里为了简单演示就直接通过redirect的方式
	//真实情况应该是根据业务需求来是重定向还是直接刷新页面等
	@ResponseBody
	@RequestMapping(value = "app/user/add", method = {
            RequestMethod.GET, RequestMethod.POST
        })
	public String userAdd(Model model,AppUserEntity entity,HttpServletRequest request) {
		service.add(entity);
        return "success";
    }
}
