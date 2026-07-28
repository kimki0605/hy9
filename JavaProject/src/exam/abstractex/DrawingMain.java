package exam.abstractex;

public class DrawingMain {

    public static void main(String[] args) {

        DrawingObject[] obj = new DrawingObject[3];

        obj[0] = new Poly("red");
        obj[1] = new Circle("blue");
        obj[2] = new Rect("green");

        for (DrawingObject d : obj) {
            d.draw();
        }
    }
}