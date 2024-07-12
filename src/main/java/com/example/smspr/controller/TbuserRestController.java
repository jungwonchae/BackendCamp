package com.example.smspr.controller;

import com.example.smspr.domain.Tbuser;
import com.example.smspr.repository.TbuserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {
    List<Map<String,Object>> tbuserList = new ArrayList<>();

    TbuserRepository tbuserRepository;
    public TbuserRestController(TbuserRepository tbuserRepository) {
        this.tbuserRepository = tbuserRepository;
    }

    @GetMapping("/create")
    public Map<String,Object> create(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String birth,
            @RequestParam String gender

    ){
        Map<String, Object> returnVal =new HashMap<>();
        Map<String, Object> tbuser = new HashMap<>();
        tbuser.put("order", tbuserList.size() + 1);
        tbuser.put("name", name);
        tbuser.put("phone", phone);
        tbuser.put("birth", birth);
        tbuser.put("gender", gender);

        Tbuser tbuser1 = Tbuser.of(name, phone, birth, gender);
        tbuserRepository.save(tbuser1);

        returnVal.put("resultCode", 200);
        returnVal.put("order", tbuserList.size());
        return returnVal;
    }

    @GetMapping("/list")
    public Map<String,Object> list(){
        Map<String, Object> returnVal =new HashMap<>();

        returnVal.put("resultCode", 200);
        returnVal.put("data", tbuserRepository.findAll());
        return returnVal;
    }

    @GetMapping("/detail/{id}")
    public Map<String,Object> detail(@PathVariable String id){
        Map<String, Object> returnVal =new HashMap<>();
        int resultCode = 0;
        returnVal.put("resultCode", resultCode);

        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(()->new RuntimeException(""));
        returnVal.put("data", tbuser);
        return returnVal;
    }

    @GetMapping("/update")
    public Map<String,Object> update(@RequestParam Map<String, Object> params){
        Map<String, Object> returnVal =new HashMap<>();
        String id = (String) params.get("id");
        int resultCode = 0;

        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(()->new RuntimeException(""));
        if(params.get("name") != null && !"".equals(params.get("name")) ){
            tbuser.setName(params.get("name") + "");
            resultCode = 200;
        }
        if(params.get("phone") != null && !"".equals(params.get("phone")) ){
            tbuser.setPhone(params.get("phone") + "");
            resultCode = 200;
        }
        if(params.get("birth") != null && !"".equals(params.get("birth")) ){
            tbuser.setBirth(params.get("birth") + "");
            resultCode = 200;
        }
        if(params.get("gender") != null && !"".equals(params.get("gender")) ){
            tbuser.setGender(params.get("gender") + "");
            resultCode = 200;
        }
        tbuserRepository.save(tbuser);
        returnVal.put("resultCode", resultCode);

        return returnVal;
    }
    @GetMapping("/delete")
    public Map<String,Object> delete(@RequestParam Map<String,Object> params){
        Map<String, Object> returnVal =new HashMap<>();
        String id = (String) params.get("id");
        int resultCode = 0;

        Tbuser tbuser = tbuserRepository.findById(id).orElseThrow(()->new RuntimeException(""));
        tbuserRepository.delete(tbuser);

        returnVal.put("resultCode", resultCode);
        return returnVal;
    }
}
