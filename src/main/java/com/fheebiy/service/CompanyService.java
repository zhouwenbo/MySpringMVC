package com.fheebiy.service;

import com.fheebiy.domain.Company;
import com.fheebiy.repo.CompanyRepo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by bob zhou on 14-7-3.
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyRepo repo;

    public List<Company> getListByIds(Collection<Long> company_ids) {
       /* if(CollectionUtils.isEmpty(company_ids)){
            return new ArrayList<Company>();
        }*/
        String ids = StringUtils.join(company_ids, ",");
        return repo.getCompanyByIds(ids);
    }


    public Map<Long, Company> getComMapByIds(Collection<Long> company_ids) {
        List<Company> list = getListByIds(company_ids);
        Map<Long,Company> map = new HashMap<Long, Company>();
        for(Company company : list){
            map.put(company.getId(), company);
        }
        return  map;
    }


    public Map<Long,Company> getComMapByName(String name){
        List<Company> list = repo.getCompanyByName(name);
        Map<Long,Company> map = new HashMap<Long, Company>();
        for(Company company: list){
            map.put(company.getId(), company);
        }
        return map;
    }

    public List<Company> getListByName(String name){
        return repo.getCompanyByName(name);
    }
}
