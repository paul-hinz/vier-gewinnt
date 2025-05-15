package code.communication.gameai;

import code.controller.communication.gameai.BoardStateRequest;
import code.controller.communication.gameai.ColumnReply;
import code.controller.communication.gameai.GameAiGrpc;
import code.controller.communication.gameai.SingleDimensionArray;
import code.model.GameAI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Arrays;

public class GameAiImpl implements GameAI {

    @Override
    public int findBestMove(int[][] board) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(
                        "10.8.0.6", 50051) // Put here Server IP and Port
                .usePlaintext().build();

        GameAiGrpc.GameAiBlockingStub stub = GameAiGrpc.newBlockingStub(managedChannel);
        ColumnReply columnReply = stub.giveBestMove(arrayToBoardStateRequest(board));

        return columnReply.getBestColumn();
    }

    public static BoardStateRequest arrayToBoardStateRequest(int[][] board) {
        int[][] convertedBoard = convertToAiSupportedArray(board);

        BoardStateRequest.Builder boardStateRequestBuilder = BoardStateRequest.newBuilder();

        for (int[] row : convertedBoard) {
            SingleDimensionArray.Builder arrayBuilder = SingleDimensionArray.newBuilder();
            for (int rowValue : row) {
                arrayBuilder.addArray(rowValue);
            }
            boardStateRequestBuilder.addBoardArray(arrayBuilder.build());
        }

        return boardStateRequestBuilder.build();
    }

    public static int[][] convertToAiSupportedArray(int[][] board) {
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            boardCopy[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (int i = 0; i < boardCopy.length; i++) {
            for (int j = 0; j < boardCopy[i].length; j++) {
                if (boardCopy[i][j] == 2) {
                    boardCopy[i][j] = -1;
                }
            }
        }

        return boardCopy;
    }
}
