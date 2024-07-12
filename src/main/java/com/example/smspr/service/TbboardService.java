package com.example.smspr.service;

import org.springframework.stereotype.Service;

import java.util.Map;

//24-07-12
@Service
public interface TbboardService {
    public Map<String, Object> create(Map<String, Object> param);
    public Map<String, Object> update(Map<String, Object> param);
    public Map<String, Object> delete(String id);
    public Map<String, Object> detail(String id);
    public Map<String, Object> list();
}
