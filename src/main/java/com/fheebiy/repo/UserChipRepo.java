package com.fheebiy.repo;

import com.fheebiy.domain.UserChip;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cm on 2017/3/30.
 *
 */
@Repository
public interface UserChipRepo extends IRepo<UserChip>{

    void save(UserChip obj);

    @Select("select * from userchip where user_id = #{0} order by updateTime desc")
    List<UserChip> getListByUser(long user_id);

    @Select("select * from userchip where kc_id = #{0} and user_id = #{1}")
    UserChip getByKcid(long kc_id, long user_id);

    @Update("update userchip set count = #{0} where kc_id = #{1} and user_id = #{2}")
    void updateCountByKcid(int count,long kc_id, long user_id);
}
