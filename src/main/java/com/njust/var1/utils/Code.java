package com.njust.var1.utils;

public class Code {
    public enum HttpStatus {
        CONTINUE(100, "Continue"),
        SWITCHING_PROTOCOLS(101, "Switching Protocols"),
        PROCESSING(102, "Processing"),
        CHECKPOINT(103, "Checkpoint"),
        OK(200, "OK");

        HttpStatus(int i, String aContinue) {
        }
    }
}


