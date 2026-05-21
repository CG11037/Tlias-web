package cg.example.tliaswebdemo.controller;

import cg.example.tliaswebdemo.pojo.Result;
import cg.example.tliaswebdemo.serviec.DeptService;
import cg.example.tliaswebdemo.serviec.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
