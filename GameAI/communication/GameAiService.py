import game_ai_pb2_grpc
import game_ai_pb2
import numpy as np
from ai.ai_handler import AiHandler


class GameAiService(game_ai_pb2_grpc.GameAiServicer):
    def GiveBestMove(self, request, context):
        received_board = []

        for board_array in request.boardArray:
            row = []
            for value in board_array.array:
                row.append(value)
            received_board.append(row)

        print("Got Board: ", received_board)
        best_move = AiHandler().give_best_move(np.array(received_board))
        print("Returning bestCol: ", best_move)
        return game_ai_pb2.ColumnReply(bestColumn=best_move)
