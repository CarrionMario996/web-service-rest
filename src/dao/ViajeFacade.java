package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import entity.Viaje;
import utils.JpaUtils;

public class ViajeFacade extends AbstractFacade<Viaje> implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public ViajeFacade() {
		super(Viaje.class);
		// TODO Auto-generated constructor stub
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
