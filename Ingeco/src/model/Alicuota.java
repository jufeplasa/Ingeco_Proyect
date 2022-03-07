package model;
import java.lang.Math;

public class Alicuota {
	private double va;
	private double vo;
	private double i;
	private int nplazo;

	public Alicuota(double va, double vo, double i, int nplazo) {
		super();
		this.va = va;
		this.vo=vo;
		this.i = i;
		this.nplazo = nplazo;
	}

	public double getVa() {
		return va;
	}

	public double getVo() {
		return vo;
	}

	public double getI() {
		return i;
	}

	public int getNplazo() {
		return nplazo;
	}
	
	public double calculateVAconVP() {
		va=vo*((i*Math.pow((1+i), nplazo))/(Math.pow((1+i),nplazo)-1));
		return va;
	}
	
	public double calculateVPconVA() {
		vo=va*((Math.pow((1+i),nplazo)-1))/(i*Math.pow((1+i), nplazo));
		return vo;
	}
	
	
	public double calculateVFconVA() {
		vo=va*(((Math.pow((1+i),(nplazo+1))-1))/i);
		return vo;
	}
	
	public double calculateVAconVF() {
		va=vo*(i/((Math.pow((1+i),(nplazo+1))-1)));
		return va;
	}




}
