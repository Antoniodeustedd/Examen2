package es.concesionario.modelo;

public class Vehiculo {

	
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int caballos;
	private boolean marchas;
	
	
	public Vehiculo(int id, String matricula, String marca, String modelo,
			String color, int caballos, boolean marchas) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.marchas = marchas;
	}


	public Vehiculo(String matricula, String marca, String modelo,
			String color, int caballos, boolean marchas) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.marchas = marchas;
	}


	public Vehiculo() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getcaballos() {
		return caballos;
	}


	public void setcaballos(int caballos) {
		this.caballos = caballos;
	}


	public boolean isMarchas() {
		return marchas;
	}


	public void setMarchas(boolean marchas) {
		this.marchas = marchas;
	}
	
}
