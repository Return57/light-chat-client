package com.sweet.lightchat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuqing
 * @date 2021/11/28 23:50
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    // 结果状态
    private String code;
    // 结果消息
    private String desc;
    private T data;
}
