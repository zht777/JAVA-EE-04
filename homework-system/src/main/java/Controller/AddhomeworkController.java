package Controller;

import jdbc.HomeworkJdbc;
import jdbc.StudentHomeworkJdbc;
import Bean.Homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class AddhomeworkController {
    @RequestMapping(value = "addhomework")
    public String addHomework(@RequestParam("hw_id") String hw_id ,
                              @RequestParam("hw_name") String hw_name ,
                              @RequestParam("content") String content,
                              @RequestParam("create_time") String create_time ,
                              HttpServletRequest request){
        Homework hm = new Homework();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        hm.setId(Long.parseLong(hw_id));
        hm.setName(hw_name);
        hm.setContent(content);
        hm.setCreateTime(create_time);

        StudentHomeworkJdbc studentHomeworkJdbc =(StudentHomeworkJdbc) applicationContext.getBean("StudentHomeworkJdbc_jdbc");
        studentHomeworkJdbc.addStudentHomework(hm);
        return "success";
    }


}
