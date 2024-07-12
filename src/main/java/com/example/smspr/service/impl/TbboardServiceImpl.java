package com.example.smspr.service.impl;

import com.example.smspr.domain.Tbboard;
import com.example.smspr.dto.CommonDto;
import com.example.smspr.mapper.TbboardMapper;
import com.example.smspr.repository.TbboardRepository;
import com.example.smspr.service.TbboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//24-07-12
//Controller의 작업을 Service로 이전
public class TbboardServiceImpl implements TbboardService {

    //Console 창에 로그가 찍힘 > 오류 발생 시 어디에서 문제가 생기는지 알 수 있음, 이슈 처리에 용이
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbboardRepository tbboardRepository;
    private final TbboardMapper tbboardMapper;

    public TbboardServiceImpl(
            TbboardRepository tbboardRepository,
            TbboardMapper tbboardMapper
    ) {
        this.tbboardRepository = tbboardRepository;
        this.tbboardMapper = tbboardMapper;
    }

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        Map<String, Object> returnVal = new HashMap<>();
        Tbboard tbboard = Tbboard.of(param.get("title")+"", param.get("content")+"", param.get("writer")+"");
        tbboardRepository.save(tbboard);
        returnVal.put("resultCode", 200);
        return returnVal;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {

        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 0;

        String id = param.get("id")+"";

        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        if(param.get("title") != null && !"".equals(param.get("title"))){
            tbboard.setTitle(param.get("title") + "");
            resultCode = 200;
        }
        if(param.get("content") != null && !"".equals(param.get("content"))){
            tbboard.setContent(param.get("content") + "");
            resultCode = 200;
        }
        if(param.get("writer") != null && !"".equals(param.get("writer"))){
            tbboard.setWriter(param.get("writer") + "");
            resultCode = 200;
        }
        tbboardRepository.save(tbboard);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }

    @Override
    public Map<String, Object> delete(String id) {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        tbboardRepository.delete(tbboard);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }

    @Override
    public Map<String, Object> detail(String id) {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        Tbboard tbboard = tbboardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        CommonDto.TbboardDetailResDto mapTbboard = tbboardMapper.detail(id);

        returnVal.put("resultCode", resultCode);
        returnVal.put("resultData", mapTbboard);
        return returnVal;
    }

    @Override
    public Map<String, Object> list() {
        Map<String, Object> returnVal = new HashMap<>();
        int resultCode = 200;

        List<Tbboard> list_tbboard = tbboardRepository.findAll();
        List<Map<String, Object>> list_tbboard1 = tbboardMapper.list(returnVal);

        returnVal.put("resultCode", resultCode);
        returnVal.put("resultData", list_tbboard1);
        return returnVal;
    }
}
