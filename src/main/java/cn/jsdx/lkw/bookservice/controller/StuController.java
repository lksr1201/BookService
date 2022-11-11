package cn.jsdx.lkw.bookservice.controller;


import cn.jsdx.lkw.bookservice.mapper.StudentMapper;
import cn.jsdx.lkw.bookservice.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/student")
public class StuController {

    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/login")
    public String LoginCheck(@RequestBody Student student){
        Student stu_select = studentMapper.selectById(student.getUsername());
        if (stu_select == null){
            return "account does not exist";
        }else if (!Objects.equals(stu_select.getPassword(), student.getPassword())){
            return "password error";
        }else {
            return "success";
        }
    }

    @PostMapping("/register")
    public String Register(@RequestBody Student student){
        System.out.println(student);
        Student student1 = studentMapper.selectById(student.getUsername());
        if (student1==null){
            System.out.println("registrable");
            studentMapper.insert(student);
            return "success";
        }else {

            return "account already exists";
        }
    }

    @RequestMapping("/test")
    public Student Login(){
        return studentMapper.selectById("12345");
    }
}
