import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/**
 * 服务端开发接收任意文件，并保存
 */

public class NioSelectorServer {
    public static void main(String[] args) {
        try {

            //创建channel
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //channel绑定端口
            ssc.configureBlocking(false);
            //创建selector
            Selector selector = Selector.open(); //没有使用 new
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            ssc.bind(new InetSocketAddress(9999));
            while (true) {
                selector.select(); //
                // 4. 处理事件, selectedKeys 内部包含了所有发生的事件
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator(); // accept, read //🍒
                while (iter.hasNext()) {
                    SelectionKey next = iter.next();
                    System.out.println("key is " + next);
                    if (next.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                        SocketChannel accept = channel.accept();

                    }

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
