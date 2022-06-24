package estrategiasDeBusca.cega;

import java.util.Collections;
import java.util.List;

import espacoDeEstados.Estado;

/**
 * Busca cega limitada
 * 
 * @author Alysson Rodrigo
 *
 */
public class BuscaEmProfundidadeLimitada extends BuscaEmProfundidade {
	
	private int limite;

	/**
	 * Construtor
	 */
	public BuscaEmProfundidadeLimitada() {
		this(null,null,10);
	}
	
	/**
	 * 
	 * @param estadoInicial estado inicial de busca.
	 * @param estadoMeta objetivos da busca.
	 * @param nivelLimite limite da busca
	 */
	public BuscaEmProfundidadeLimitada(Estado<?> estadoInicial, Estado<?> estadoMeta, int nivelLimite) {
		super(estadoInicial,estadoMeta);
		super.nomeDaEstrategia = "Busca em Profundidade Limitada (at� " + limite + " n�veis)";
		this.limite = nivelLimite;
	}
	
	/**
	 * retorno da busca
	 * @param limite limite de profundidade
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * retorno do parametro
	 * @param limite nivel maximo da arvore
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}

	/**
	 * Implementa efetivamente a estrategia de busca
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void buscar() {
		Estado<?> eCorrente = eInicial;
		while ((eCorrente != null) && (!eCorrente.equals(eObjetivo))) {
			if (eCorrente.getNivel() < limite)
				for (Estado<?> estado : (List<Estado<?>>) eCorrente.getSucessores())
					eAbertos.push(estado);
			eCorrente = eAbertos.pop();
		}
		// solução do caminho
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
