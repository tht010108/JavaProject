package com.tht.web.controller;

import com.tht.pojo.Goods;
import com.tht.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : com.tht.web.controller.GoodsController
 * @Description : ����
 * Author : space
 * CreatedDate 2021-04-09 09:08:56
 */
@RestController
@CrossOrigin
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("getGoods")
    public Map<String,Object> getGoods(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "10")  int pageSize, String name){
        Map<String,Object> map = new HashMap<>();
        map.put("goodsList",goodsService.getGoods(pageIndex,pageSize,name));
        map.put("count",goodsService.getGoodsCount(name));
        return map;
    }

    @RequestMapping(value = "addGoods")
    public String addGoods(@RequestBody Goods goods){
        int row = goodsService.addGoods(goods);
        return row > 0 ? "添加成功" : "添加失败";
    }

    @RequestMapping("updateGoods")
    public String updateGoods(@RequestBody Goods goods){
        int row = goodsService.updateGoods(goods);
        return row > 0 ? "修改成功" : "修改失败";
    }

    @RequestMapping("delGoods")
    public String delGoods(int id){
        int row = goodsService.delGoods(id);
        return row > 0 ? "删除成功" : "删除失败";
    }

}
