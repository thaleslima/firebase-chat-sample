package com.gdgcampinas.chat_firebase;

/**
 * Class that represent the message.
 */
public class Chat {
    public String message;
    public String id;

    public Chat() {
    }

    public Chat(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
