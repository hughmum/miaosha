package com.mu.miaosha.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * item
 * @author 
 */
@Data
public class ItemDO implements Serializable {
    private Long id;

    private String title;

    private Double price;

    private String description;

    private Integer sales;

    private String imgUrl;

    private static final long serialVersionUID = 1L;
}