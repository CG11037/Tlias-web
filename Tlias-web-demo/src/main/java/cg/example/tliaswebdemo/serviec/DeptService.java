package cg.example.tliaswebdemo.serviec;

import cg.example.tliaswebdemo.pojo.Dept;
import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void deleteById(Integer deptId);
}
