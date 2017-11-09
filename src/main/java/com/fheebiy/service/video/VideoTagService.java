package com.fheebiy.service.video;

import com.fheebiy.domain.VideoTag;
import com.fheebiy.dto.VideoTagDto;
import com.fheebiy.repo.VideoTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cm on 2017/11/9.
 */
@Service
public class VideoTagService {

    @Autowired
    private VideoTagRepo tagRepo;

    public List<VideoTagDto> getTagList() {
        List<VideoTag> tags = tagRepo.getList();
        List<VideoTagDto> dtos = new ArrayList<VideoTagDto>();
        for (VideoTag tag : tags) {
            dtos.add(new VideoTagDto(tag.getId(), tag.getType(), tag.getName()));
        }
        return dtos;
    }


}
