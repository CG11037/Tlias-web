package cg.example.tliaswebdemo.mapper;

import cg.example.tliaswebdemo.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 对于数据库表中列名和pojo实体字段名不批配时，可以给列取别名：
    // 或者可以在配置文件中设置开启驼峰大写转换
    @Select("select id,name,create_time createTime,update_time updateTime from dept")
    public List<Dept> findAll();

    @Delete("delete from dept where id=#{id}")
    public void deleteById(Integer id);

    // 可以通过#{属性名}从实体类中自动提取属性值
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    public void insert(Dept dept);
}
