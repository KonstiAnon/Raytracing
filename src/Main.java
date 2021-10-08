
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(600, 480);
        Camera camera = new Camera(45, new Vector3(0,0,0), new Vector3(1,0,0), new Vector3(0,0,1));
        List<Mesh> meshList = new ArrayList<>();
        meshList.add(new Sphere(new Vector3(40, -5,0), Color.GREEN, 3.0));
        meshList.add(new Sphere(new Vector3(30, -10,0), Color.RED, 3.0));
        RayTracer tracer = new RayTracer(screen, camera, meshList);
        tracer.run();//I wanna be tracer

    }
}
