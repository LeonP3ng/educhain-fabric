package com.steins.entity;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Swingland on 2019/5/17 15:08
 * Tomorrow is a new day!
 */
@WebServlet(name = "Web3JClient")
public class Web3JClient {
    private static String ip = "http://127.0.0.1:8545/";
    private Web3JClient(){}
    private volatile static Web3j web3j;

    public static Web3j getClient(){
        if(web3j==null) {
            synchronized (Web3JClient.class) {
                if (web3j == null) {
                    web3j = Web3j.build(new HttpService(ip));
                }
            }
        }
        return web3j;
    }
}
