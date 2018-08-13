package com.imooc.service;

import com.imooc.pojo.Bgm;
import com.imooc.pojo.Videos;
import com.imooc.utils.PagedResult;

import java.util.List;

/**
 * Created by xyzzg on 2018/8/12.
 */
public interface VideoService {

    String saveVideo(Videos video);

    void updateVideo(String videoId,String coverPath);

    //分页查询视频列表
    PagedResult getAllVideos(Integer page,Integer pageSize);
}
