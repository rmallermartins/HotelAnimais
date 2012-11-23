/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Raul San
 */
public enum Diaria {
	PEQUENO, MEDIO, GRANDE;
	
	public double getValor(Diaria diaria){
		switch(diaria){
		case GRANDE:
			return 100d;
		case MEDIO:
			return 60d;
		case PEQUENO:
			return 40d;
		}
		return 0d;
	}
	
	public Diaria getDiaria(Diaria diaria){
		switch (diaria){
		case GRANDE:
			return GRANDE;
		case MEDIO:
			return MEDIO;
		case PEQUENO:
			return PEQUENO;
		}
		return null;
	}
    
}
