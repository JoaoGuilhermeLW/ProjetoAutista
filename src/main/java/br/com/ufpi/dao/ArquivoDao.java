package br.com.ufpi.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.ufpi.model.Arquivo;
import br.com.ufpi.model.Atividade;

@Stateless
public class ArquivoDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public ArquivoDao() {
		super();
	}

	public void adicionar(Arquivo arquivo) {
		em.merge(arquivo);
	}

	public void atualizar(Arquivo arquivo) {
		em.merge(arquivo);
	}

	public int contarArquivos() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Long> arquivoQuery = criteria.createQuery(Long.class);
		Root<Arquivo> arquivoRoot = arquivoQuery.from(Arquivo.class);
		TypedQuery<Long> query = em.createQuery(arquivoQuery.select(criteria.count(arquivoRoot)));
		return query.getSingleResult().intValue();
	}

	public List<Arquivo> carregarArquivosDaAtividade(Atividade atividade) {
		TypedQuery<Arquivo> query = em.createQuery("Select arq from Arquivo arq where arq.atividade = :atividade",
				Arquivo.class);
		query.setParameter("atividade", atividade);
		List<Arquivo> arquivos = query.getResultList();
		return arquivos;
	}

	public void delete(Arquivo imagem) {
		imagem = em.merge(imagem);
		em.remove(imagem);
		
	}
}
