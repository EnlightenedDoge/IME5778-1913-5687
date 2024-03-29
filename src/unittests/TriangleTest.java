package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;

import primitives.*;

import geometries.*;

import java.util.ArrayList;

public class TriangleTest {

	@Test
	public void TriangleIntersectionPointsTest() {

		final int WIDTH = 3;
		final int HEIGHT = 3;

		Ray[][] rays = new Ray[HEIGHT][WIDTH];

		Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0), new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0));

		Triangle triangle = new Triangle(new Point3D(0, 1, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2),
				new Color(), new Material(1,1,1,1,1));

		Triangle triangle2 = new Triangle(new Point3D(0, 10, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2),
				new Color(), new Material(1,1,1,0,1));

		ArrayList<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
		ArrayList<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
		System.out.println("Camera:\n" + camera);

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				rays[i][j] = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

				ArrayList<Point3D> rayIntersectionPoints = new ArrayList<>();
				triangle.findIntersection(rays[i][j]).forEach((k, v) -> rayIntersectionPoints.addAll(v));

				ArrayList<Point3D> rayIntersectionPoints2 = new ArrayList<>();
				triangle2.findIntersection(rays[i][j]).forEach((k, v) -> rayIntersectionPoints2.addAll(v));

				for (Point3D iPoint : rayIntersectionPoints)
					intersectionPointsTriangle.add(iPoint);

				for (Point3D iPoint : rayIntersectionPoints2)
					intersectionPointsTriangle2.add(iPoint);

			}
		}
		assertTrue(intersectionPointsTriangle.size() == 1);
		assertTrue(intersectionPointsTriangle2.size() == 2);

		System.out.println("Intersection Points:");

		for (Point3D iPoint : intersectionPointsTriangle)
			System.out.println(iPoint);
		System.out.println("--");

		for (Point3D iPoint : intersectionPointsTriangle2)
			System.out.println(iPoint);
	}

	/*
	 * @Test public void testEqualsObject() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testToString() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testTrianglePoint3DPoint3DPoint3D() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testTriangleTriangle() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetP1() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetP2() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetP3() { fail("Not yet implemented"); }
	 */

}
