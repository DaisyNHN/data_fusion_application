package ldn.cs.fusion.dao;

import ldn.cs.fusion.pojo.company.CompanyGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompanyGroupDao {
    List<CompanyGroup> selectAll();
}
