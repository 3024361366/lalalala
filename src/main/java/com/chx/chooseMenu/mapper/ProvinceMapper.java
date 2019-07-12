package com.chx.chooseMenu.mapper;

import com.chx.chooseMenu.pojo.Area;

import java.util.List;

public interface ProvinceMapper {
    List<Area> findAllProvince();

    List<Area> findAllCity(int id);

    List<Area> findAllContury(int id);
}
