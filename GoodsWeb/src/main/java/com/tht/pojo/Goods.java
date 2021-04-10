package com.tht.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName : com.tht.pojo.Goods
 * @Description : 描述
 * Author : space
 * CreatedDate 2021-04-09 08:30:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private int id;
    private String name;
    private float price;
}
