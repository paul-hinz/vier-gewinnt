import numpy as np

NO_OF_COL = 7
NO_OF_ROW = 6


class GameLogic:
    def __init__(self):
        self.noCol = NO_OF_COL
        self.noRow = NO_OF_ROW

    def initialize_board(self):
        return np.zeros((self.noRow, self.noCol))

    # Takes a column number which a player took and returns the new board state
    def make_move(self, col_to_play, board, player):
        row = NO_OF_ROW - 1
        while board[row, col_to_play] != 0.0:
            row -= 1

        board[row, col_to_play] = player
        return board

    def check_for_draw(self, board):
        return len(self.possible_moves(board)) == 0

    def possible_moves(self, board):
        moves = []

        for col in range(NO_OF_COL):
            for row in range(NO_OF_ROW - 1, -1, -1):
                if board[row, col] == 0:
                    moves.append(col)
                    break
        return moves

    def check_win_for_player(self, board, player):
        if player == 0:
            return False

        # horizontals
        for row in range(NO_OF_ROW):
            for col in range(NO_OF_COL - 3):
                if board[row, col] == board[row, col + 1] == board[row, col + 2] == board[row, col + 3] == player:
                    return True

        # verticals
        for row in range(NO_OF_ROW - 3):
            for col in range(NO_OF_COL):
                if board[row, col] == board[row + 1, col] == board[row + 2, col] == board[row + 3, col] == player:
                    return True

        # top left corner -> bottom right corner
        for row in range(3):
            for col in range(4):
                if board[row, col] == \
                        board[row + 1, col + 1] == \
                        board[row + 2, col + 2] == \
                        board[row + 3, col + 3] == player:
                    return True

        # bottom left -> top right
        for row in range(3, NO_OF_ROW):
            for col in range(NO_OF_COL - 3):
                if board[row][col] == \
                        board[row - 1][col + 1] == \
                        board[row - 2][col + 2] == \
                        board[row - 3][col + 3] == player:
                    return True

        return False

    def check_game_terminated(self, board):
        return self.check_win_for_player(board, 1) or \
            self.check_win_for_player(board, -1) or \
            self.check_for_draw(board)


# temporary fast test
board_winner_is_one = np.array(
    [
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0],
        [1, -1, 0, -1, -1, 0, 0],
        [1, 1, 1, 1, -1, 0, 0],
        [1, 1, 1, 1, -1, 0, 0],
        [1, -1, 1, -1, 1, 1, -1],
    ]
)
board_winner_is_minus_one = np.array(
    [
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0],
        [-1, -1, 0, -1, 1, 0, 0],
        [-1, 1, -1, 1, -1, 0, 0],
        [-1, 1, -1, 1, -1, 0, 0],
        [-1, -1, 1, 1, -1, 1, 1],
    ]
)

board_draw = np.array(
    [
        [1, -1, -1, 1, 1, -1, 1],
        [-1, -1, -1, 1, 1, -1, -1],
        [1, -1, -1, -1, -1, 1, 1],
        [1, 1, 1, 1, 1, -1, -1],
        [-1, 1, 1, 1, -1, 1, -1],
        [1, -1, 1, -1, 1, 1, -1],
    ]
)

board_draw_2 = np.array(
    [
        [1, -1, 1, -1, 1, -1, 1],
        [1, -1, 1, -1, 1, -1, 1],
        [-1, 1, -1, 1, -1, 1, -1],
        [-1, 1, -1, 1, -1, 1, -1],
        [1, -1, 1, -1, 1, -1, 1],
        [1, -1, 1, -1, 1, -1, 1],
    ]
)

if __name__ == "__main__":
    print(GameLogic().check_win_for_player(board_winner_is_one, 1))
    print(GameLogic().check_win_for_player(board_winner_is_minus_one, -1))

    print(GameLogic().check_game_terminated(board_winner_is_one))
    print(GameLogic().check_game_terminated(board_winner_is_minus_one))
    print(GameLogic().check_game_terminated(board_draw))

    print(GameLogic().check_for_draw(board_draw))
    print(GameLogic().check_for_draw(board_draw_2))
