package com.mywebsocket;

/**
 * @program: javalearn
 * @description:
 * @author:
 * @create:
 **/
public class Main {

    public static void main(String[] args) {

        WsServer wsServer = new WsServer(8888);
        wsServer.start();
    }
}
