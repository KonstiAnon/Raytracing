import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RayTracer {
    private final Screen screen;
    private final Camera camera;
    private final List<Mesh> meshes;

    public RayTracer(Screen screen, Camera camera, List<Mesh> meshes) {
        this.screen = screen;
        this.camera = camera;
        this.meshes = meshes;
    }

    public void run() {
        for (int i = 0; i < 1; i++) {
            Vector3 center = screenCen();
            Vector3 top = center.add(camera.getUp().scalar(screen.getHeight() / 2.0));
            Vector3 cenLeft = camera.getDirection().cross(camera.getUp()).normalized();
            Vector3 cenRight = cenLeft.scalar(-1.0).normalized();
            Vector3 cenBot = camera.getUp().scalar(-1.0).normalized();
            Vector3 topLeft = top.add(cenLeft.scalar(screen.getWidth() / 2.0)).add(cenRight.scalar(0.5)).add(cenBot.scalar(0.5));
            for (int x = 0; x < screen.getWidth(); x++) {
                for (int y = 0; y < screen.getHeight(); y++) {
                    Vector3 pixel = topLeft.add(cenRight.scalar(x)).add(cenBot.scalar(y));
                    Ray ray = new Ray(camera.getPosition(), pixel.sub(camera.getPosition()).normalized());
                    screen.drawPixel(x,y, castRay(ray));
                }
            }

        }
    }

    private double distance() {
        return (screen.getHeight() / 2.0) / (Math.tan(Math.toRadians(camera.getFov()) / 2));
    }

    private Color castRay(Ray ray){
        double minDistance = Double.MAX_VALUE;
        Mesh minObj = null;
        for(Mesh mesh : meshes){
            double dis = mesh.intersect(ray);
            if(dis < minDistance){
                minDistance = dis;
                minObj = mesh;
            }
        }
        return (minObj != null) ? minObj.color() : Color.WHITE;
    }
    private Vector3 screenCen() {
        double dis = distance();
        return camera.getPosition().add(camera.getDirection().scalar(distance()));
    }

}
