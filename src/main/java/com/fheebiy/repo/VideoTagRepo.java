package com.fheebiy.repo;

import com.fheebiy.domain.VideoTag;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cm on 2017/11/9.
 */
@Repository
public interface VideoTagRepo {

    @Select("select * from tb_video_tag where status = 0")
    List<VideoTag> getList();
}
