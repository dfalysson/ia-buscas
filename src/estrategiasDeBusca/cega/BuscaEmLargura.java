package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import espacoDeEstados.Estado;

/**
 * Esta classe implementa busca cega 
 * 
 * @author Alysson Rodrigo
 *
 */
public class BuscaEmLargura extends BuscaCega {
	
	private Queue<Estado<?>> eAbertos;

	/**
	 * Construtor
	 */
	public BuscaEmLargura() {
		this(null,null);
	}
	
	/**
	 * Busca em Largura
	 * 
	 * @param estadoInicial estado inicial de busca
	 * @param estadoMeta objetivos da busca
	 */
	public BuscaEmLargura(Estado<?> estadoInicial, Estado<?> estadoMeta) {
		super(estadoInicial,estadoMeta);
		nomeDaEstrategia = "Busca em Largura";
		eAbertos = new LinkedList<Estado<?>>();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
				eAbertos.add(estado);
			eCorrente = eAbertos.poll();
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
