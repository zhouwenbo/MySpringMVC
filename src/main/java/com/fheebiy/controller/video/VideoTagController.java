package com.fheebiy.controller.video;

import com.fheebiy.dto.VideoTagDto;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.video.VideoTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/11/9.
 */
@Controller
@RequestMapping("/video/tag")
public class VideoTagController {

    @Autowired
    private VideoTagService service;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAList(HttpServletRequest request) {
        List<VideoTagDto> list = service.getTagList();
        return new JsonResponse(list);

    }
}
