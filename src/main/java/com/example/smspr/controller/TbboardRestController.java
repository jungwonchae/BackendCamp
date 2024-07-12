package com.example.smspr.controller;

import com.example.smspr.domain.Tbboard;
import com.example.smspr.repository.TbboardRepository;
import com.example.smspr.service.TbboardService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbboard")
@RestController
public class TbboardRestController {
    private final TbboardService tbboardService;

    //List<Map<String, Object>> tbboardList = new ArrayList<>();

    //instance 안만들고 그냥 사용할 수 있음 , tbboardrepository의 기능을 쓴다
    TbboardRepository tbboardRepository;
    public TbboardRestController(
            TbboardRepository tbboardRepository,
            TbboardService tbboardService){
        this.tbboardRepository = tbboardRepository;
        this.tbboardService = tbboardService;
    }


    //24-07-12
    //service에 기능을 넣음.
    @GetMapping("/create")
    public Map<String, Object> create(
            @RequestParam String title
            , @RequestParam String content
            , @RequestParam String writer
    ){
        Map<String, Object> tbboard = new HashMap<>();
        tbboard.put("title", title);
        tbboard.put("content", content);
        tbboard.put("writer", writer);

        return tbboardService.create(tbboard);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        return tbboardService.list();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable String id){
        return tbboardService.detail(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return tbboardService.update(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params){
        return tbboardService.delete(params.get("id")+"");
    }
}
