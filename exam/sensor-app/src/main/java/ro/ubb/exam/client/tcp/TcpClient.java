package ro.ubb.exam.client.tcp;

import ro.ubb.exam.common.Message;
import ro.ubb.exam.common.SensorService;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class TcpClient {
    private ExecutorService executorService;

    public TcpClient(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public Message sendAndReceive(Message request) {
        try (var socket = new Socket(SensorService.host, SensorService.PORT);
             var is = socket.getInputStream();
             var os = socket.getOutputStream()) {

            System.out.println("sending request: " + request);
            request.writeTo(os);
            System.out.println("request sent");

            Message response = new Message();
            response.readFrom(is);
            System.out.println("received response: " + response);

            return response;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("exception in send and receive", e);
        }

    }
}

