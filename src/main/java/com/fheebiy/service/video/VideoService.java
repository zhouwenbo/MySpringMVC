package com.fheebiy.service.video;

import com.fheebiy.domain.Video;
import com.fheebiy.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cm on 2017/11/2.
 */
@Service
public class VideoService {

    @Autowired
    private VideoRepo videoRepo;

    public List<Video> getList(int count, long utime, String tag) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("count", count);
        map.put("utime", utime);
        map.put("tag", tag);
        return videoRepo.list(map);
    }


    public void scan(long vid) {
        videoRepo.scan(vid);
    }


    public void rose(long vid) {
        videoRepo.rose(vid);
    }


}
