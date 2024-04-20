package me.symi.carshop.rest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CarErrorResponse {

    private int status;
    private String message;
    private String timeStamp;

    public CarErrorResponse() {

    }

    public CarErrorResponse(int status, String message, String timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long currentTimeMillis) {
        Timestamp ts = new Timestamp(currentTimeMillis);
        this.timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(ts);
    }

}
