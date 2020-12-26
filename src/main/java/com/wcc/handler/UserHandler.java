package com.wcc.handler;

import com.wcc.beans.User;
import com.wcc.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("login")
public class UserHandler {
    private IUserService userService;

    @RequestMapping("/first")
    public String doFirst(String username, String password, Model model, HttpSession session) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (IUserService) ac.getBean("userService");
            User user =userService.queryUser(username,password);
            if(user!=null){
                session.setAttribute("username", user.getUsername());
                session.setAttribute("user",user);
               return "admin";
            }else{
                session.setAttribute("error1","账号或密码输入错误");
            }
        return "forward:/index.jsp";
    }
    @RequestMapping("/register")
    public String doRegister(User user, Model model, HttpSession session) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (IUserService) ac.getBean("userService");
        System.out.println("注册用户接受到的数据"+user);
        //添加用户
        userService.addUser(user);

        return "forward:/index.jsp";
    }
    @RequestMapping("/update")
    public String doUpdate(@RequestParam Map<String,Object> map, Model model, HttpSession session) throws Exception {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (IUserService) ac.getBean("userService");

        String oldpassword = (String) map.get("oldPassword");
        String newPassword = (String) map.get("newPassword");
        String rpassword = (String) map.get("rPassword");
        System.out.println("注册用户接受到的数据"+oldpassword+" "+newPassword+" "+" "+rpassword);
        User user = new User();
        User user1= (User) session.getAttribute("user");
        user.setUsername(user1.getUsername());
        user.setPassword(newPassword);
        //修改密码
        userService.updateUser(user);

        return "forward:/index.jsp";
    }
    @RequestMapping("/quit")
    public String doQuit(HttpSession session) throws Exception {
            session.removeAttribute("user");
        return "forward:/index.jsp";
    }
    @RequestMapping("/preupdatepassage")
    public ModelAndView doprepassage(Model model, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        request.setAttribute("mainPage", "/jsp1/update_password.jsp");
        //设置响应视图
        mv.setViewName("admin");
        return mv;
    }
}
