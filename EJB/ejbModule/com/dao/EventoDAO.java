package com.dao;
 
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.filter.EventoFilter;
import com.model.Evento;
 
@Stateless
public class EventoDAO extends GenericDAO<Evento, Integer> {
 
    public EventoDAO() {
        super(Evento.class);
    }

	public List<Evento> findByFilter(EventoFilter filter) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e FROM Evento e WHERE 1=1");
		
		if (!"".equals(filter.getNome())) {
			sql.append(" AND e.nome like :nome ");
		}
		
		if (!"".equals(filter.getDescricao())) {
			sql.append(" AND e.descricao like :descricao ");
		}
		
		if (filter.getInicioPeriodo() != null) {
			sql.append(" AND e.data >= :inicio ");
		}
		
		if (filter.getFimPeriodo() != null) {
			sql.append(" AND e.data <= :fim ");
		}
		
		TypedQuery<Evento> q = getEntityManager().createQuery(sql.toString(), getEntityClass());
		
		if (!"".equals(filter.getNome())) {
			q.setParameter("nome", filter.getNome()+"%");
		}
		
		if (!"".equals(filter.getDescricao())) {
			q.setParameter("descricao", "%"+filter.getDescricao()+"%");
		}
		
		if (filter.getInicioPeriodo() != null) {
			q.setParameter("inicio", filter.getInicioPeriodo());
		}
		
		if (filter.getFimPeriodo() != null) {
			q.setParameter("fim", filter.getFimPeriodo());
		}
		
		return q.getResultList();
	}
 
}