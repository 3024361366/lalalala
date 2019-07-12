package com.chx.chooseMenu.service;

import com.chx.chooseMenu.pojo.Area;

import java.util.List;

public interface ProvinceService {
    List<Area> findAllProvince();

    List<Area> findAllCity(int id);

    List<Area> findAllContury(int id);
}
