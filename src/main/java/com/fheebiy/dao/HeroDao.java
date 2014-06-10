package com.fheebiy.dao;

import com.fheebiy.domain.Hero;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bob zhou on 14-4-9.
 */
@Repository
public interface HeroDao {
    @Select("select * from tb_hero where hero_id = #{hero_id}")
    public Hero getById(@Param("hero_id")long hero_id);

    @Select("select * from tb_hero limit 1,10")
    public List<Hero> getList();
}
