/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.Set;

import Classes.*;

/**
 *
 * @author Raul San
 */
public class ControladorCadastro {
    
    public void cadastrar(Object entidade, BancoDeDados bd) throws CadastroException { 
        if (entidade instanceof Acomodacao) { 
            BancoDeDados.getInstance().getAcomodacoes().add((Acomodacao) entidade); 
        } else if (entidade instanceof Animal) {
            BancoDeDados.getInstance().getAnimais().add((Animal) entidade);
        } else if (entidade instanceof Dono) { 
            BancoDeDados.getInstance().getPessoas().add((Pessoa) entidade); 
        } else if (entidade instanceof Estadia) { 
            BancoDeDados.getInstance().getEstadias().add((Estadia) entidade); 
        } else if (entidade instanceof PorteFaixa) { 
            BancoDeDados.getInstance().getPortesFaixas().add((PorteFaixa) entidade); 
    } 
 } 
    public Porte classificarPorte(Animal animal) throws CadastroException { 
        Set<PorteFaixa> porteFaixas = BancoDeDados.getInstance().getPortesFaixas(); 
        for (PorteFaixa porteFaixa : porteFaixas) { 
        	if (porteFaixa.isAnimalDessePorte(animal)) { 
        		return porteFaixa.getPorte(); 
      } 
    } 
    throw new CadastroException( "Não foi possível classificar o porte do animal."); 
    } 

}