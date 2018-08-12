package com.imooc.service;

import com.imooc.pojo.Bgm;
import com.imooc.pojo.Videos;

import java.util.List;

/**
 * Created by xyzzg on 2018/8/12.
 */
public interface VideoService {

    String saveVideo(Videos video);

    void updateVideo(String videoId,String coverPath);
}
