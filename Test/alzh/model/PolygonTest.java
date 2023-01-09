package alzh.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PolygonTest {

    @Test
    void getVertexIndices_getVertexIndex0_1Returned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        Assertions.assertEquals(1,polygon.getVertexIndices(0));
    }

    @Test
    void getTextureVertexIndices_getTextureVertexIndex0_8Returned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        Assertions.assertEquals(8,polygon.getTextureVertexIndices(0));
    }

    @Test
    void getNormalIndices_getNormalIndex0_12Returned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        Assertions.assertEquals(12,polygon.getNormalIndices(0));
    }

    @Test
    void countOfVertex_getCountOfVertexFor5VertexPolygon_5Returned() {
        Polygon polygon = new Polygon();
        int count = 5;
        for (int i = 0; i < count; i++) {
            polygon.addNewVertex(i,i,i);
        }
        Assertions.assertEquals(count, polygon.countOfVertex());
    }

    @Test
    void isTexturesExists1_checkIsTexturesExistsInVertexWithoutTextures_FalseReturned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,-1,12);
        Assertions.assertFalse(polygon.isTexturesExists());
    }

    @Test
    void isTexturesExists2_checkIsTexturesExistsInVertexWithTextures_TrueReturned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        Assertions.assertTrue(polygon.isTexturesExists());
    }

    @Test
    void isNormalsExists1_checkIsNormalsExistsInVertexWithoutNormals_FalseReturned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,-1);
        Assertions.assertFalse(polygon.isNormalsExists());
    }

    @Test
    void isNormalsExists2_checkIsNormalsExistsInVertexWithNormals_TrueReturned() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        Assertions.assertFalse(polygon.isNormalsExists());
    }

    @Test
    void addNewVertex_isVertexWasAddedRight_TrueReturn() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1,8,12);
        boolean vertexCheck = polygon.getVertexIndices(0) == 1;
        boolean textureCheck = polygon.getTextureVertexIndices(0) == 8;
        boolean normalCheck = polygon.getNormalIndices(0) == 12;
        boolean result = vertexCheck && textureCheck && normalCheck;
        Assertions.assertTrue(result);
    }

    @Test
    void triangulate1_triangulatePolygonWith4Vertex_4ReturnedForHowMuchPolygonsWereMadeAnd3ReturnedForHowMuchVertexesHasEveryPolygon() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1, -1, -1);
        polygon.addNewVertex(2, -1, -1);
        polygon.addNewVertex(3, -1, -1);
        polygon.addNewVertex(4, -1, -1);
        polygon.addNewVertex(5, -1, -1);
        polygon.addNewVertex(6, -1, -1);
        List<Polygon> polygons = polygon.triangulate();
        Assertions.assertEquals(4, polygons.size());
        for (Polygon triangulated : polygons) {
            Assertions.assertEquals(3, triangulated.countOfVertex());
        }
    }

    @Test
    void triangulate2_triangulatePolygonWith4Vertex_4ReturnedForHowMuchPolygonsWereMadeAnd3ReturnedForHowMuchVertexesHasEveryPolygon() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1, 1, 1);
        polygon.addNewVertex(2, 2, 2);
        polygon.addNewVertex(3, 3, 3);
        polygon.addNewVertex(4, 4, 4);
        polygon.addNewVertex(5, 5, 5);
        polygon.addNewVertex(6, 6, 6);
        List<Polygon> polygons = polygon.triangulate();
        Assertions.assertEquals(4, polygons.size());
        for (Polygon triangulated : polygons) {
            Assertions.assertEquals(3, triangulated.countOfVertex());
        }
    }

    @Test
    void triangulate3_triangulatePolygonWith3Vertex_1ReturnedForHowMuchPolygonsWereMadeAnd3ReturnedForHowMuchVertexesHasEveryPolygon() {
        Polygon polygon = new Polygon();
        polygon.addNewVertex(1, -1, -1);
        polygon.addNewVertex(2, -1, -1);
        polygon.addNewVertex(3, -1, -1);
        List<Polygon> donePolygons = polygon.triangulate();
        Assertions.assertEquals(1, donePolygons.size());
        for (Polygon donePolygon : donePolygons) {
            Assertions.assertEquals(3, donePolygon.countOfVertex());
        }
    }
}