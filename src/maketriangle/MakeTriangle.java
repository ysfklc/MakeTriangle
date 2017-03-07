package maketriangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MakeTriangle {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Which file do you want to read(Enter 1, 2, or 3)??");//this line ask to user the which file do you want to read..
        Scanner input =new Scanner(System.in);
        int sayı =input.nextInt();
        String klm=null;
        int i=0,say=0;
        BufferedReader br = new BufferedReader(new FileReader("input_"+sayı+".txt"));
        String satir = br.readLine();
        while (satir!=null) {
          if(satir.length()>0){
           say++;
          }
          satir = br.readLine();                
         }  
        br.close();
        BufferedReader br1 = new BufferedReader(new FileReader("input_"+sayı+".txt"));
        Point[] p=new Point[10];//max #points is 10
        while ((klm = br1.readLine()) != null) {
        String[] ayr=klm.split(", ");
        p[i]=new Point(Double.parseDouble(ayr[0]),Double.parseDouble(ayr[1]));
        i++;
        }
        br1.close();
        int fct;                    //int these lines I calculate 
        fct=say*(say-1);            //how many lines will be create..
        fct=fct/2;                  //combination of the #points of 2.. 
        Line[] l=new Line[fct];
        int j=0,k;
        int q;
        int h=1;
        Triangle[] t=new Triangle[120];   //combination of 10 to 3=120..
        for(j=0;j<say-2;j++){
            for(k=j+1;k<say-1;k++){
                for(q=k+1;q<say;q++){
                    double area=p[j].getX()*(p[k].getY()-p[q].getY())+p[k].getX()*(p[q].getY()-p[j].getY())+p[q].getX()*(p[j].getY()-p[k].getY());
                    //if area is different from 0 ;triangle will be create. 
                    if(area!=0){
                        double s1l=Math.sqrt(Math.abs(((p[k].getX()-p[j].getX())*(p[k].getX()-p[j].getX()))+((p[k].getY()-p[j].getY())*(p[k].getY()-p[j].getY()))));
                        double s2l=Math.sqrt(Math.abs(((p[q].getX()-p[j].getX())*(p[q].getX()-p[j].getX()))+((p[q].getY()-p[j].getY())*(p[q].getY()-p[j].getY()))));
                        double s3l=Math.sqrt(Math.abs(((p[k].getX()-p[q].getX())*(p[k].getX()-p[q].getX()))+((p[k].getY()-p[q].getY())*(p[k].getY()-p[q].getY()))));
                        if((Math.abs(s1l-s2l)<s3l && s3l<s1l+s2l) && (Math.abs(s1l-s3l)<s2l && s2l<s1l+s3l) && (Math.abs(s2l-s3l)<s1l && s1l<s2l+s3l)){
                            l[0]=new Line(p[j],p[k],s1l);
                            l[1]=new Line(p[j],p[q],s2l);
                            l[2]=new Line(p[k],p[q],s3l);
                            double perimeter=l[0].getLength()+l[1].getLength()+l[2].getLength();
                            t[h]=new Triangle(l[0],l[1],l[2],perimeter); 
                            h++;
                        }
                    }
                } 
            }
        }
        FileWriter fw = new FileWriter("output_"+sayı+".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Triangles");
        for(int z=1;z<h;z++){
            pw.print(z+", ");
            pw.printf("%.2f\n",t[z].getPerimeter());
        }
        pw.close(); 
    }
}

