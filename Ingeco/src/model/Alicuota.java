package model;
import java.lang.Math;

public class Alicuota {
	private double va;
	private double vf;
	private double vp;
	private double i;
	private int nplazo;

	public Alicuota(double va, double vf, double vp, double i, int nplazo) {
		super();
		this.va = va;
		this.vf = vf;
		this.vp = vp;
		this.i = i;
		this.nplazo = nplazo;
	}

	public double getVa() {
		return va;
	}

	public double getVf() {
		return vf;
	}

	public double getVp() {
		return vp;
	}

	public double getI() {
		return i;
	}

	public int getNplazo() {
		return nplazo;
	}
	
	public double calculateVAconVP() {
		va=vp*((i*Math.pow((1+i), nplazo))/(Math.pow((1+i),nplazo)-1));
		return va;
	}
	
	public double calculateVPconVA() {
		vp=va*((Math.pow((1+i),nplazo)-1))/(i*Math.pow((1+i), nplazo));
		return vp;
	}
	
	
	public double calculateVFconVA() {
		vf=va*(((Math.pow((1+i),nplazo)-1))/i);
		return vf;
	}
	
	public double calculateVAconVF() {
		va=vf*(i/((Math.pow((1+i),nplazo)-1)));
		return va;
	}




}
