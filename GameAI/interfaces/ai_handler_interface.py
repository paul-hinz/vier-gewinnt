from abc import abstractmethod, ABC


class IAiHandler(ABC):
    @abstractmethod
    def give_best_move(self, board_array):
        pass
