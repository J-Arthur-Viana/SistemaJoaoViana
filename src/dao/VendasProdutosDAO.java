/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.JatVendas;
import bean.JatVendasProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u11200121120
 */
public class VendasProdutosDAO extends AbstractDAO {

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
    Object attached = session.merge(object); // reatacha o objeto à Session atual
    session.delete(attached);
    session.getTransaction().commit();
}

    public void deleteProdutos(JatVendas vendas) {
        //listar todos os produtos do pedido
        List lista = (List) listProdutos(vendas);
        //deleta  a lista acima 
        session.beginTransaction();
        for (int i = 0; i < lista.size(); i++) {
            JatVendasProdutos vendasProdutos = (JatVendasProdutos) lista.get(i);
            //delete(pedidosProdutos);
            session.flush();
            session.clear();
            session.delete(vendasProdutos);
        }
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendasProdutos.class);
        criteria.add(Restrictions.eq("jatIdVendasProdutos", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listProdutos(JatVendas vendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendasProdutos.class);
        criteria.add(Restrictions.eq("jatVendas", vendas));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(JatVendasProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
