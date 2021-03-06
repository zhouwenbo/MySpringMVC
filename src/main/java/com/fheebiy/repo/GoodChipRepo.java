package com.fheebiy.repo;

import com.fheebiy.domain.GoodChip;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cm on 2017/4/2.
 */
@Repository
public interface GoodChipRepo {


    void saveForSell(GoodChip goodChip);

    @Select("select * from goodchip where gc_id = #{0} and status = 0")
    GoodChip getById(long gc_id);

    @Update("update goodchip set status = #{1} where gc_id = #{0}")
    void updateStatus(long gc_id, int status);

    @Select("select * from goodchip where updateTime < #{1} and status = 0 order by updateTime desc limit #{0}")
    List<GoodChip>  getAList(int count, long createTime);

    @Select("select * from goodchip where user_id = #{0} and kc_id = #{1} limit 1")
    GoodChip getByUserAndKcId(long user_id, long kc_id);

    @Select("update goodchip set count = #{1}, price =#{2}, updateTime = #{3} where gc_id = #{0}")
    GoodChip updateCountAndPrice(long gc_id, int count, int price, long updateTime);

}
