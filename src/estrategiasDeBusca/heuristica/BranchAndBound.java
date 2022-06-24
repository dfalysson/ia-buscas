package estrategiasDeBusca.heuristica;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import espacoDeEstados.Estado;

public class BranchAndBound extends BuscaInformada {
	
	private Queue<Estado<?>> eAbertos;

	/**
	 * Construtor 
	 */
	public BranchAndBound() {
		this(null,null);
	}
	
	/**
	 * nova  de Busca Branch-and-Bound 
	 * inicial e objetivo para o processo.
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta estado objetivos da busca
	 */
	public BranchAndBound(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Branch-and-Bound";
		eAbertos = new LinkedList<Estado<?>>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			List<?> eSucessores = eCorrente.getSucessores();
			Collections.sort((List<Estado<?>>) eSucessores, new OrdenarPorCusto());
			for (Estado<?> estado : (List<Estado<?>>) eSucessores)
				eAbertos.add(estado);
			eCorrente = eAbertos.poll();
		}
		// estado valido
		if (eCorrente != null) {
			// caminho constrção
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}		
	}

}
