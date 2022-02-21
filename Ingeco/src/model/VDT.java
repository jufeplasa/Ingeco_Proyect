package model;

public class VDT {
	
	private double vp;
	private double vf;
	private int nplazo;
	private double i;
	
	public VDT(double vp, double vf, int nplazo, double i) {
		super();
		this.vp = vp;
		this.vf = vf;
		this.nplazo = nplazo;
		this.i = i;
	}

	public double getVp() {
		return vp;
	}

	public double getVf() {
		return vf;
	}

	public int getNplazo() {
		return nplazo;
	}

	public double getI() {
		return i;
	}
	
	public double calculateVF() {
		vf=vp*Math.pow((1+i), nplazo);
		return vf;
	}
	
	public double calculateVP() {
		vp=vf/Math.pow((1+i), nplazo);
		return vp;
	}
	
	
	
	
}
