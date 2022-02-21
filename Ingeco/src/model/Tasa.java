package model;

import java.lang.Math;

public class Tasa {
	
	public Tasa() {
		
	}
	
	public double nominalAperiodica(double Inominal, int nper) {
		double Iper=Inominal/nper;
		return Iper;
	}
	
	public double periodicaAnominal(double Iper, int nper) {
		double Inominal=Iper*nper;
		return Inominal;
	}
	
	public double anticipadaAvencida(double iperA) {
		double iperV=iperA/(1-iperA);
		return iperV;
	}
	
	public double vencidaAanticipada(double iperV) {
		double iperA=iperV/(1+iperV);
		return iperA;
	}
	
	public double perdiodicaAefectiva(double Iper, int nper) {
		double ea=Math.pow((1+Iper),nper)-1;
		return ea;
	}
	
	public double efectivaAperdiodica(double ea, int nper) {
		double iper=Math.pow((1+ea),1/nper)-1;
		return iper;
	}
	
}
