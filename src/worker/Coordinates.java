package worker;

public class Coordinates {
    private float x;
    private double y;

    public Coordinates(float x, double y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean equals(Coordinates coordinates){
        if (coordinates == null) return false;
        return this.x == coordinates.getX() &&
                this.y == coordinates.getY();
    }

    public String toString(){
        return x + " " + y;
    }
}
