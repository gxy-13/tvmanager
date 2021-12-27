package com.study.service.impl;

import com.study.pojo.Tv;
import com.study.mapper.TvMapper;
import com.study.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvServiceImpl implements TvService {

    @Autowired
    TvMapper tvMapper;

    public List<Tv> allTv(){
        return tvMapper.allTv();
    }
    public int add(Tv tv){
        return tvMapper.add(tv);
    }
    public Tv selectByPno(int pno){
        return tvMapper.selectByPno(pno);
    }
    public int update(Tv tv){
        return tvMapper.update(tv);
    }
    public  int del(int pno){
        return tvMapper.del(pno);
    }
}
