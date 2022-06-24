package estrategiasDeBusca.heuristica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe modela os aspectos comuns as classes de busca informada
 * 
 * 
 * @author Alysson Rodrigo
 *
 */
public abstract class BuscaInformada {
	
	protected String nomeDaEstrategia;	// nome da estrategia
	protected Estado<?> eInicial;		// representa o estado inicial da busca
	protected Estado<?> eObjetivo;		// representa um estado do problema
	protected List<Estado<?>> caminho;	// solução inicial
	
	/**
	 * Construtor
	 */
	public BuscaInformada() {
		this(null,null);
	}
	
	public BuscaInformada(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		this.nomeDaEstrategia = "Busca informada";
		eInicial = estadoInicial;
		eObjetivo = estadoMeta;
		caminho = new ArrayList<Estado<?>>();
	}

	/**
	 * Recupera o nome da estrategia
	 * @return nome da estrategia de busca
	 */
	public String getNomeDaEstrategia() {
		return nomeDaEstrategia;
	}
	
	/**
	 * Define o estado inicial 
	 * @param estadoInicial um dos estados possiveis
	 */
	public void setInicio(Estado<?> estadoInicial) {
		this.eInicial = estadoInicial;
	}
	
	/**
	 * Define o estado objetivo para o processo de busca, sendo por dado por um
	 * estado que apresente os objetivos desejados ou que seja, em si mesmo, um
	 * estado meta. 
	 * @param estadoMeta um estado poss�vel do problema que atende os objetivos
	 */
	public void setObjetivo(Estado<?> estadoMeta) {
		this.eObjetivo = estadoMeta;
	}
	
	/**
	 * Recupera o estado considerado como meta para a busca
	 * 
	 * @return 
	 */
	public Estado<?> getObjetivo() {
		return eObjetivo;
	}
	
	/**
	 * metodo que explora a busca
	 * o estado inicial e seguindo, estado na construção
	 * objetivo
	 */
	public abstract void buscar();
	
	/**
	 * Recupera o caminho encontrada pela busca.
	 * @return
	 */
	public List<Estado<?>> getCaminhoSolucao() {
		return caminho;
	}
	
}

class OrdenarPorCusto implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		return estado1.getCusto() - estado2.getCusto();
	}

}

class OrdenarPorAvaliacao implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		return estado1.getAvaliacao() - estado2.getAvaliacao();
	}

}

class OrdenarPorCustoMaisAvaliacao implements Comparator<Estado<?>> {

	@Override
	public int compare(Estado<?> estado1, Estado<?> estado2) {
		int f = (estado1.getCusto() + estado1.getAvaliacao()) - (estado2.getCusto() + estado2.getAvaliacao());		
		return (f != 0) ? f : estado2.getNivel() - estado1.getNivel();
	}

}