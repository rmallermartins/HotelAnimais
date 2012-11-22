
package Classes;

import java.util.HashSet;
import java.util.Set;

public class BancoDeDados { 
    private Set<Acomodacao> acomodacoes; 
    private Set<Animal> animais; 
    private Set<Diaria> diarias; 
    private Set<Pessoa> pessoas; 
    private Set<Especie> especies; 
    private Set<Estadia> estadias; 
    private Set<PorteFaixa> portesFaixas; 
    
    private static BancoDeDados instance; 
    
    private BancoDeDados() { 
        acomodacoes = new HashSet<Acomodacao>(); 
        animais = new HashSet<Animal>(); 
        diarias = new HashSet<Diaria>(); 
        pessoas = new HashSet<Pessoa>(); 
        especies = new HashSet<Especie>(); 
        estadias = new HashSet<Estadia>(); 
        portesFaixas = new HashSet<PorteFaixa>(); 
 } 
 public static BancoDeDados getInstance() { 
  if (instance == null) { 
   instance = new BancoDeDados(); 
    } 
  return instance; 
 } 
 public Set<Acomodacao> getAcomodacoes() { 
  return acomodacoes; 
 } 
 public Set<Animal> getAnimais() { 
  return animais;     
} 
public Set<Diaria> getDiarias() { 
  return diarias; 
} 
 public Set<Pessoa> getPessoas() { 
  return pessoas; 
} 
 public Set<Especie> getEspecies() { 
  return especies; 
} 
 public Set<Estadia> getEstadias() { 
  return estadias; 
} 
 public Set<PorteFaixa> getPortesFaixas() { 
  return portesFaixas; 
 } 
} 
