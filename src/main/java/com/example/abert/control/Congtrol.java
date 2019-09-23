package com.example.abert.control;

import com.example.abert.entity.User;
import com.example.abert.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class Congtrol
{
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public String index()
    {
        return "user/main" ;                                                 //重定向到主页面
    }

    //点击登陆按钮 跳转成功或失败
    @RequestMapping(value = "/deng",method = RequestMethod.POST)
    @ResponseBody
    public String  login(String name, int score)
    {

        User tab=userService.findUserByName(name);
        if(tab.getScore()==score)
        {
            return "登陆成功";
        }else{
            return "登陆失败";
        }
    }

//    点击注册按钮，转到注册页面
    @RequestMapping(value = "/zhu",method = RequestMethod.POST)
    public String zhu()
    {
        return "user/zhuce";
    }


//展示界面
    @RequestMapping("/lis")
    public String lsit(ModelMap map)
    {
        List<User> users = userService.getUserList();
        map.addAttribute("users",users);
        return "user/list";
    }
    @RequestMapping("/toadd")
    public String toadd()
    {
        return "user/add";
    }

    @RequestMapping("/add")
    public String add(User user)
    {
        userService.save(user);
        return "redirect:/list";//添加完成，请求重定向到/list
    }


    //编辑用户资料
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit"; //跳转到userEdit.html页面
    }
    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/lis";                                                                 //获取列表数据并显示
    }


    @RequestMapping("/delete")
    public String edit(Long id){
        userService.delete(id);
        return "redirect:/lis";                 //跳到管理展示页面
    }
    //转到管理员登陆页面
    @RequestMapping("/toguan")
    public String toguan()
    {
        return "user/guanli";
    }
    //验证是否为管理成员
    @RequestMapping("/guanl")
    public String  guanli(String name, int score)
    {
        if(name.equals("aaa")&&score==12345)
        {
            return "redirect:/lis";                                         //跳到管理界面
        }else{
            return "redirect:/toguan";
        }
    }



    //注册数据提交后，转到此处
    @RequestMapping(value = "/zhs",method = RequestMethod.POST)
    @ResponseBody
    public String zh(String name,String sex,int age,int score)
    {
        User user=new User(name,sex,age,score);
        userService.save(user);
        return "注册成功";

    }





}
