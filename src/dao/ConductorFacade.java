package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Conductore;
import utils.JpaUtils;

public class ConductorFacade extends AbstractFacade<Conductore> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ConductorFacade() {
		super(Conductore.class);
		getEntityManager();
	}

	@Override
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = JpaUtils.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}

}
