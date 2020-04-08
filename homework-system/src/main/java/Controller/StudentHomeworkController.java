package Controller;

import Bean.Homework;
import jdbc.HomeworkJdbc;
import jdbc.StudentHomeworkJdbc;
import Bean.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentHomeworkController {
    @RequestMapping(value = "StudentHomeworklist")
    public String getHomeworkList(Model model, HttpServletRequest request){
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll();
        model.addAttribute("list", list);
        return "Chaxun_homework";
    }
}
