from concurrent import futures

import grpc
import game_ai_pb2_grpc
from communication.GameAiService import GameAiService


def serve():
    port = "50051"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    game_ai_pb2_grpc.add_GameAiServicer_to_server(GameAiService(), server)
    server.add_insecure_port("[::]:" + port)
    server.start()
    print("Server started, listening on " + port)
    server.wait_for_termination()


if __name__ == "__main__":
    serve()
