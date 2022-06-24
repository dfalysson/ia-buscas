package estrategiasDeBusca.cega;

import java.util.ArrayList;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Esta classe modela os aspectos de busca cega,
 *
 * 
 * 
 * @author Alysson Rodrigo
 *
 */
public abstract class BuscaCega {
	
	protected String nomeDaEstrategia;	// busca utilizada
	protected Estado<?> eInicial;		// estado inicial da busca
	protected Estado<?> eObjetivo;		// objetivos da busca
	protected List<Estado<?>> caminho; // caminho
	
	/**
	 * Construtor
	 */
	public BuscaCega() {
		this(null,null);
	}
	
	public BuscaCega(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		this.nomeDaEstrategia = "Busca cega";
		eInicial = estadoInicial;
		eObjetivo = estadoMeta;
		caminho = new ArrayList<Estado<?>>();
	}

	/**
	 * recupera o nome
	 * @return nome da estrategiade busca
	 */
	public String getNomeDaEstrategia() {
		return nomeDaEstrategia;
	}
	
	/**
	 * ponto de partida do processo
	 * @param estadoInicial um dos estados possiveis
	 */
	public void setInicio(Estado<?> estadoInicial) {
		this.eInicial = estadoInicial;
	}
	
	/**
	 * Define o estado objetivo para o processo de busca
	 * @param estadoMeta problema que atende os objetivos
	 */
	public void setObjetivo(Estado<?> estadoMeta) {
		this.eObjetivo = estadoMeta;
	}
	
	/**
	 * Recupera o estado considerado como meta para a busca
	 */
	public Estado<?> getObjetivo() {
		return eObjetivo;
	}
	
	/**
	 * Metodo que realiza o espaço de busca,
	 */
	public abstract void buscar();
	
	/**
	 * Recupera o caminho correspondente a solução
	 * @return
	 */
	public List<Estado<?>> getCaminhoSolucao() {
		return caminho;
	}
	
}