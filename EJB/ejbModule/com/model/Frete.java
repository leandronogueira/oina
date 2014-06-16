package com.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cResultado", namespace="http://tempuri.org/")
public class Frete {

	private List<ServicoInstance> servicos;
	
	@XmlElementWrapper(name="Servicos")
	@XmlElement(name="cServico")
	public List<ServicoInstance> getServicos() {
		return servicos;
	}
	public void setServicos(List<ServicoInstance> servicos) {
		this.servicos = servicos;
	}
}
