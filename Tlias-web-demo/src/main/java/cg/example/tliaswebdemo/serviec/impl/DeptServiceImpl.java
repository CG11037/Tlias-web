package cg.example.tliaswebdemo.serviec.impl;

import cg.example.tliaswebdemo.mapper.DeptMapper;
import cg.example.tliaswebdemo.pojo.Dept;
import cg.example.tliaswebdemo.serviec.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }

    public void insert(Dept dept){
        // 补全属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

}
