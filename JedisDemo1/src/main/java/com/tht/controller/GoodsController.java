package com.tht.controller;

import com.tht.pojo.Goods;
import com.tht.service.GoodsService;
import com.tht.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName : com.tht.controller.GoodsController
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-06 17:05:29
 */
@RestController
@CrossOrigin
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("getGoods")
    public List<Goods> getGoods() throws IOException {
        List<Goods> goodsList = goodsService.getGoods();
        System.out.println(goodsList);
        return  goodsList;
    }

    @RequestMapping("addGoods")
    public String addGoods(){
        int row = goodsService.addGoods(new Goods(0,"香蕉",12,"千克","水果"));
        return row>0?"添加成功":"添加失败";
    }

    @RequestMapping("delGoods")
    public String delGoods(int id){
        int row = goodsService.delGoods(id);
        return row>0?"删除成功":"删除失败";
    }

    @RequestMapping("updateGoods")
    public String updateGoods(){
        int row = goodsService.updateGoods(new Goods(1,"苹果",10,"千克","水果"));
        return row>0?"修改成功":"修改失败";
    }

}
