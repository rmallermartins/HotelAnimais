package Classes;

import java.text.ParseException;

import Controle.CadastroException;

public class Main {
	
	public static void main(String[] args) throws CadastroException, ParseException{
		criaPorteFaixas();
		criaAcomodacoes();
		HotelAnimal oHotel = new HotelAnimal();
		oHotel.executa();
	}
	
	public static void criaPorteFaixas(){
		//Inicializar portesFaixa
		PorteFaixa cachorroPequeno = new PorteFaixa(0d, 20d, 0d, 30d, Especie.CACHORRO, Porte.PEQUENO);
		PorteFaixa cachorroMedio = new PorteFaixa(21d, 40d, 31d, 60d, Especie.CACHORRO, Porte.MEDIO);
		PorteFaixa cachorroGrande = new PorteFaixa(41d, 60d, 61d, 80d, Especie.CACHORRO, Porte.GRANDE);
		
		PorteFaixa gatoPequeno = new PorteFaixa(0d, 20d, 0d, 30d, Especie.GATO, Porte.PEQUENO);
		PorteFaixa gatoMedio = new PorteFaixa(21d, 40d, 31d, 60d, Especie.GATO, Porte.MEDIO);
		PorteFaixa gatoGrande = new PorteFaixa(41d, 60d, 61d, 80d, Especie.GATO, Porte.GRANDE);
		
		PorteFaixa passaroPequeno = new PorteFaixa(0d, 20d, 0d, 30d, Especie.PASSARO, Porte.PEQUENO);
		PorteFaixa passaroMedio = new PorteFaixa(21d, 40d, 31d, 60d, Especie.PASSARO, Porte.MEDIO);
		PorteFaixa passaroGrande = new PorteFaixa(41d, 60d, 61d, 80d, Especie.PASSARO, Porte.GRANDE);
		
		BancoDeDados.getInstance().getPortesFaixas().add(cachorroPequeno);
		BancoDeDados.getInstance().getPortesFaixas().add(cachorroMedio);
		BancoDeDados.getInstance().getPortesFaixas().add(cachorroGrande);
		
		BancoDeDados.getInstance().getPortesFaixas().add(gatoPequeno);
		BancoDeDados.getInstance().getPortesFaixas().add(gatoMedio);
		BancoDeDados.getInstance().getPortesFaixas().add(gatoGrande);
		
		BancoDeDados.getInstance().getPortesFaixas().add(passaroPequeno);
		BancoDeDados.getInstance().getPortesFaixas().add(passaroMedio);
		BancoDeDados.getInstance().getPortesFaixas().add(passaroGrande);
	}
	
	public static void criaAcomodacoes(){
		//Inicializar Acomodações
		Acomodacao a1 = new Acomodacao(1, Especie.CACHORRO, Porte.PEQUENO, EstadoAcomodacao.DESOCUPADO);
		Acomodacao a2 = new Acomodacao(2, Especie.CACHORRO, Porte.MEDIO, EstadoAcomodacao.DESOCUPADO);
		Acomodacao a3 = new Acomodacao(3, Especie.CACHORRO, Porte.GRANDE, EstadoAcomodacao.DESOCUPADO);
		
		BancoDeDados.getInstance().getAcomodacoes().add(a1);
		BancoDeDados.getInstance().getAcomodacoes().add(a2);
		BancoDeDados.getInstance().getAcomodacoes().add(a3);
	}
}
