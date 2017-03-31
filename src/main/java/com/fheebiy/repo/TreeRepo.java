package com.fheebiy.repo;

import com.fheebiy.domain.Tree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by cm on 2017/3/30.
 */
@Repository
public interface TreeRepo {

    void save(Tree tree);

    @Select("select * from tree where user_id = #{0} and type = #{0}")
    Tree getTreeByUserIdAndType(long user_id, int type);

    @Update("update tree set progress = #{2} where user_id = #{0} and type = #{1}")
    void updateProgress(long user_id, int type, long progress);

    @Delete("delete from tree where user_id = #{0} and type = #{1} ")
    void delete(long user_id, int type);

}
