package model;

public class Calculadora {

	private Tasa tasa;
	public Calculadora() {
		tasa=new Tasa();
	}

	public double calcularTasa(String[] indiceI, String[] indiceF, double tasaI,int nperI, int nperF) {
		int nperA=nperI;
		double tasaC=tasaI;
		String [] indiceC=indiceI;
		while(nperA!=nperF||!(indiceC[0].equals(indiceF[0]))||!(indiceC[1].equals(indiceF[1]) )){
			if(nperA==nperF) {
				
				if(indiceC[0].equals("n")&&indiceF[0].equals("p")) {
					tasaC=tasa.nominalAperiodica(tasaC, nperA);
					indiceC[0]="p";
					if(indiceC[1].equals("a")&&indiceF[1].equals("v")) {
						tasaC=tasa.anticipadaAvencida(tasaC);
						indiceC[1]="v";
					}
					else if(indiceC[1].equals("v")&&indiceF[1].equals("a")) {
						tasaC=tasa.vencidaAanticipada(tasaC);
						indiceC[1]="a";
					}
				}
				else if (indiceC[0].equals("p")&&indiceF[0].equals("p")) {
					if(indiceC[1].equals("v")&&indiceF[1].equals("a")) {
						tasaC=tasa.vencidaAanticipada(tasaC);
						indiceC[1]="a";
					}
					else if(indiceC[1].equals("a")&&indiceF[1].equals("v")) {
						tasaC=tasa.anticipadaAvencida(tasaC);
						indiceC[1]="v";
					}
				}
				else if(indiceC[0].equals("p")&&indiceF[0].equals("n")) {
					if(indiceC[1].equals("a")&&indiceF[1].equals("v")){
						tasaC=tasa.anticipadaAvencida(tasaC);
						indiceC[1]="v";
						tasaC=tasa.periodicaAnominal(tasaC, nperA);
						indiceC[0]="n";
					}
					else if (indiceC[1].equals("v")&&indiceF[1].equals("a")) {
						tasaC=tasa.vencidaAanticipada(tasaC);
						indiceC[1]="a";
						tasaC=tasa.periodicaAnominal(tasaC, nperA);
						indiceC[0]="n";
					}
					else {
						tasaC=tasa.periodicaAnominal(tasaC, nperA);
						indiceC[0]="n";
					}
				}
				else if(indiceC[0].equals("p")&&indiceF[0].equals("E")) {
					if(indiceC[1].equals("a")){
						tasaC=tasa.anticipadaAvencida(tasaC);
						indiceC[1]="v";
					}
					else {
						tasaC=tasa.perdiodicaAefectiva(tasaC, nperA);
						indiceC[0]="E";
						indiceC[1]="A";
					}

				}
				else if(indiceC[0].equals("E")&&indiceF[0].equals("p") ){
					tasaC=tasa.efectivaAperdiodica(tasaC, nperA);
					indiceC[0]="p";
					indiceC[1]="v";
				}
				else if(indiceC[0].equals("n")&&indiceF[0].equals("n")) {
					String [] temp= {"p",indiceF[1]};
					tasaC=calcularTasa( indiceC,temp, tasaC, nperI,  nperF);
					indiceC=temp;
				}
				else if(indiceC[0].equals("n")&&indiceF[0].equals("E")) {
					String [] temp= {"p","v"};
					tasaC=calcularTasa( indiceC,temp, tasaC, nperI,  nperF);
					indiceC=temp;
				}
				else if(indiceC[0].equals("n")&&indiceF[0].equals("E")||indiceC[0].equals("E")&&(indiceF[0].equals("n"))) {

					String [] temp= {"p","v"};
					tasaC=calcularTasa( indiceC,temp, tasaC, nperI,  nperF);
					indiceC=temp;
				}
			}
			else {
				String [] temp= {"E","A"};
				tasaC=calcularTasa(indiceC,temp,tasaC,nperA,nperI);
				indiceC=temp;
				nperA=nperF;
			}
		}
		return tasaC;
	}

}
