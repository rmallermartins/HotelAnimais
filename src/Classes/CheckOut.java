/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Controle.CadastroException;
import Controle.ControladorCadastro;

/**
 *
 * @author Raul San
 */
public class CheckOut extends Evento {
public CheckOut(ControladorCadastro controladorCadastro, BancoDeDados  bd) {
		super(controladorCadastro, bd);
	}
	

	@Override
	public void executa() throws CadastroException {
		
	}
    
}
