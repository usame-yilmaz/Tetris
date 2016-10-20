package uy.tetris.model;

/**
 * Created by biff on 20.10.2016.
 */
public class LeftVertical extends Piece {
    public Point[] getShape() {

        switch (currentPosition)  {
            case 0 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,0,1);
                this.currentShape[2] = createNewPoint(currentStartPoint,0,2);
                this.currentShape[3] = createNewPoint(currentStartPoint,-1,2);
                break;
            case 1 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,0,1);
                this.currentShape[2] = createNewPoint(currentStartPoint,1,1);
                this.currentShape[3] = createNewPoint(currentStartPoint,2,1);
                break;
            case 2 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,1,0);
                this.currentShape[2] = createNewPoint(currentStartPoint,0,1);
                this.currentShape[3] = createNewPoint(currentStartPoint,0,2);
                break;
            case 3 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,1,0);
                this.currentShape[2] = createNewPoint(currentStartPoint,2,0);
                this.currentShape[3] = createNewPoint(currentStartPoint,2,1);
                break;

        }
        return currentShape;
    }
}
