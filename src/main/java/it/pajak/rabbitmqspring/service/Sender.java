package it.pajak.rabbitmqspring.service;

import com.google.gson.Gson;
import it.pajak.rabbitmqspring.model.Letter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Gson gson;

    private Letter letter;

    public void sendLetter() {
        rabbitTemplate.convertAndSend("ReceiverAddress", gson.toJson(letter));
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }
}
