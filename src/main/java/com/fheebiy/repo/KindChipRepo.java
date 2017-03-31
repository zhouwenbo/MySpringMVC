package com.fheebiy.repo;

import com.fheebiy.domain.KindChip;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cm on 2017/3/30.
 */
@Repository
public interface KindChipRepo extends IRepo<KindChip> {

    @Override
    void save(KindChip obj);

    @Select("select * from kindchip where name = #{0}")
    List<KindChip> getListByName(String name);

    @Override
    @Select("select * from kindchip order by createTime desc")
    List<KindChip> getList(Object... obj);

    @Update("update kindchip set fullCount = #{1}, name = #{2} where for_id = #{0}")
    void updateByGift(long for_id, int fullChipCount, String name);

}
