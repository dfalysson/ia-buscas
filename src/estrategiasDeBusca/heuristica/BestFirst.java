package estrategiasDeBusca.heuristica;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import espacoDeEstados.Estado;

public class BestFirst extends BuscaInformada {
	
	private Queue<Estado<?>> eAbertos;

	/**
	 * Construtor 
	 */
	public BestFirst() {
		this(null,null);
	}
	
	/**
	 * nova instancia Busca em Largura
	 * e objetivo para o processo.
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta objetivos da busca
	 */
	public BestFirst(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Best-First Search (Busca pelo Melhor-Primeiro)";
		eAbertos = new LinkedList<Estado<?>>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			List<?> eSucessores = eCorrente.getSucessores();
			Collections.sort((List<Estado<?>>) eSucessores, new OrdenarPorAvaliacao());
			for (Estado<?> estado : (List<Estado<?>>) eSucessores)
				eAbertos.add(estado);
			eCorrente = eAbertos.poll();
		}
		// se pertencente a um estado valido
		if (eCorrente != null) {
			// caminho de construção
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}		
	}

}
