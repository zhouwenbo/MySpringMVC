package com.fheebiy.repo;

import com.fheebiy.domain.Seed;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by cm on 2017/4/3.
 */
@Repository
public interface SeedRepo {

    void save(Seed seed);

    @Select("select * from seed where seed_id = #{0} and user_id = #{1}")
    Seed getByIdAndUser(long seed_id, long user_id);
}
