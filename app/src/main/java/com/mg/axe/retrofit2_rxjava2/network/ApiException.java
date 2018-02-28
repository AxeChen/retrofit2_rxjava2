package com.mg.axe.retrofit2_rxjava2.network;

/**
 * Created by Zaifeng on 2018/2/28.
 * 异常处理
 */

public class ApiException extends Exception {
    private String code;
    private String displayMessage;

    public ApiException(String code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public ApiException(String message, String code, String displayMessage) {
        super(message);
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }


}
