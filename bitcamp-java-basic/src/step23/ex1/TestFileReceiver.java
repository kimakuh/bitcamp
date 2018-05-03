package step23.ex1;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestFileReceiver {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("준비완료");
        Socket socket = serverSocket.accept();

        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        
        
        
        

        while (true) {
            // 클라이언트가 보낸 문자열을 수신한다.
            String str = in.nextLine();
            System.out.println(str);

            // 키보드 입력을 받아서 클라이언트로 송신한다.
            System.out.print("입력> ");
            String input = keyScan.nextLine();
            out.println(input);

            if (str.equals("quit"))
                break;
        }

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        keyScan.close();
    }

    ServerSocket server = new ServerSocket(5555);

    System.out.println("ready server....");

    Socket socket = server.accept();

    System.out.println("client connected..."+socket);

    DataOutputStream clientDos

            = new DataOutputStream(socket.getOutputStream());

    String title = "My Fathers Eyes.mp3";

    clientDos.writeUTF(title);

    InputStream in = new FileInputStream("C:\\zzz\\My Fathers Eyes.mp3");

    byte[] buffer = new byte[1024*8];

    while(true)
    {

        int count = in.read(buffer);

        if (count == -1) {

            break;

        }

        clientDos.write(buffer, 0, count);

    }

    clientDos.flush();

    clientDos.close();

}

}