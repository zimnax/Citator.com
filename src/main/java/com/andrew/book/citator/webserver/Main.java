package com.andrew.book.citator.webserver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        WebServer webServer = new WebServer(8080);
        try {
            webServer.start();
            webServer.join();
        } catch (Exception e) {
            System.out.println("IO EX occured while starting sever");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
}

