import math
import numpy as np
import torch as torch
from connect_four.game_logic import GameLogic

c_puct = 2
game = GameLogic()


# This Document implements the Monte Carlo Tree Search with Node Objects
class BoardStateNode:
    def __init__(self, board_state, parent_node, move, probability):
        self.board_state = board_state
        self.probability = probability
        self.move = move
        self.amount_of_visits = 0
        self.w_value = 0
        self.ucb_value = 0.0

        self.parent_node = parent_node
        self.children = []

    def compute_ucb(self):
        q = 0 if self.amount_of_visits == 0 else 1 - (self.w_value / self.amount_of_visits)

        # TODO This could be also working?: q = 0 if self.amount_of_visits == 0 else (
        #                 1 - ((self.w_value / self.amount_of_visits) + 1) / 2) for self play)

        a = (math.sqrt(self.parent_node.amount_of_visits)) / (1 + self.amount_of_visits)
        # print(q + c_puct * board_state_node.probability * a)
        self.ucb_value = q + c_puct * self.probability * a
        return self.ucb_value

    # Method for selection phase
    # Iterates over children, calculates UCB and takes the best
    def selection(self):
        return max(self.children, key=lambda node: node.compute_ucb())

    def expansion(self, move, probability):
        # the node who got selected in selection phase calls these method
        # we just have to create children from that node based on the models probability
        # we also have to consider how to switch players

        # we have to append child node(s) to this node
        # and also set to the child nodes this node as parent
        # board will be copied for mcts iterations

        new_state = game.make_move(move, self.board_state.copy(), 1)
        child_node = BoardStateNode(new_state * -1, self, move, probability)
        self.children.append(child_node)

        return child_node

    def backpropagation(self, v_value):
        # go tree recursively upwards and add v_value
        # to the v_value of the parent nodes

        self.w_value += v_value
        self.amount_of_visits += 1
        v_value *= -1

        if self.parent_node is not None:
            self.parent_node.backpropagation(v_value)

    def __repr__(self):
        # For debugging
        return "w:{w} ucb:{u} prob:{p}".format(u=self.ucb_value, w=self.w_value, p=self.probability)


class MCTS:
    def __init__(self, game):
        self.game = game

    """
    Takes a root state where oneself (1) will make the next move.
    :return: the probabilities of the best move
    """

    @torch.no_grad
    def mcts(self, root_state, amount_iterations, model):
        device = torch.device("cuda" if torch.cuda.is_available() else "cpu")

        root_node = BoardStateNode(root_state, None, None, None)
        for i in range(amount_iterations):
            # start every iteration from root node
            node = root_node

            # recursively go down the mcts tree and through just optimal nodes (ucb)
            # as long as one node comes which has undiscovered children
            while len(node.children) > 0:  # if |node.children| > 0 it has already expanded all nodes
                node = node.selection()

            # if game.check_game_terminated(node.board_state):
            #     print("leaf node, where won or draw")

            if self.game.check_win_for_player(node.board_state, -1):
                value = -1
            elif self.game.check_for_draw(node.board_state):
                value = 0
            else:
                # Game has to be ongoing, because 1 can't be the winner
                encoded_state = np.stack(
                    (node.board_state == -1, node.board_state == 0, node.board_state == 1)
                ).astype(np.float32)

                probabilities, value = model(
                    torch.tensor(encoded_state, device=device).unsqueeze(0)
                )
                value = value.item()
                probabilities = torch.softmax(probabilities, axis=1).squeeze(0).cpu().numpy()

                possible_moves = self.game.possible_moves(node.board_state)
                for j in range(len(probabilities)):
                    if j in possible_moves:
                        node.expansion(j, probabilities[j])
                    else:
                        probabilities[j] = 0

            node.backpropagation(value)

        # return array of probability and action
        visits = np.zeros(7)

        for root_child in root_node.children:
            visits[root_child.move] = root_child.amount_of_visits

        assert np.sum(visits) > 0
        probabilities = visits / np.sum(visits)

        return probabilities


# debugging
def print_recursively(node, level=1):
    print(("-" * level), "{n}".format(n=node))
    for node in node.children:
        print_recursively(node, level + 1)
