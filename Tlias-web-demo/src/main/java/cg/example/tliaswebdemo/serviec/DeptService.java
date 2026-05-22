package cg.example.tliaswebdemo.serviec;

import cg.example.tliaswebdemo.pojo.Dept;
import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void deleteById(Integer deptId);

    public void insert(Dept dept);

    public Dept getById(Integer deptId);

    public void updateById(Dept dept);

}
