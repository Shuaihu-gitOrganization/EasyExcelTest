package com.atxiaohu.vip.controller;

import com.atxiaohu.vip.pojo.User;
import com.atxiaohu.vip.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

/**
 * @Date 2023/4/21
 * @Author XiaoHu
 * @Description
 **/
@RestController
@Controller
@RequestMapping("/User")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/insertUser/{id}/{name}/{passwd}/{status}")
    int insertUser(@PathVariable("id")BigInteger id,
                   @PathVariable("name")String name,
                   @PathVariable("passwd")String passwd,
                   @PathVariable("status")Integer status){
        User user = User.builder().build();
        user.setId(id);
        user.setName(name);
        user.setPassword(passwd);
        user.setStatus(status);
        System.out.println(user);
        return userService.insertUser(user);
    }
    @RequestMapping("/updateUser/{name}/{passwd}/{status}/{bid}")
    int insertUser(@PathVariable("name")String name,
                   @PathVariable("passwd")String passwd,
                   @PathVariable("status")Integer status,@PathVariable("bid")BigInteger bid){

        User user = User.builder().build();
        user.setName(name);
        user.setPassword(passwd);
        user.setStatus(status);
        user.setId(bid);
        System.out.println(user);
        return userService.updateUser(user);
    }
    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

}
