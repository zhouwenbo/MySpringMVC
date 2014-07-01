package com.fheebiy.repo;

import com.fheebiy.domain.Company;
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
}
