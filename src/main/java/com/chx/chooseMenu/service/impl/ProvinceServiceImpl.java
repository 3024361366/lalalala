package com.chx.chooseMenu.service.impl;

import com.chx.chooseMenu.mapper.ProvinceMapper;
import com.chx.chooseMenu.pojo.Area;
import com.chx.chooseMenu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;
    @Override
    public List<Area> findAllProvince() {
        return provinceMapper.findAllProvince();
    }

    @Override
    public List<Area> findAllCity(int id) {
        return provinceMapper.findAllCity(id);
    }

    @Override
    public List<Area> findAllContury(int id) {
        return provinceMapper.findAllContury(id);
    }
}
