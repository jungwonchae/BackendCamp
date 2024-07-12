package com.example.smspr.mapper;

import com.example.smspr.dto.CommonDto;

import java.util.List;
import java.util.Map;

//24-07-12
public interface TbboardMapper {
    CommonDto.TbboardDetailResDto detail(String id);
    List<Map<String, Object>> list(Map<String, Object> param);
}
