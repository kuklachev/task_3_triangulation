package alzh.model;

import alzh.math.Vector2f;
import alzh.math.Vector3f;

import java.util.*;

public class Model {

    public ArrayList<Vector3f> vertices = new ArrayList<Vector3f>();
    public ArrayList<Vector2f> textureVertices = new ArrayList<Vector2f>();
    public ArrayList<Vector3f> normals = new ArrayList<Vector3f>();
    public ArrayList<Polygon> polygons = new ArrayList<Polygon>();

    public void triangulate() {
        List<Polygon> allPolygons = new ArrayList<>();
        for (Polygon polygon : polygons) {
            allPolygons.addAll(polygon.triangulate());
        }
        polygons.addAll(allPolygons);
    }
}
