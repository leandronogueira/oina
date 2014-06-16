package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="cServico")
@XmlType(propOrder={"codigo","valor","prazoEntrega","valorMaoPropria","valorAvisoRecebimento",
			"valorValorDeclarado","entregaDomiciliar","entregaSabado","erro","msgErro"})
public class ServicoInstance {
	private Integer codigo;
	private String valor;
	private String prazoEntrega;
	private String valorMaoPropria;
	private String valorAvisoRecebimento;
	private String valorValorDeclarado;
	private String entregaDomiciliar;
	private String entregaSabado;
	private String erro;
	private String msgErro;
	
	@XmlElement (name="Codigo")
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	@XmlElement (name="Valor")
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@XmlElement (name="PrazoEntrega")
	public String getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	@XmlElement (name="ValorMaoPropria")
	public String getValorMaoPropria() {
		return valorMaoPropria;
	}
	public void setValorMaoPropria(String valorMaoPropria) {
		this.valorMaoPropria = valorMaoPropria;
	}
	@XmlElement (name="ValorAvisoRecebimento")
	public String getValorAvisoRecebimento() {
		return valorAvisoRecebimento;
	}
	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		this.valorAvisoRecebimento = valorAvisoRecebimento;
	}
	@XmlElement (name="ValorValorDeclarado")
	public String getValorValorDeclarado() {
		return valorValorDeclarado;
	}
	public void setValorValorDeclarado(String valorValorDeclarado) {
		this.valorValorDeclarado = valorValorDeclarado;
	}
	@XmlElement (name="EntregaDomiciliar")
	public String getEntregaDomiciliar() {
		return entregaDomiciliar;
	}
	public void setEntregaDomiciliar(String entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}
	@XmlElement (name="EntregaSabado")
	public String getEntregaSabado() {
		return entregaSabado;
	}
	public void setEntregaSabado(String entregaSabado) {
		this.entregaSabado = entregaSabado;
	}
	@XmlElement (name="Erro")
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	@XmlElement (name="MsgErro")
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
}