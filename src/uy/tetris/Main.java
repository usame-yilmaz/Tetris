package uy.tetris;

import uy.tetris.constants.TetrisConstants;
import uy.tetris.model.*;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Piece getRandomPiece() {
        Piece[] pieces = new Piece[5];
        pieces[0] = new LeftVertical();
        pieces[1] = new RightVertical();
        pieces[2] = new LeftRightVertical();
        pieces[3] = new Square();
        pieces[4] = new Horizontal();

        Random rand = new Random();

        return pieces[rand.nextInt(TetrisConstants.PIECES_COUNT)];
    }

    public  static Piece newPiece(Board board) throws Exception {
        Piece randomPiece = getRandomPiece();

        board.placeShapeInBoard(randomPiece.getShape());

        board.printCurrentBoard();
        return randomPiece;
    }

    public static void main(String[] args) {

        boolean isOver = false;
        boolean newPieceRequired = true;
        boolean rollbacked = false;

        Board board = new Board();
        board.clearBoard();
        Piece randomPiece = new Piece() {
            @Override
            public Point[] getShape() {
                return new Point[0];
            }
        };

        while(!isOver) {
            board.clearBoard();

            if(newPieceRequired) {
                try {
                    randomPiece = newPiece(board);
                } catch(Exception ex) {
                    isOver = true;
                    System.out.println(TetrisConstants.GAME_OVER);
                    continue;
                }
                newPieceRequired = false;
            }

            System.out.println(TetrisConstants.MAKE_MOVE);

            Scanner s = new Scanner(System.in);
            String ch = s.next();
            switch (ch) {
                case "a":
                    randomPiece.move(TetrisConstants.MOVE_DIRECTION_LEFT);
                    try {
                        board.placeShapeInBoard(randomPiece.getShape());
                    } catch (Exception e) {
                        System.out.println(TetrisConstants.INVALID_MOVE);
                        randomPiece.move(TetrisConstants.MOVE_DIRECTION_RIGHT);
                        rollbacked = true;
                    }
                    break;
                case "d":
                    randomPiece.move(TetrisConstants.MOVE_DIRECTION_RIGHT);
                    try {
                        board.placeShapeInBoard(randomPiece.getShape());
                    } catch (Exception e) {
                        System.out.println(TetrisConstants.INVALID_MOVE);
                        randomPiece.move(TetrisConstants.MOVE_DIRECTION_LEFT);
                        rollbacked = true;
                    }
                    break;
                case "w":
                    randomPiece.rotate(TetrisConstants.ROTATE_DIRECTION_CLOCKWISE);
                    try {
                        board.placeShapeInBoard(randomPiece.getShape());
                    } catch (Exception e) {
                        System.out.println(TetrisConstants.INVALID_MOVE);
                        randomPiece.rotate(TetrisConstants.ROTATE_DIRECTION_COUNTERCLOCKWISE);
                        rollbacked = true;
                    }
                    break;
                case "s":
                    randomPiece.rotate(TetrisConstants.ROTATE_DIRECTION_COUNTERCLOCKWISE);
                    try {
                        board.placeShapeInBoard(randomPiece.getShape());
                    } catch (Exception e) {
                        System.out.println(TetrisConstants.INVALID_MOVE);
                        randomPiece.rotate(TetrisConstants.ROTATE_DIRECTION_CLOCKWISE);
                        rollbacked = true;
                    }
                    break;
                default :
                    System.out.println(TetrisConstants.INVALID_MOVE);
                    break;
            }

            if(rollbacked) {
                rollbacked = false;
                continue;
            }

            board.clearBoard();
            randomPiece.move(TetrisConstants.MOVE_DIRECTION_DOWN);
            try {
                board.placeShapeInBoard(randomPiece.getShape());
            } catch (Exception e) {
                randomPiece.move(TetrisConstants.MOVE_DIRECTION_UP);
                newPieceRequired = true;
                board.addPiece(randomPiece);
                continue;
            }
            board.printCurrentBoard();
        }
    }
}
