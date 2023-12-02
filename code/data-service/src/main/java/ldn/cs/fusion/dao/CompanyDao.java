package ldn.cs.fusion.dao;

import ldn.cs.fusion.pojo.company.Company;
import ldn.cs.fusion.pojo.convey.Convey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompanyDao {
//    int add(Company company);

    List<Company> getByGroupId(Integer groupId);




}
