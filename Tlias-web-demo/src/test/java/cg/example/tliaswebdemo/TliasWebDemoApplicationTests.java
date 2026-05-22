package cg.example.tliaswebdemo;

import cg.example.tliaswebdemo.pojo.Dept;
import cg.example.tliaswebdemo.serviec.impl.DeptServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasWebDemoApplicationTests {
    @Autowired
    DeptServiceImpl deptService;

    @Test
    public void testSelectDeptAll(){
        System.out.println(deptService.findAll());
    }

    @Test
    public void testDeleteDeptById(){
        Integer id=20;
        deptService.deleteById(id);
    }

}
