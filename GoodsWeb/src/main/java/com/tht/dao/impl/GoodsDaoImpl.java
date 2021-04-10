package com.tht.dao.impl;

import com.tht.dao.GoodsDao;
import com.tht.pojo.Goods;
import com.tht.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import java.util.*;

/**
 * @ClassName : com.tht.dao.impl.GoodsDaoImpl
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-09 08:53:14
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    JedisCluster jedisCluster;

    @Override
    public boolean isExists(String key) {
        return jedisCluster.exists(key);
    }

    @Override
    public List<Goods> get(String key,int pageIndex,int pageSize) {
        long start = (pageIndex-1)*pageSize;
        long stop = pageIndex*pageSize-1;
        Set<String> goods = jedisCluster.zrange(key,start,stop);
        return JsonUtils.jsonToList(goods.toString(),Goods.class);
    }

    @Override
    public void set(String key, List<Goods> list) {
        Map<String,String> map = new HashMap<>();
        String str = "";
        for (Goods goods:list) {
            str = JsonUtils.objectToJson(goods);
            jedisCluster.zadd("goodsSet",goods.getId(),str);
            map.put(goods.getId()+"",str);
        }
        jedisCluster.hset("goods",map);
    }

    @Override
    public void hset(String key, String fileId, Goods goods) {
        jedisCluster.hset(key,fileId,JsonUtils.objectToJson(goods));
        jedisCluster.zremrangeByScore("goodsSet",goods.getId(),goods.getId());
        jedisCluster.zadd("goodsSet",goods.getId(),JsonUtils.objectToJson(goods));
    }

    @Override
    public long hdel(String key, String fileId) {
        int id = Integer.parseInt(fileId);
        jedisCluster.zremrangeByScore("goodsSet",id,id);
        return jedisCluster.hdel(key,fileId);
    }

    @Override
    public int hlen() {
        return jedisCluster.hlen("goods").intValue();
    }


}
