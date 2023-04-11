package com.springbootredis.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Movie")
public class Movie {
    @Id
    private int id;
    private String name;
    private String genre;
    private Date schedule;
}
