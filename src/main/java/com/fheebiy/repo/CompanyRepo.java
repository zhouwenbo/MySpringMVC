package com.fheebiy.repo;

import com.fheebiy.domain.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by bob zhou on 14-7-1.
 */
@Repository
public interface CompanyRepo {
    public List<Company> getList(Map map);

    @Select("select * from company where id= #{id}")
    public Company getById(long id);

    public void save(Company company);

    public void update(Company company);

    @Delete("delete from company where id = #{id}")
    public void delete(long id);

    @Select("select * from company where name like'%#{name}%'")
    public List<Company> getCompanyByName(String name);

    @Select("select * from company where id in(${ids})")
    public List<Company> getCompanyByIds(@Param("ids")String ids);

}
