/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umgtestjoshua.sessionbean;

import com.umgtestjoshua.entities.Catedratico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author EstelaChayoMonse
 */
@Stateless
public class CatedraticoFacade extends AbstractFacade<Catedratico> {

    @PersistenceContext(unitName = "com.umgtestjoshua_escuelaenfermeria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatedraticoFacade() {
        super(Catedratico.class);
    }
    
}
