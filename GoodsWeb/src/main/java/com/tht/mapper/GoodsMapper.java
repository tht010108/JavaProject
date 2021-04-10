package com.tht.mapper;

import com.tht.pojo.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> selectGoodsAll();

    List<Goods> selectGoods(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize,@Param("name") String name);

    int addGoods(Goods goods);

    @Delete("delete from goods where id = #{id}")
    int delGoods(int id);

    @Update("update goods set name = #{name},price = #{price} where id = #{id}")
    int updateGoods(Goods goods);

    int selectGoodsCount(String name);
}
