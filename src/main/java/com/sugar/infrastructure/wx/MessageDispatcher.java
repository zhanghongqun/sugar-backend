package com.sugar.infrastructure.wx;

import com.sugar.controller.app.WxMsg;
import com.sugar.infrastructure.enums.EventType;
import com.sugar.infrastructure.enums.MessageType;
import com.sugar.infrastructure.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhanghongqun on 2020/7/10.
 */
@Component
public class MessageDispatcher {

    @Autowired
    org.springframework.context.ApplicationContext context;

    public String dispatch(String messageStr) {
        WxMsg.MsgTemplate msgTemplate = XmlUtils.fromXMLIgnoreUnknownElements(messageStr, WxMsg.MsgTemplate.class);
        if (msgTemplate.getMsgType() == MessageType.EVENT) {
            if (msgTemplate.getEvent() == EventType.CLICK) {
                msgTemplate = XmlUtils.fromXMLIgnoreUnknownElements(messageStr, WxMsg.Location.class);
                context.publishEvent(msgTemplate);
            }
        }
        return "";
    }

}
