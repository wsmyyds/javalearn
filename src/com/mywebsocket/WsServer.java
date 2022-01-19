package com.mywebsocket;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: javalearn
 * @description:
 * @author:
 * @create:
 **/
public class WsServer extends WebSocketServer {

    static {
        BasicConfigurator.configure();
    }
    private static Logger log = Logger.getLogger(WsServer.class);
    private static int userid = 1;
    public static final HashMap<WebSocket, Integer> users = new HashMap<>();

    public WsServer(int port) {

        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

        System.out.println(clientHandshake.getResourceDescriptor());
        log.info("--------------------onOpen--------------------");
        System.out.println(webSocket.getRemoteSocketAddress()+"已连接");
        webSocket.send("服务器:hello,用户"+userid+"你已成功连接");
        String str = "用户"+userid+"加入聊天";
        users.put(webSocket, userid);
        broadcastMsg(webSocket,str);
        userid++;
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

        log.info("--------------------onClose--------------------");
        users.remove(webSocket);
        String str = "用户"+users.get(webSocket)+"退出聊天";
        broadcastMsg(webSocket,str);
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {

        log.info("--------------------onMessage--------------------");
        System.out.println("收到" + webSocket.getRemoteSocketAddress() + "的消息:" + s);
        //webSocket.send("回复" + webSocket.getRemoteSocketAddress());
        broadcastMsg(webSocket,s);

    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

        log.info("--------------------onError--------------------");
        webSocket.send("出错了...");
    }

    @Override
    public void onStart() {

        log.info("--------------------Server onStart--------------------");
    }

    public void broadcastMsg(WebSocket webSocket, String s){

        for (Map.Entry<WebSocket, Integer> user:
                users.entrySet()) {
                user.getKey().send("用户"+users.get(webSocket)+":"+s);
        }
    }
}
