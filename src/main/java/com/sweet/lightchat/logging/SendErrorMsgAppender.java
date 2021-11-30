package com.sweet.lightchat.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wuqing
 * @date 2021/11/28 0:13
 * @description 发送错误日志到钉钉
 */
@Slf4j
public class SendErrorMsgAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {

    }
//
//    private static final String url = "https://oapi.dingtalk.com/robot/send?access_token=%s";
//
//    private HttpHeaders headers;
//
//    public SendErrorMsgAppender() {
//        headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//    }
//
//    @Override
//    public void append(ILoggingEvent event) {
//        if (event.getLevel() == Level.ERROR) {
//            SysProperties sysProperties = getApplicationContext().getBean("sysProperties", SysProperties.class);
//            //没有启用
//            if (!sysProperties.getWaringDingdingEnable()) {
//                return;
//            }
//            IThrowableProxy iThrowableProxy = event.getThrowableProxy();
//            StringBuilder sb = new StringBuilder();
//            if (iThrowableProxy != null && iThrowableProxy instanceof ThrowableProxy) {
//                ThrowableProxy throwableProxy = (ThrowableProxy) iThrowableProxy;
//                Throwable throwable = throwableProxy.getThrowable();
//                String throwableMsg = throwable.getMessage();
//                StackTraceElementProxy[] stackTraceElementProxy = iThrowableProxy.getStackTraceElementProxyArray();
//                //获取服务器Ip，告知哪台服务器抛异常
//                String ip = Context.getContext().getIp();
//                if (null != ip) {
//                    sb.append("服务器:").append(ip).append("\n");
//                }
//                sb.append(event.getMessage()).append("\n");
//                if (StringUtils.isNotEmpty(throwableMsg)) {
//                    sb.append(throwableMsg).append("\n");
//                }
//                int i = 0;
//                for (StackTraceElementProxy proxy : stackTraceElementProxy) {
//                    //只打印40行的堆栈
//                    if (i < 40) {
//                        sb.append(proxy.getSTEAsString()).append("\n");
//                    } else {
//                        break;
//                    }
//                    i++;
//                }
//            } else {
//                sb.append(event.getMessage());
//            }
//            String msg = sb.toString();
//            if (StringUtils.isNotEmpty(msg)) {
//                sendMsgToDingDing(msg);
//            }
//        }
//    }
//
//
//    /**
//     * @param msg
//     * @return
//     */
//    private Map<String, Object> sendMsgToDingDing(String msg) {
//        RestTemplate restTemplate = getApplicationContext().getBean("restTemplate", RestTemplate.class);
//        SysProperties sysProperties = getApplicationContext().getBean("sysProperties", SysProperties.class);
//        ObjectMapper objectMapper = getApplicationContext().getBean("jacksonObjectMapper", ObjectMapper.class);
//        Text text = new Text();
//        text.setContent(msg);
//        DdMsgBody msgBody = DdMsgBody.builder().msgtype("text").text(text).build();
//        String json = null;
//        try {
//            json = objectMapper.writeValueAsString(msgBody);
//        } catch (JsonProcessingException e) {
//            //不记录日志，有可能死循环
//            //log.error("error", e);
//        }
//        if (null == json) {
//            return null;
//        }
//        HttpEntity<String> formEntity = new HttpEntity<>(json, headers);
//        String formatUrl = String.format(url, sysProperties.getWaringDingdingToken());
//        Map<String, Object> result = restTemplate.postForObject(formatUrl, formEntity, Map.class);
//        return result;
//    }
//
//    private ApplicationContext getApplicationContext() {
//        return ApplicationContextUtils.getApplicationContext();
//    }
//
//    @Builder
//    @Data
//    private static class DdMsgBody {
//        private String msgtype;
//        private Text text;
//    }
//
//    @Data
//    private class Text {
//        private String content;
//    }

}