/*******************************************************************************
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.examples.advanced.lowlevelmodeling.tictactoe;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>Developed by KIT Solutions Pvt. Ltd.</b> (www.kitsol.com) on 24-Aug-16.
 * This program is used for training.(Update the move reward based on the win or loose of the game).
 * Here both player are being played automatically and update probability in AllMoveWithReward.txt.
 * AllMoveWithReward.txt file can be any file containing TicTacToe data generated by running TicTacToeData.java or any other old file
 * updated by this program when run earlier.
 */

public class TicTacToeGameTrainer {

    private static Logger log = LoggerFactory.getLogger(TicTacToeGameTrainer.class);

    public static void main(String[] args) {

        // This is the object of TicTacToePlayer class which contains all methods to make move and find best move and update probability
        // of each move based on winning or losing or drawing the game.
        TicTacToePlayer player = new TicTacToePlayer();

        // selects file contains TicTacToe data generated by running TicTacToeData.java
        // need to set file path containing basic game data which will be updated during training.
        player.setFilePath(System.getProperty("user.home") + "/AllMoveWithReward.txt");

        // thread to start loading of a file asynchronously.
        Thread aiLoad = new Thread(player);
        aiLoad.start();

        // need to set number of games after which you want to write data file with latest data.
        player.setUpdateLimit(1000);

        // This property is set to tell TicTacToePlayer to update probability in data file.
        // data file is not updated if you set this as false.
        // This property is false by default
        player.setAutoUpdate(true);

        // counter to monitor number of games played as training proceeds.
        int totalGameCounter = 0;

        // number of games that player 1 won
        int numberOfWinPlayer1 = 0;

        // number of games that player 2 won
        int numberOfWinPlayer2 = 0;

        // number of games to play during training.
        int playTotalGame = 10000;

        // number of games played as draw games.
        int draw = 0;

        // to control whether a move was of a first player or a second player to request a next board positions from TicTacToePlayer object.
        int tempMoveType = 0;

        // This is a variable to do the training for all 9 empty positions when training starts.
        int movePosition = 0;

        // sets a player number for first player
        // it can be 1 or 2, i.e. X or O.
        int firstPlayerNumber = 1; //1-For First Player and 2- for second Player

        if (firstPlayerNumber == 1) {
            tempMoveType = 2;
        } else if (firstPlayerNumber == 2) {
            tempMoveType = 1;
        }

        // Following logic uses TicTacToePlayer object to play each game and use it to update probability for
        // each won/loose or draw game.
        INDArray board;
        while (true) {
            try {
                Thread.sleep(10);
                int moveType = tempMoveType;
                // checks whether data file is fully loaded or not before moving further in training.
                if (player.isAILoad() == true) {

                    // if played games becomes greater than total number of games to play then exits the loop
                    if (totalGameCounter >= playTotalGame) {
                        break;
                    }

                    // create blank board.
                    board = Nd4j.zeros(1, 9);
                    // board.putScalar(new int[]{0,4}, firstPlayerNumber);

                    // puts X or O (1 or 2 respectively) depending on the first player number.
                    board.putScalar(new int[]{0, movePosition}, firstPlayerNumber);

                    // increases movePosition by 1 to play upto 9 positions of the board
                    movePosition++;

                    // if movePosition becomes greater than 8, then set it to 0 to restart from first position again.
                    if (movePosition > 8) {
                        movePosition = 0;
                    }

                    // increase total games played counter by 1.
                    totalGameCounter++;

                    // print board to console for logging purpose.
                    // we can comment this line if not required.
                    printBoard(board);

                    // below while loop plays actual game automatically.
                    while (true) {

                        // gets next best board move by passing current board state.
                        board = player.getNextBestMove(board, moveType);

                        // prints board.
                        printBoard(board);

                        // verifies current game decision (win or draw)
                        int gameState = player.getGameDecision();

                        // if gameState != 0, means game is finished with a decision
                        if (gameState != 0) {
                            if (gameState == 1) {           // player 1 won
                                numberOfWinPlayer1++;
                            } else if (gameState == 2) {  // player 2 won
                                numberOfWinPlayer2++;
                            } else {  // game is draw
                                draw++;
                            }
                            log.info("\nTotal Game :" + totalGameCounter
                                        +"\n   X Player:" + numberOfWinPlayer1
                                        +"\n   O Player:" + numberOfWinPlayer2
                                        +"\n   XXDrawOO:" + draw);
                            // exit while loop as current game is finished
                            break;
                        }
                        // setting moveType to particular player to request next game board
                        if (moveType == 1) {
                            moveType = 2;
                        } else {
                            moveType = 1;
                        }
                    }
                }
            } catch (Exception e) {
                log.error(e.toString());
            }
        }
    }

    /**
     * Prints the board on a console as given below
     * 0 0 1
     * 2 0 0
     * 0 0 1
     */
    private static void printBoard(INDArray board) {
        int k = 0;
        StringBuilder boardString = new StringBuilder("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int position = (int) board.getDouble(k);
                boardString.append("  " + position);
                k++;
            }
            boardString.append("\n");
        }
        boardString.append("------------\n");
        log.info(boardString.toString());
    }
}

