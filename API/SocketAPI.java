import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (c) 2017 XiaoMi Inc. All Rights Reserved.
 *
 * @author: linzebin <linzebin@xiaomi.com>
 * Created on 2019/7/29
 */

public class SocketAPI {
    public static void main(String[] args) {
        try {
            ExecutorService threadPool = Executors.newCachedThreadPool();
            ServerSocket serverSocket = new ServerSocket(7777);


            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                while (true) {
                    int len = inputStream.read(bytes);
                    if (len != -1) {
                        String info = new String(bytes, 0, len);
                        System.out.println(info);
                    } else {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
