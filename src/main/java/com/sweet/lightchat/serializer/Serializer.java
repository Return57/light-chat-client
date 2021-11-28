package com.sweet.lightchat.serializer;

/**
 * @author wuqing
 * @date 2021/11/28 23:22
 * @description
 */
public interface Serializer {
    Serializer Default = new JsonSerializer();
    byte getSerializerAlgorithm();

    <T> byte [] serializer(T t);

    <T> T deSerializer(Class<T> clazz, byte[] bytes);
}
