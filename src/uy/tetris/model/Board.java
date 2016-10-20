package uy.tetris.model;

import uy.tetris.constants.TetrisConstants;

import java.util.ArrayList;

/*
*  Board is a two-dimensional matrix,
*  x-y indexes start at top-left
 */
public class Board {

    private int sizeX = TetrisConstants.boardSizeX, sizeY=TetrisConstants.boardSizeY;
    private char [][] currentBoard = new char[sizeX][sizeY];
    private char [][] lastBoard = new char[sizeX][sizeY];

    ArrayList<Piece> pieces = new ArrayList<Piece>();

    // mark only the borders of the board
    public void clearBoard() {
        for (int i = 0; i < sizeX; i++) {
            for (int y = 0; y < sizeY; y++) {
                if(i==0 || i==sizeX-1 || y==sizeY-1) {
                    currentBoard[i][y] = '*';
                } else {
                    currentBoard[i][y] = ' ';
                }
            }
        }

        for (Piece piece : pieces) {
            try {
                placeShapeInBoard(piece.getShape());
            } catch (Exception e) {
                System.out.println("Error adding existing shape");
            }
        }
    }

    public void placeShapeInBoard(Point[] shape) throws Exception{

        char [][] newBoard = currentBoard;

        for (Point point : shape) {
            if( currentBoard[point.getxPosition()][point.getyPosition()] == '*') {
                throw new Exception();
            } else {
                newBoard[point.getxPosition()][point.getyPosition()] = '*';
            }
        }
        currentBoard = newBoard;
    }

    public void printCurrentBoard() {

        for (int y = 0; y < sizeY; y++) {
            for (int i = 0; i < sizeX; i++) {
                System.out.print(currentBoard[i][y]);
            }
            System.out.println();
        }
    }

    public void addPiece(Piece piece){
        pieces.add(piece);
    }

}
