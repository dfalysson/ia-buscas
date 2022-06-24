package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa uma estrategia de busca cega em profundidade
 * 
 * @author Alysson Rodrigo
 *
 */
public class BuscaEmProfundidade extends BuscaCega {
	
	protected Stack<Estado<?>> eAbertos;

	/**
	 * Construtor
	 */
	public BuscaEmProfundidade() {
		this(null,null);
	}
	
	/**
	 * Busca em Profundidade
	 * inicial e objetivo do processo
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta objetivos da busca
	 */
	public BuscaEmProfundidade(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Busca em Profundidade";
		eAbertos = new Stack<Estado<?>>();
	}
	
	/**
	 * Inicia a busca cega
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
				eAbertos.push(estado);
			eCorrente = eAbertos.pop();
		}
		// caminho
		if (eCorrente != null) {
			// caminho solução
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}
	}
	
}
