package com.example.demo.entity;

public class Country {
	
	private int id;
	private String skracenica;
	private String ime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkracenica() {
		return skracenica;
	}
	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", skracenica=" + skracenica + ", ime=" + ime + "]";
	}
	public Country(int id, String skracenica, String ime) {
		super();
		this.id = id;
		this.skracenica = skracenica;
		this.ime = ime;
	}
	
	public Country()
	{
		
	}
}
