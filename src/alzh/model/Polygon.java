package alzh.model;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public int getVertexIndices(int index) {
        return vertexIndices.get(index);
    }

    public int getTextureVertexIndices(int index) {
        return textureVertexIndices.get(index);
    }

    public int getNormalIndices(int index) {
        return normalIndices.get(index);
    }

    public int countOfVertex() {
        return vertexIndices.size();
    }

    public boolean isTexturesExists() {
        return textureVertexIndices.size() != 0;
    }

    public boolean isNormalsExists() {
        return normalIndices.size() != 0;
    }

    public void addNewVertex(int indexV, int indexVt, int indexVn) {
        vertexIndices.add(indexV);
        if (indexVt != -1){
            textureVertexIndices.add(indexVt);
        } else {
            System.out.println("Texture vertex does not exists");
        }
        if (indexVn != -1) {
            normalIndices.add(indexVn);
        } else {
            System.out.println("Normal vertex does not exists");
        }
    }

    public List<Polygon> triangulate() {
        List<Polygon> donePolygons = new ArrayList<>();
        if (countOfVertex() > 3) {
            for (int vertexIndex = 2; vertexIndex < countOfVertex(); vertexIndex++) {
                Polygon newPolygon = new Polygon();
                for (int vertexIndexInside = 0; vertexIndexInside <= vertexIndex; vertexIndexInside++) {
                    if (vertexIndexInside == 0 || vertexIndexInside == vertexIndex - 1 || vertexIndexInside == vertexIndex) {
                        int indexV = getVertexIndices(vertexIndexInside);
                        int indexVt = -1;
                        if (isTexturesExists()) {
                            indexVt = getTextureVertexIndices(vertexIndexInside);
                        }
                        int indexVn = -1;
                        if (isNormalsExists()) {
                            indexVn = getNormalIndices(vertexIndexInside);
                        }
                        newPolygon.addNewVertex(indexV, indexVt, indexVn);
                    }
                }
                donePolygons.add(newPolygon);
            }
        } else {
            donePolygons.add(this);
        }
        return donePolygons;
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        assert vertexIndices.size() >= 3;
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        assert textureVertexIndices.size() >= 3;
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        assert normalIndices.size() >= 3;
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }
}
