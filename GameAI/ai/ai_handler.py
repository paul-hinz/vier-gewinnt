import os
from abc import ABC

import numpy as np
import torch

from ai.model import ResNet
from interfaces.ai_handler_interface import IAiHandler
from ai import mcts
from connect_four import game_logic

MCTS_ITERATIONS = 1000


class AiHandler(IAiHandler, ABC):
    def give_best_move(self, board_array):
        # Move prediction can be optimized by using the mcts-algorithm
        # but takes longer for computation than just the model

        # device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        # model = ResNet(9, 128, device)
        #
        # model_path = os.path.join(os.path.dirname(__file__), "model.pt")
        # model.load_state_dict(torch.load(model_path, map_location=device))
        # model.eval()
        # probabilities = mcts.MCTS(game=game_logic.GameLogic()).mcts(board_array, MCTS_ITERATIONS, model)

        # get possibilites just based on the model
        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
        model = ResNet(9, 128, device)

        model_path = os.path.join(os.path.dirname(__file__), "model_1.pt")
        model.load_state_dict(torch.load(model_path, map_location=device))
        model.eval()

        encoded_state = np.stack(
        (board_array == -1, board_array == 0, board_array == 1)
        ).astype(np.float32)

        probabilities, value = model(
            torch.tensor(encoded_state, device=device).unsqueeze(0)
        )

        probabilities = torch.softmax(probabilities, axis=1).squeeze(0).cpu().detach().numpy()
        # print(probabilities)
        # print(np.argmax(probabilities))
        return np.argmax(probabilities)
