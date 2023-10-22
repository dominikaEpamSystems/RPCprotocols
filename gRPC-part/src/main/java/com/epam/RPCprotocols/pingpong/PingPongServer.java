package com.epam.RPCprotocols.pingpong;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PingPongServer {
    private static final Logger logger = Logger.getLogger(PingPongServer.class.getName());

    private Server server;

    private void start() throws IOException {
        int port = 50051;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new PingPongImpl())
                .build()
                .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    PingPongServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final PingPongServer server = new PingPongServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class PingPongImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

        @Override
        public void sendPingPong(PingPongRequest req, StreamObserver<PingPongReply> responseObserver) {
            PingPongReply reply = PingPongReply.newBuilder().setMessage("Ping " + req.getMessage()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
