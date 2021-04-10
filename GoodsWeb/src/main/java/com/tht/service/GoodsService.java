package com.tht.service;

import com.tht.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoods(int pageIndex, int pageSize, String name);

    int getGoodsCount(String name);

    int addGoods(Goods goods);

    int delGoods(int id);

    int updateGoods(Goods goods);
}
