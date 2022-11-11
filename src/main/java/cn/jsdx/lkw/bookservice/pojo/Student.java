package cn.jsdx.lkw.bookservice.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")

public class Student {
    @TableId("username")
    //登录认证字
    private String username;//编号
    private String password;
    //身份认证字
    private String sname;
    private String classroom;
    private int age;
    private String sex;
    private String address;
    private String phone;
}
