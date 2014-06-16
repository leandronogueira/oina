package com.filter;

import java.util.Date;

public class EventoFilter {

	private String nome;
	private String descricao;
	private Date inicioPeriodo;
	private Date fimPeriodo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getInicioPeriodo() {
		return inicioPeriodo;
	}
	public void setInicioPeriodo(Date inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}
	public Date getFimPeriodo() {
		return fimPeriodo;
	}
	public void setFimPeriodo(Date fimPeriodo) {
		this.fimPeriodo = fimPeriodo;
	}
}
