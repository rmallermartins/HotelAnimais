package Classes;


import Classes.BancoDeDados;
import Controle.CadastroException;
import Controle.ControladorCadastro;

import java.util.Scanner;
import java.util.Set;

public class Consulta extends Evento{
    

    public Consulta(ControladorCadastro controladorCadastro, BancoDeDados bd) {
		super(controladorCadastro, bd);
		// TODO Auto-generated constructor stub
	}

	private static final int CACHORRO = 1,ESPECIE = 1;
    private static final int GATO = 2,PORTE = 2;
    private static final int PASSARO = 3, ESTADO = 3;
    private static final int REPTIL = 4, VOLTAR = 4;
    private static final int ROEDOR = 5;
    private static final int PEIXE = 6;
    
    
    
    private int mostraMenuEspecie(){
    	
          
        System.out.println("Especies:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");
        System.out.println("3 - Passaro");
        System.out.println("4 - Reptil");
        System.out.println("5 - Roedor");
        System.out.println("6 - Peixe");
        System.out.println("0 - Voltar");
        
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
    
    private int mostraMenu(){
        
        System.out.println("\nConsulta Acomodacao:");
        System.out.println("1 - Por Espécie");
        System.out.println("2 - Por Porte");
        System.out.println("3 - Por Estado");
        System.out.println("0 - Voltar");
        
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
    
    private void realizaConsulta(){
    	
        int opcao = mostraMenu();
        
        switch(opcao){
            case ESPECIE:
                int opcaoEspecie = mostraMenuEspecie();
                
                
                switch (opcaoEspecie){
                case CACHORRO:
                	
                }
                
                Set<Animal> animais = getBd().getInstance().getAnimais();
                for (Animal animal : animais) {
                	
                	
                }
                
        }
        
    }

    public void executa() throws CadastroException{
        BancoDeDados bd = getBd();
        
        

        
    }
}
