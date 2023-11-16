import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) {
        try {

            InputStream is = new FileInputStream("D:\\back.jpg");
            Socket socket=new Socket("127.0.0.1",9999);
            System.out.println("客户端开始链接");
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //3.先发送一个字符串给服务端：这里可以先发送文件的后缀
            dos.writeUTF(".jpg");
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))>0){
                dos.write(buffer,0,len);
            }
            dos.flush();
            socket.shutdownOutput();

        }catch (Exception e){
         e.printStackTrace();
        }

    }
}
