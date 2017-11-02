package com.fheebiy.controller.video;

import com.fheebiy.common.web.HttpParameterUtil;
import com.fheebiy.domain.Video;
import com.fheebiy.rest.JsonResponse;
import com.fheebiy.service.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by cm on 2017/11/2.
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAList(HttpServletRequest request) {
        int count = HttpParameterUtil.getParameterInt(request, "count");
        long utime = HttpParameterUtil.getParameterLong(request, "utime");
        String tag = HttpParameterUtil.getParameter(request, "tag");
        if (utime == 0) {
            utime = System.currentTimeMillis();
        }
        List<Video> list = videoService.getList(count, utime, tag);
        return new JsonResponse(list);
    }

}
