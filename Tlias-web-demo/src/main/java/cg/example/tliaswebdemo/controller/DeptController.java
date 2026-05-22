package cg.example.tliaswebdemo.controller;

import cg.example.tliaswebdemo.pojo.Dept;
import cg.example.tliaswebdemo.pojo.Result;
import cg.example.tliaswebdemo.serviec.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/depts")

    // @RequestBody：将请求体中的json数据封装到到方法形参中
    // 例如：name参数被封装到dept实体类中
    // 要求请求体中的数据格式为json格式
    // 并且实体类中一定要有同名的字段
    public Result add(@RequestBody Dept dept){
        System.out.println("添加部门数据，部门名称："+dept.getName());
        deptServiceImpl.insert(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")

    // 如果请求参数为路径参数，需要在上面用{}包装
    // 并且需要使用@PathVariable注解将路径参数与方法形参绑定
    // 但是如果路径参数名和形参名一致可以省略掉("id")
    // 也可以有多个路径参数但是需要注解一一指定
    public Result getInfo(@PathVariable("id") Integer deptId){
        System.out.println("根据id查询部门数据，id为："+deptId);
        Dept dept=deptServiceImpl.getById(deptId);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result updateById(@RequestBody Dept dept){
        System.out.println("更新部门数据，部门名称："+dept.getName()+"，部门id："+dept.getId());
        deptServiceImpl.updateById(dept);
        return Result.success();
    }
}
