import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 服务端单发，单收
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader bs=new BufferedReader(new InputStreamReader(inputStream));
            System.out.print("scoket读取的字节: ");
            String msg  ;

            // 这里使用if跟while是不同的，
            //while会一直监听，相当于一次连接，客户端必须持续不断的发送消息
            //如果发送一条或者N条中断，服务端会出现connection reset因为检测到client消息没发完，已经关闭连接了
            //如果是if ，就是每次判断有没有一行数据，如果没有就不读取，这里没有包含客户端连接中断，连接中断，服务端不会抛出异常
            //除非client跟server全是while true不停的发送消息，才会正常，中间有中断是触发connection reset
            if ((msg=bs.readLine())!=null){
                System.out.println("服务端消息: "+msg);
            }
    }
}
