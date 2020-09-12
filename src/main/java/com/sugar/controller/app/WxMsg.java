package com.sugar.controller.app;

import com.sugar.infrastructure.enums.EventType;
import com.sugar.infrastructure.enums.MessageType;
import com.sugar.infrastructure.utils.XmlUtils;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * Created by zhanghongqun on 2020/6/28.
 */
public class WxMsg {

    /**
     *
     * */
    @Data
    @XStreamAlias("xml")
    public static class MsgTemplate {
        @XmlUtils.XStreamCDATA
        private String ToUserName;
        @XmlUtils.XStreamCDATA
        private String FromUserName;
        @XmlUtils.XStreamCDATA
        private Long CreateTime;
        @XmlUtils.XStreamCDATA
        private MessageType MsgType;
        @XmlUtils.XStreamCDATA
        private EventType Event;
    }

    /**
     * 点击菜单跳转事件
     */
    @Data
    public static class JumpFromMenu extends MsgTemplate {

        @XStreamAlias("EventKey")
        private String EventKey;
        private String MenuID;
    }

    /**
     * 上报地理位置
     */
    @Data
    public static class Location extends MsgTemplate {
        private String Latitude;
        private String Longitude;
        private String Precision;
    }

}
