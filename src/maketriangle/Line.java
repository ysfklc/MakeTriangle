package maketriangle;

/**
 *
 * @author yusufalikilic
 */
public class Line {
    private Point start;
    private Point end;
    private double length;
    public Line(Point start,Point end,double length){
        this.start=start;
        this.end=end;
        this.length=length;
    }
    public Line(){
    
    }
    public void setStart(Point start){
        this.start=start;
    }
    public void setEnd(Point end){
        this.end=end;
    }
    public void setLength(double length){
        length=Math.sqrt(Math.pow(this.start.getX()-this.end.getX(),2)+Math.pow(this.start.getY()-this.end.getY(),2));
        this.length=length;
    }        
    public Point getStart(){
        return start;
    }
    public Point getEnd(){
        return end;   
    }
    public double getLength(){
        return length;
    }
}

