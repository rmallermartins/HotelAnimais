package Classes;

import java.text.ParseException;

import Controle.CadastroException;
import Controle.ControladorCadastro;


public abstract class Evento {
	private ControladorCadastro controladorCadastro;
	
	public Evento(ControladorCadastro controladorCadastro){
		this.controladorCadastro = controladorCadastro;
	}
	
	public ControladorCadastro getControladorCadastro(){
		return this.controladorCadastro;
	}
	
	public abstract void executa() throws CadastroException, ParseException;

}
