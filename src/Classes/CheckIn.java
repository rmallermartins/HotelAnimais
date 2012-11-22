package Classes;



import Classes.BancoDeDados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import Controle.*;

public class CheckIn extends Evento {
	
	private Animal animal = null;
	private Pessoa dono,resp = null;
	private Acomodacao acomodacao = null;
	private Porte porte = null;
	

    private final static int CACHORRO = 1;
    private final static int GATO = 2;
    private final static int PASSARO = 3;
    private final static int PEIXE = 4;
    private final static int REPTIL = 5;
    private final static int ROEDOR = 6;

    public CheckIn(ControladorCadastro controladorCadastro){
        super(controladorCadastro);
    }
    
    @Override
    public void executa() throws CadastroException, ParseException{
    	animal = pegaInfoAnimal();
    	porte = getControladorCadastro().classificarPorte(animal);
    	acomodacao = procuraAcomodacoes(porte);
    	if (acomodacao != null) {
    		cadastraDono();
    		cadastraResponsavel();
    		cadastraAnimal();
    		System.out.println("Animal Cadastrado com sucesso.");
    	}    
    }
    
    public Estadia cadastraEstadia(Animal animal, Acomodacao acomodacao) throws ParseException, CadastroException{
    	Scanner entrada = new Scanner(System.in);
    	
		//Pegando dados da estadia
    	System.out.println("Data de entrada (dd/MM/yyyy)?");
    	
    	String x = entrada.next(); 
    	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    	SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
    	Date dataEntrada = sdf1.parse(x);
    	int dataEntradaNumero = Integer.parseInt(sdf2.format(sdf2));
    	
    	System.out.println("Número de dias a ser hospedado?");
    	int duracao = entrada.nextInt();
    	
    	if (duracao < 1){
    		System.out.println("Digite novamente o número de dias a ser hospedadp (Maior que 1)");
    	}
    	
    	//Cria a Estadia e cadastra no Banco.
    	Estadia novaEstadia = new Estadia(animal, acomodacao, dataEntrada, duracao, 
    			calculaTaxaHospedagem(acomodacao, dataEntradaNumero, duracao));
    	BancoDeDados.getInstance().getEstadias().add(novaEstadia);
		
		System.out.println("Estadia Criada");
    	return novaEstadia;
    }
    
    public Acomodacao procuraAcomodacoes(Porte porte) throws CadastroException, ParseException{
    	Set<Acomodacao> acomodacoes = BancoDeDados.getInstance().getAcomodacoes();
    	Iterator<Acomodacao> i = acomodacoes.iterator();
    	while(i.hasNext()){
    		Acomodacao acomodacao = i.next();
    		if (acomodacao != null
    				&& acomodacao.getDimensao() == porte
    				&& acomodacao.getEstado() == EstadoAcomodacao.DESOCUPADO
    				&& acomodacao.getEspecie() == animal.getEspecie()){
    			return acomodacao;
    		}
    		
    	}
		return null;
    }
    

	public double calculaTaxaHospedagem(Acomodacao acomodacaoSelecionada, int dataEntrada, int duracao) throws ParseException{
		double Taxa = duracao*Diaria.getValor(Acomodacao.getDimensao());
    	return Taxa;
    }
    
	public Animal pegaInfoAnimal(){
		Scanner entrada = new Scanner(System.in);
		
		//Pega Dados do Dono
    	System.out.println("Nome do dono?");
		String nome = entrada.next();
    	System.out.println("Telefone do dono?");
    	String telefone = entrada.next();
    	Dono dono = new Dono(nome,telefone);
		
		//Pega Dados do Responsavel
    	System.out.println("Nome do responsavel?");
    	String nomeResponsavel = entrada.next();
    	System.out.println("Telefone do responsavel?");
    	String telefoneResponsavel = entrada.next();
    	Pessoa resp = new Pessoa(nomeResponsavel,telefoneResponsavel);
		
		//Pegar Dados do Animal
    	System.out.println("Nome do Animal?");
    	String nomeAnimal = entrada.next();
    	System.out.println("Especie do animal?");
    	System.out.println("1 - Cachorro");
    	System.out.println("2 - Gato");
    	System.out.println("3 - Passaro");
    	System.out.println("4 - Peixe");
    	System.out.println("5 - Reptil");
    	System.out.println("6 - Roedor");
    	int especie = entrada.nextInt();
    	Especie especieAnimal = null;
    	
    	switch(especie){
    	case CACHORRO:
    		especieAnimal = Especie.CACHORRO;
    		break;
    	case GATO:
    		especieAnimal = Especie.GATO;
    		break;
    	case PASSARO:
    		especieAnimal = Especie.PASSARO;
    		break;
    	case PEIXE:
    		especieAnimal = Especie.PEIXE;
    		break;
    	case REPTIL:
    		especieAnimal = Especie.REPTIL;
    		break;
    	case ROEDOR:
    		especieAnimal = Especie.ROEDOR; 
    		break;
    	default:
            System.out.println("Opção inválida. Cadastre o Animal Novamente.");	
    	}	
    			
    	System.out.println("Altura do Animal?");
    	Double alturaAnimal = entrada.nextDouble();
    	
    	System.out.println("Comprimento do Animal?");
    	Double comprimentoAnimal = entrada.nextDouble();
    	Animal animal = new Animal(dono, nomeAnimal, especieAnimal, alturaAnimal, comprimentoAnimal, resp);
    	return animal;
	}
	
    public void cadastraAnimal() throws CadastroException{
    	Set<Animal> animais = BancoDeDados.getInstance().getAnimais();
    	
    	Iterator<Animal> i = animais.iterator();
    	while(i.hasNext()){
    		Animal animal = i.next();
    		if (this.animal == animal) {
    			System.out.println("O animal ja está cadastrado e será utilizado.");
    			break;
    		} else {
    			BancoDeDados.getInstance().getAnimais().add(this.animal);
    			System.out.println("Animal Cadastrado.");
    		}
    	}
    }
    
    public void cadastraResponsavel() throws CadastroException{
    	Set<Pessoa> pessoas = BancoDeDados.getInstance().getPessoas();
    	
    	for (Pessoa pessoa : pessoas) {
    		if (this.resp == pessoa) {
    			System.out.println("Responsavel ja está cadastrado e será vinculado ao annimal.");
    		} else {
    			BancoDeDados.getInstance().getPessoas().add(this.resp);
    			System.out.println("Resposavel Cadastrado.");
    		}
    	}
    }
    
    public void cadastraDono() throws CadastroException{
    	
    	Scanner entrada = new Scanner(System.in);
    	
    	//Obtem todas as Pessoas
    	Set<Pessoa> pessoas = BancoDeDados.getInstance().getPessoas();
    		
    	//Verifica se o dono ja está cadastrado
    	for (Pessoa pessoa : pessoas) {
    		if (this.dono == pessoa) {
    			System.out.println("O dono ja está cadastrado e será vinculado ao animal.");
    		} else {
    			BancoDeDados.getInstance().getPessoas().add(this.dono);
    			System.out.println("Dono Cadastrado.");
    		}
    	}
    }
    	

        
}
