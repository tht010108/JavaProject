package com.tht.service.impl;

import com.tht.dao.GoodsDao;
import com.tht.mapper.GoodsMapper;
import com.tht.pojo.Goods;
import com.tht.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : com.tht.service.impl.GoodsServiceImpl
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-09 08:45:12
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsDao goodsDao;


    @Override
    public List<Goods> getGoods(int pageIndex,int pageSize,String name) {
        //如果redis中无数据
        if(!goodsDao.isExists("goods")){
            //查询所以商品将之缓存到redis中
            goodsDao.set("goods",goodsMapper.selectGoodsAll());
        }
        if(name != null && !"".equals(name)){    //如果带条件查询
            //去mysql查询数据
            return goodsMapper.selectGoods(pageIndex,pageSize,name);
        }else{                                  //不带条件查询将去redis中查询
            return goodsDao.get("goodsSet",pageIndex,pageSize);
        }
    }

    @Override
    public int getGoodsCount(String name) {
        if(name != null && !"".equals(name)){
            return goodsMapper.selectGoodsCount(name);
        }else {
            return goodsDao.hlen();
        }
    }

    @Override
    public int addGoods(Goods goods) {
        int row = goodsMapper.addGoods(goods);
        if(row>0){
            goodsDao.hset("goods",goods.getId()+"",goods);
        }
        return row;
    }

    @Override
    public int delGoods(int id) {
        int row = goodsMapper.delGoods(id);
        if(row > 0){
            goodsDao.hdel("goods",id+"");
        }
        return row;
    }

    @Override
    public int updateGoods(Goods goods) {
        int row = goodsMapper.updateGoods(goods);
        if(row > 0){
            goodsDao.hset("goods",goods.getId()+"",goods);
        }
        return row;
    }
}
