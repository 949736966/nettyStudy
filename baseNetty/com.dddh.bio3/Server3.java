import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 多个客户端多发，服务端多收
 * 多个客户端多发，服务端使用多个线程进行接收，这里线程数量有限，需要引入线程池进行管理分配
 */
public class Server3 {
    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                Socket accept = serverSocket.accept();
                new ServerThread(accept).start();
            }

    }
}
