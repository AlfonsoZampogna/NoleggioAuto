package it.polito.tdp.noleggio.model;

public class Model {


	private int totClienti;
	private int clientiInsoddisfatti;
	
	public Model() {
		this.totClienti=0;
		this.clientiInsoddisfatti=0;
	}
	
	public void simula(int nc) {
		Simulatore sim = new Simulatore(nc);
		sim.caricaEventi();
		sim.run();
		this.totClienti = sim.getnClientiTot();
		this.clientiInsoddisfatti = sim.getnClientiInsoddisfatti();
	}

	public int getTotClienti() {
		return totClienti;
	}

	public int getClientiInsoddisfatti() {
		return clientiInsoddisfatti;
	}
	
	
}
