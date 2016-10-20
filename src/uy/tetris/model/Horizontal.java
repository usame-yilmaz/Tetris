package uy.tetris.model;

public class Horizontal extends Piece {

    public Point[] getShape() {

        switch (currentPosition)  {
            case 0 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,1,0);
                this.currentShape[2] = createNewPoint(currentStartPoint,2,0);
                this.currentShape[3] = createNewPoint(currentStartPoint,3,0);

                this.currentShape[1] = new Point(this.currentStartPoint.getxPosition()+1, this.currentStartPoint.getyPosition());
                this.currentShape[2] = new Point(this.currentStartPoint.getxPosition()+2, this.currentStartPoint.getyPosition());
                this.currentShape[3] = new Point(this.currentStartPoint.getxPosition()+3, this.currentStartPoint.getyPosition());
                break;
            case 1 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,0,1);
                this.currentShape[2] = createNewPoint(currentStartPoint,0,2);
                this.currentShape[3] = createNewPoint(currentStartPoint,0,3);

                this.currentShape[1] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+1);
                this.currentShape[2] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+2);
                this.currentShape[3] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+3);
                break;
            case 2 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,1,0);
                this.currentShape[2] = createNewPoint(currentStartPoint,2,0);
                this.currentShape[3] = createNewPoint(currentStartPoint,3,0);

                this.currentShape[1] = new Point(this.currentStartPoint.getxPosition()+1, this.currentStartPoint.getyPosition());
                this.currentShape[2] = new Point(this.currentStartPoint.getxPosition()+2, this.currentStartPoint.getyPosition());
                this.currentShape[3] = new Point(this.currentStartPoint.getxPosition()+3, this.currentStartPoint.getyPosition());
                break;
            case 3 :
                this.currentShape[0] = this.currentStartPoint;
                this.currentShape[1] = createNewPoint(currentStartPoint,0,1);
                this.currentShape[2] = createNewPoint(currentStartPoint,0,2);
                this.currentShape[3] = createNewPoint(currentStartPoint,0,3);

                this.currentShape[1] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+1);
                this.currentShape[2] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+2);
                this.currentShape[3] = new Point(this.currentStartPoint.getxPosition(), this.currentStartPoint.getyPosition()+3);
                break;

        }
        return currentShape;
    }
}

