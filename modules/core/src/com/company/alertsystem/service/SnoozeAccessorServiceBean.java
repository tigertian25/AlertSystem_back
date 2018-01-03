package com.company.alertsystem.service;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Service;

import com.company.alertsystem.entity.AlertSnooze;
import com.company.alertsystem.entity.AlertType;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;

@Service(SnoozeAccessorService.NAME)
public class SnoozeAccessorServiceBean implements SnoozeAccessorService {
	 @Inject
	 private Persistence persistence;
	 
	@Override
	public AlertSnooze getDuration(int sampleOrderId, int alertTypeId) {
		// TODO Auto-generated method stub
		AlertSnooze alertSnooze=new AlertSnooze();
		AlertType alert=new AlertType();
		alertSnooze.setAlertTypeID(alert);
		try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            alertSnooze = (AlertSnooze) em.createQuery("select TOP 1 * from alertsystem$AlertSnooze a where"
            		+ " a.alertTypeID = :alertTypeId and a.sampleOrderId=sampleOrderId order by a.createTime desc")
            		.setParameter("alertTypeId", alertTypeId)
                    .setParameter("sampleOrderId", sampleOrderId)
                    .getSingleResult();
            tx.commit();
        } catch(NoResultException e) {
        	e.printStackTrace();
            return null;
        }
		return alertSnooze;
	}

	@Override
	public String update(int sampleOrderId, int alertTypeId, int duration) {
		// TODO Auto-generated method stub
		return null;
	}

}