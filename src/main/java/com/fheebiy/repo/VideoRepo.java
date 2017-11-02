package com.fheebiy.repo;

import com.fheebiy.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/11/2.
 */
@Repository
public interface VideoRepo {

    List<Video> list(Map map);
}
