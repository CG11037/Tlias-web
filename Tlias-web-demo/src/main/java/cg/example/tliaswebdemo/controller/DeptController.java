package cg.example.tliaswebdemo.controller;

import cg.example.tliaswebdemo.pojo.Result;
import cg.example.tliaswebdemo.serviec.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    private DeptServiceImpl deptServiceImpl;

    @GetMapping("/depts")
    public Result list(){
        System.out.println("查询全部的部门数据");
        return Result.success(deptServiceImpl.findAll());
    }

    @DeleteMapping("/depts")

    // RequestParam：将请求参数绑定给方法形参
    // 绑定名需要与请求参数名一致
    // 可以再后面添加required参数，如果为false则请求时可以不需要此参数
    // 最后如果请求参数和方法形参一致则可以不添加@RequestParam注解
    public Result delete(@RequestParam(value = "id",required = false) Integer deptId){
        System.out.println("删除部门数据,id为"+deptId);
        deptServiceImpl.deleteById(deptId);
        return Result.success();
    }
}
