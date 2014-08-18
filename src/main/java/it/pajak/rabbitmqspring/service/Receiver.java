package it.pajak.rabbitmqspring.service;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import it.pajak.rabbitmqspring.model.Letter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver implements ChannelAwareMessageListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Gson gson;

    private void receiveLetter(Letter letter) {
        System.out.println(letter);
    }

    @Override
    public void onMessage(Message amqpMessage, Channel channel) throws Exception {
        Letter letter = gson.fromJson(new String(amqpMessage.getBody()), Letter.class);
        receiveLetter(letter);
    }
}
