/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.JatVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class VendasDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendas.class);
        criteria.add(Restrictions.eq("jatIdVendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listFuncionario(String funcionario) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendas.class).createAlias("jatFuncionarios", "funcionarios"); 
        criteria.add(Restrictions.like("funcionarios.jatNome", "%" + funcionario + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listTotal(double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendas.class);
        criteria.add(Restrictions.ge("jatValorVenda", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
   public Object listFuncionarioTotal(String nome , double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendas.class).createAlias("jatFuncionarios", "funcionarios"); 
        criteria.add(Restrictions.like("funcionarios.jatNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("jatTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
}
