package a3;

import graphicslib3D.Matrix3D;
import graphicslib3D.Point3D;
import graphicslib3D.Vector3D;

public class Camera {
	private Matrix3D rotMat;
	private double amt;
	private Vector3D U, V, N;
	private Point3D cam_loc, cam_rot;
	
	public Camera() {
		amt = 0.5;
		U = new Vector3D(1, 0, 0);
		V = new Vector3D(0, 1, 0);
		N = new Vector3D(0, 0, 1);

		cam_loc = new Point3D(0.0, 0.2, 6.0);
		cam_rot = new Point3D(0.0, 0.0, 0.0);
		rotMat = new Matrix3D();
		
		
	}
	
	public Matrix3D computeView() {
		return rotMat;
		
	}


	public void forwardMove() {
		Point3D N_mov = new Point3D(N.normalize());
		N_mov = N_mov.mult(amt);
		cam_loc = cam_loc.add(N_mov);
	}

	public void backwardMove() {
		Point3D N_mov = new Point3D(N.normalize());
		N_mov = N_mov.mult(-amt);
		cam_loc = cam_loc.add(N_mov);
	}

	public void pitchUp() {		
		double newX = cam_rot.getX() + 3.0;
		cam_rot.setX(newX);
	}

	public void pitchDown() {
		double newX = cam_rot.getX() - 3.0;
		cam_rot.setX(newX);
	}

	public void panRight() {
		double newY = cam_rot.getY() - 3.0;
		cam_rot.setY(newY);		
	}

	public void panLeft() {
		double newY = cam_rot.getY() + 3.0;
		cam_rot.setY(newY);	
				
	}

	public void upMove() {
		Point3D V_mov = new Point3D(V.normalize());
		V_mov = V_mov.mult(-amt);
		cam_loc = cam_loc.add(V_mov);
		
	}

	public void downMove() {
		Point3D V_mov = new Point3D(V.normalize());
		V_mov = V_mov.mult(amt);
		cam_loc = cam_loc.add(V_mov);
			
	}

	public void rightStrafe() {
		Point3D U_mov = new Point3D(U.normalize());
		U_mov = U_mov.mult(-amt);
		cam_loc = cam_loc.add(U_mov);
	}

	public void leftStrafe() {
		Point3D U_mov = new Point3D(U.normalize());
		U_mov = U_mov.mult(amt);
		cam_loc = cam_loc.add(U_mov);	
	}

	public void reset() {
		//cam_loc.setX(0.0);
		//cam_loc.setY(0.2);
		//cam_loc.setZ(0.6);
		cam_rot.setX(0.0);
		cam_rot.setY(0.0);
		cam_rot.setZ(0.0);
		
		
	}
	
	public double getX() {
		return cam_loc.getX();
	}
	
	public double getY() {
		return cam_loc.getY();
	}
	
	public double getZ() {
		return cam_loc.getZ();
	}

	public double getU() {
		return cam_rot.getX();
	}

	public double getV() {
		return cam_rot.getY();
	}

	public double getN() {
		return cam_rot.getZ();
	}

}

