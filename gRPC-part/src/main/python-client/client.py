import grpc
import pingpong_pb2
import pingpong_pb2_grpc


def run():
    print("Python client starting ...")
    with grpc.insecure_channel("localhost:9090") as channel:
        stub = pingpong_pb2_grpc.PingPongStub(channel)
        request = pingpong_pb2.SendPingPong(pingWord="Ping...", gameName="small tennis")
        response = stub.SendPingPong(request)
    print("responce from Python client: " + response.gameDescription + ", pongResponse " + response.pongWord)


run()
