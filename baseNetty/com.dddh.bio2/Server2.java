import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 单个客户端多发，服务端多收
 * 多个客户端多发，服务端无法接收
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(9999);
//            while (true){
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                BufferedReader bs=new BufferedReader(new InputStreamReader(inputStream));
                System.out.print("scoket读取的字节: ");
                String msg  ;

                // 在12行直接加while(true)强行监听链接也不行，因为代码程序已经在20行进入循环判断了，所以无法接收多个客户端
                while ((msg=bs.readLine())!=null){
                    System.out.println("服务端消息: "+msg);
                }
//            }

    }
}
