package backpack;

public class CkeckArea {
    static double x;
    static double y;
    static double r;
    CkeckArea(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    static String Check(double x, double y, double r){
        if ((x * x + y * y <= r * r / 4 && x >= 0 && y <= 0) ||
                (((y+x/2) <= r/2) && x >= 0 && y >= 0) ||
                (-y <=r && -x <= r/2 && y <= 0 && x <= 0)) {
            return  "true";
        } else {
            return  "false";
        }
    }
}
