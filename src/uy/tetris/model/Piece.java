package uy.tetris.model;

import uy.tetris.constants.TetrisConstants;

public abstract class Piece {

    protected int[] positions = {0,1,2,3};
    protected int currentPosition = 0;

    // Every shape has 4 points
    protected Point[] currentShape = new Point[4];

    // represents the coordinates of shape[0]
    protected Point currentStartPoint;

    public Piece(){

        // default position
        currentPosition = 0;

        // start the piece from top bottom
        currentStartPoint = new Point(TetrisConstants.boardSizeX/2-1, 0);
    }

    // Returns shape of the piece by its coordinates
    public abstract Point[] getShape();

    public Point createNewPoint(Point startPoint, int xIndex, int yIndex) {
        return new Point(startPoint.getxPosition()+xIndex, startPoint.getyPosition()+yIndex);
    }

    // direction 0: left
    // direction 1: right
    // direction 2: down
    // direction 3: up
    public void move(int direction) {
        if(direction == TetrisConstants.MOVE_DIRECTION_LEFT) {
            currentStartPoint.setxPosition(currentStartPoint.getxPosition()-1);
        } else if(direction == TetrisConstants.MOVE_DIRECTION_RIGHT) {
            currentStartPoint.setxPosition(currentStartPoint.getxPosition()+1);
        } else if(direction == TetrisConstants.MOVE_DIRECTION_DOWN){
            currentStartPoint.setyPosition(currentStartPoint.getyPosition()+1);
        } else {
            currentStartPoint.setyPosition(currentStartPoint.getyPosition()-1);
        }
    }

    // direction 0: clockwise
    // direction 1: counterclockwise
    public void rotate(int direction) {
        if(direction == TetrisConstants.ROTATE_DIRECTION_CLOCKWISE) {
            currentPosition = currentPosition-1;
            if(currentPosition<0) {
                currentPosition = positions.length -1;
            }
        } else {
            currentPosition = currentPosition+1;
            if(currentPosition>=positions.length) {
                currentPosition = 0;
            }
        }
    }

}
