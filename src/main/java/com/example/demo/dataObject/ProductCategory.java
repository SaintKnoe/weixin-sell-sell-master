package com.example.demo.dataObject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:类目
 * User: SaintChan
 * Date: 2018-01-23
 * Time: 下午 4:06
 */
@Entity
@DynamicUpdate //动态更新（包括时间）
@Data
public class ProductCategory {

    /*类目*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /*类目名称*/
    private String categoryName;

    /*类目编号*/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
