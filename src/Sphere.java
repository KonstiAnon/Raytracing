import java.awt.*;

public class Sphere extends Mesh {
    private final double radius;

    public Sphere(Vector3 position, Color color, double radius) {
        super(position, color);
        this.radius = radius;
    }

    @Override
    public double intersect(Ray ray) {
        Vector3 oc = ray.origin().sub(getPosition());
        double b = 2 * (ray.direction().dot(oc));
        double c = oc.dot(oc) - radius * radius;
        double discriminant = b * b - 4 * c;
        if (discriminant < 0)
            return Double.MAX_VALUE;
        if (discriminant == 0.0) {
            return -b / 2;
        } else {
            double sqr = Math.sqrt(discriminant);
            double positive = (-b + sqr) / 2;
            double negative = (-b - sqr) / 2;
            if (positive < 0)
                return Double.MAX_VALUE;
            if (negative > 0)
                return negative;
            return positive;
        }
    }

    @Override
    public Vector3 normal(Vector3 position) {
        return position.sub(getPosition()).normalized();
    }

}
