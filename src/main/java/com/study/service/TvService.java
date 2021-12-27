package com.study.service;

import com.study.pojo.Tv;

import java.util.List;

public interface TvService {


    List<Tv> allTv();
    int add(Tv tv);
    Tv selectByPno(int pno);
    int update(Tv tv);
    int del(int pno);
}
