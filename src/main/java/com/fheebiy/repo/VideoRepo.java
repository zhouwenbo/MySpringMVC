package com.fheebiy.repo;

import com.fheebiy.domain.Video;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/11/2.
 */
@Repository
public interface VideoRepo {

    List<Video> list(Map map);

    @Update("update tb_hvideo set viewcount=viewcount+1 where id = #{0}")
    void scan(long vid);



    @Update("update tb_hvideo set rosecount=rosecount+1 where id = #{0}")
    void rose(long vid);

}
