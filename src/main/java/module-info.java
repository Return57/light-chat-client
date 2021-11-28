module com.sweet.lightchat {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.netty.transport;
    requires lombok;
    requires io.netty.common;
    requires io.netty.codec;
    requires io.netty.buffer;
    requires fastjson;
    requires okhttp3;

    opens com.sweet.lightchat to javafx.fxml;
    exports com.sweet.lightchat;
}