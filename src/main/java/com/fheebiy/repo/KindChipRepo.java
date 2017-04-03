package com.fheebiy.repo;

import com.fheebiy.domain.KindChip;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cm on 2017/3/30.
 */
@Repository
public interface KindChipRepo extends IRepo<KindChip> {

    void save(KindChip obj);

    @Select("select * from kindchip where name = #{0}")
    List<KindChip> getListByName(String name);

    @Select("select * from kindchip order by createTime desc")
    List<KindChip> getList(Object... obj);

    @Update("update kindchip set fullCount = #{1}, level = #{2}, name = #{3} where for_id = #{0}")
    void updateByGift(long for_id, int fullChipCount, int level,String name);

    @Select("select * from kindchip where kc_id > #{1} limit #{0}")
    List<KindChip> getAList(int count, long last_id);

    @Select("select * from kindchip where level = #{0} order by updateTime desc ")
    List<KindChip> getListByLevel(int level);

    @Select("select * from kindchip where kc_id in (${coupon_ids})")
    List<KindChip> getByIds(@Param("coupon_ids")String coupon_ids);

}
