import java.awt.*;

public abstract class Mesh {
    private final Color color;
    public Color color(){
        return color;
    }

    public abstract double intersect(Ray ray);

    public abstract Vector3 normal(Vector3 position);
    private Vector3 position;

    public Vector3 getPosition() {
        return position;
    }

    public Mesh(Vector3 position, Color color){
        this.position = position;
        this.color = color;
    }
}
