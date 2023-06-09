package br.com.soap.correios.main;

import java.net.URL;

import javax.xml.namespace.QName;

import br.com.soap.correios.servico.AtendeCliente;
import br.com.soap.correios.servico.EnderecoERP;
import jakarta.xml.ws.Service;

public class App {

	public static void main(String[] args) throws Exception {
		//Pego a url fornecida na documentação do wsld
		URL urlCorreiros = new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");
		
		//na url wsdl é um xml la tem esses 2 parametros que precisam ser colocado aqui.
		/*
		 * <wsdl:definitions xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:tns="http://cliente.bean.master.sigep.bsb.correios.com.br/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:ns1="http://schemas.xmlsoap.org/soap/http" name="AtendeClienteService" targetNamespace="http://cliente.bean.master.sigep.bsb.correios.com.br/">
		 */
		//sendo o targetNamespace e o name, desse trecho de exemplo
		QName qNameCorreiros = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/","AtendeClienteService");
		
		Service serviceCorrerios = Service.create(urlCorreiros, qNameCorreiros);
		
		AtendeCliente correios = serviceCorrerios.getPort(AtendeCliente.class);
		
		EnderecoERP consultaCEP = correios.consultaCEP("06194060");
		
		//System.out.println(consultaCEP.toString());
		System.out.println(consultaCEP.getCidade());
		System.out.println(consultaCEP.getBairro());
		System.out.println(consultaCEP.getComplemento2());
	}

}
