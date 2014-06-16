package com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.model.Frete;

public interface CorreiosWS {

	@GET
	@Path("/calculador/CalcPrecoPrazo.asmx/CalcPreco")
	@Produces("text/xml")
	ClientResponse<Frete> calculaFrete(@QueryParam("nCdEmpresa") String nCdEmpresa, @QueryParam("sDsSenha") String sDsSenha, @QueryParam("nCdServico") String nCdServico,
							@QueryParam("sCepOrigem") String sCepOrigem, @QueryParam("sCepDestino") String sCepDestino, @QueryParam("nVlPeso") String nVlPeso,
							@QueryParam("nCdFormato") String nCdFormato, @QueryParam("nVlComprimento") String nVlComprimento, @QueryParam("nVlAltura") String nVlAltura,
							@QueryParam("nVlLargura") String nVlLargura, @QueryParam("nVlDiametro") String nVlDiametro, @QueryParam("sCdMaoPropria") String sCdMaoPropria,
							@QueryParam("nVlValorDeclarado") String nVlValorDeclarado, @QueryParam("sCdAvisoRecebimento") String sCdAvisoRecebimento);
}
