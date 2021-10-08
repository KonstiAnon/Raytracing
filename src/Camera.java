public class Camera {
    private double fov;
    private Vector3 position;
    private Vector3 direction;
    private Vector3 up;
    public Camera(double fov, Vector3 position, Vector3 direction, Vector3 up){
        this.fov = fov;
        this.position = position;
        this.direction = direction;
        this.up = up;
    }

    public double getFov() {
        return fov;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public Vector3 getUp() {
        return up;
    }
}
