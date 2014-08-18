package it.pajak.rabbitmqspring.model;

public class Letter {

    private String sender;
    private String content;

    @Override
    public String toString() {
        return "Mail from: " + sender + "\nContent: " + content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
