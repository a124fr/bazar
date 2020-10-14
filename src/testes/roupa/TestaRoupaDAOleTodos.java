package testes.roupa;

import persistencia.RoupaDAO;

public class TestaRoupaDAOleTodos {

    public static void main(String[] args) throws Exception {
        System.out.println(RoupaDAO.leTodos());
    }
}
