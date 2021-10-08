public record Vector3(double x, double y, double z) {

    public Vector3 add(Vector3 vector) {
        return new Vector3(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3 sub(Vector3 vector) {
        return new Vector3(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector3 mul(Vector3 vector) {
        return new Vector3(x * vector.x, y * vector.y, z * vector.z);
    }

    public Vector3 scalar(double scalar) {
        return new Vector3(x * scalar, y * scalar, z * scalar);
    }

    public double dot(Vector3 vector) {
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public Vector3 cross(Vector3 vector){
        return new Vector3(y* vector.z - z * vector.y, z* vector.x - x* vector.z, x* vector.y - y* vector.x);
    }

    public double length(){
        return Math.sqrt(dot(this));
    }

    public Vector3 normalized(){
        double len = length();
        return new Vector3(x / len, y / len, z / len);
    }
}
