package com.southwind.controller;

import com.southwind.entity.Student;
import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/index")
public class IndexHandler {

    @GetMapping("/index")
   public String index1111(Model model) {
        System.out.println("/index.....");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "aa1", 11));
        students.add(new Student(2L, "aa2", 12));
        students.add(new Student(3L, "aa3", 13));
        students.add(new Student(4L, "aa4", 14));
        model.addAttribute("list", students);
        return "index";
    }


    @GetMapping("/index2")
    public String index2(Map<String, String> map) {
        System.out.println("/index2.....");

        map.put("name", "zhangsan");
        return "index2";
    }
    @GetMapping("/index3")
    public String index3(Map<String, Boolean> map) {
        System.out.println("/index3.....");

        map.put("flag",true);
        return "index3";
    }


    @GetMapping("/index4")
    public String index4(Model model) {
        System.out.println("/index.....");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "aa1", 11));
        students.add(new Student(2L, "aa2", 12));
        students.add(new Student(3L, "aa3", 13));
        students.add(new Student(4L, "aa4", 14));
        model.addAttribute("list", students);
        return "index4";
    }


    @GetMapping("/index5")
    public String index5() {
        System.out.println("/index5.....");
        return "index5";
    }

    @GetMapping("/url/{name}")
    @ResponseBody
    public String url(@PathVariable("name") String name){
        return name;
    }

    @GetMapping("/src")
    public String src(Model model){
        model.addAttribute("src","https://www.360kuai.com/9ddf745ae60ba4b54?djsource=ZF90WY&refer_scene=0&scene=1&sign=360dh&tj_url=9ddf745ae60ba4b54&uid=396be65d8e7dbe16153f49fe9830feb1");
        return "index5";
    }
    @GetMapping("/eq")
    public String eq(Model model){
        model.addAttribute("age",30);
        return "index5";
    }


    @GetMapping("/switch")
    public String switchTest(Model model){
        model.addAttribute("gender","女");
        return "index5";
    }
    @GetMapping("/object")
    public String object(HttpServletRequest request){
        request.setAttribute("request","request对象");
        request.getSession().setAttribute("session","session对象");
        return "index5";
    }


    @GetMapping("/util")
    public String util(Model model){
        model.addAttribute("name","zhangsan");
        model.addAttribute("users",new ArrayList<>());
        model.addAttribute("count",22);
        model.addAttribute("date",new Date());
        return "index5";
    }
    /*
    *数据校验
    */
    @GetMapping("/validator")
    public void validatorUser(@Valid User user, BindingResult bindingResult){
        System.out.println(user);
        if(bindingResult.hasErrors()){
            List<ObjectError> list = bindingResult.getAllErrors();
            for(ObjectError objectError:list){
                System.out.println(objectError.getCode()+"-"+objectError.getDefaultMessage());
            }
        }
    }
}
