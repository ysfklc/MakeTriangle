package maketriangle;
public class Triangle {
    private Line side1;
    private Line side2;
    private Line side3;
    private double perimeter;
    public Triangle(){
        
    }
    public Triangle(Line side1,Line side2,Line side3,double perimeter){
    this.side1=side1;
    this.side2=side2;
    this.side3=side3;
    this.perimeter=perimeter;
}
    public void setSide1(Line side1){
        this.side1=side1;
    }
    public void setSide2(Line side2){
        this.side2=side2;
    }
    public void setSide3(Line side3){
        this.side3=side3;
    }
    public void setPerimeter(double perimeter){
        perimeter=this.side1.getLength()+this.side2.getLength()+this.side3.getLength();
        this.perimeter=perimeter;
    }
    public Line getSide1(){
        return side1;
    }
    public Line getSide2(){
        return side2;   
    }
    public Line getSide3(){
        return side3;   
    }
    public double getPerimeter(){
        return perimeter;
    }
}
