package com.fheebiy.repo;

import com.fheebiy.domain.Car;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-7-3.
 */
@Repository
public interface CarRepo {

    public List<Car> getList(Map<String, Object> map);

    @Select("select * from car where id = #{id}")
    public Car getById(long id);

    public void save(Car car);

    public void update(Car car);

    @Select("delete from car where id=#{id}")
    public void delete(long id);

    @Select("select * from car where carNum = #{carNum}")
    public Car getCarByCarNum(String carNum);

}
