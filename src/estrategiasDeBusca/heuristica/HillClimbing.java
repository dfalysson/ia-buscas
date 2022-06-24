package estrategiasDeBusca.heuristica;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import espacoDeEstados.Estado;

public class HillClimbing extends BuscaInformada {
	
	protected Stack<Estado<?>> eAbertos;
	
	/**
	 * Construtor
	 */
	public HillClimbing() {
		this(null,null);
	}
	
	/**
	 * instancia Hill-Climbing
	 * inicial e objetivo do processo
	 * @param estadoInicial estado inicial
	 * @param estadoMeta objetivos da busca
	 */
	public HillClimbing(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Hill-Climbing (Otmiza��o Discreta)";
		eAbertos = new Stack<Estado<?>>();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			List<?> eSucessores = eCorrente.getSucessores();							// pega sucessores
			Collections.sort((List<Estado<?>>) eSucessores, new OrdenarPorAvaliacao());	// ordena heuristica
			Collections.reverse((List<Estado<?>>) eSucessores); 						// corrige a pilha
			for (Estado<?> estado : (List<Estado<?>>) eSucessores)						// empilha estados
				eAbertos.push(estado);
			eCorrente = eAbertos.pop();
		}
		// tem que ter sido encerrado
		if (eCorrente != null) {
			// caminho da construção
			caminho.add(eCorrente);
			while (eCorrente.getAncestral() != null) {
				eCorrente = eCorrente.getAncestral();
				caminho.add(eCorrente);
			}
			Collections.reverse(caminho);
		}		
	}

}
