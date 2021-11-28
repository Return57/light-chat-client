package com.sweet.lightchat.serializer;

import com.alibaba.fastjson.JSON;

/**
 * @author wuqing
 * @date 2021/11/28 23:23
 * @description
 */
public class JsonSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public <T> byte[] serializer(T t) {
        return JSON.toJSONBytes(t);
    }

    @Override
    public <T> T deSerializer(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}