import java.io.*;
import java.net.Socket;

public class ServerFileThread extends Thread {
    private Socket socket;

    public ServerFileThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String fileName = dataInputStream.readUTF();
            OutputStream os=new FileOutputStream("D:\\dddh\\test"+System.currentTimeMillis()+fileName);
            byte[] buffer=new byte[1024];
            int len;
            //读取次数
            int i = 0;
            while ((len=dataInputStream.read(buffer))>0){
                System.out.println("第"+(i++)+"次读取,读取长度："+len);
                os.write(buffer,0,len);
            }
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}