package com.xwb.consumer;

import com.xwb.common.constant.TopicConst;
import com.xwb.common.message.PayMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 类的功能描述：
 * 消息消费者者用于处理消息
 *
 * @ClassName: MessageConsumer
 * @Author haichen
 * @Date 2017-09-13 03:45:55
 */
@Service
public class MessageConsumer {
    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = TopicConst.PAY_TOPIC)
    public void onMessage(String payMessage) {
        System.out.println("tem");
        PayMessage msg = gson.fromJson(payMessage, PayMessage.class);
        logger.info("MessageConsumer: onMessage: message is: [" + msg + "]");
    }
}