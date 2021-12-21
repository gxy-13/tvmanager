package com.study.mapper;

import com.study.bean.Tv;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TvMapper {
    List<Tv> allTv();
    int add(Tv tv);
    Tv selectByPno(int pno);
    int update(Tv tv);
    int del(int pno);
}
