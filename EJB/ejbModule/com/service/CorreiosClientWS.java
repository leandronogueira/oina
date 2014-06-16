package com.service;

import javax.ejb.Stateless;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.model.Frete;

@Stateless(name="correiosWS")
public class CorreiosClientWS {

	public Frete calculaFrete(/*String nCdEmpresa,
			String sDsSenha,
			String nCdServico,
			String sCepOrigem,
			String sCepDestino,
			String nVlPeso,
			String nCdFormato,
			String nVlComprimento,
			String nVlAltura,
			String nVlLargura,
			String nVlDiametro,
			String sCdMaoPropria,
			String nVlValorDeclarado,
			String sCdAvisoRecebimento*/) {
		
		RegisterBuiltin.register(ResteasyProviderFactory.getInstance());

		CorreiosWS client = ProxyFactory.create(CorreiosWS.class, "http://ws.correios.com.br");
        ClientResponse<Frete> response = client.calculaFrete("", "", "41106", "41610035", "41640380", "0.4", "1", "1.9", "1.0", "3.0", "12.0", "N", "0", "N");

		return response.getEntity();
	}
}
