package com.tht.dao;

import com.tht.pojo.Goods;

import java.util.List;

/**
 * @ClassName : com.tht.dao.GoodsDao
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-09 08:48:09
 */
public interface GoodsDao {
    boolean isExists(String key);

    List<Goods> get(String key,int pageIndex,int pageSize);

    void set(String key, List<Goods> list);

    void hset(String key, String fileId, Goods goods);

    long hdel(String key,String fileId);

    int hlen();
}
