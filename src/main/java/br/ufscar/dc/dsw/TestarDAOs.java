/*

ACONTEÇA O QUE ACONTECER
NÃO FAÇAM ISSO
NÃO TENTEM TESTAR DESSA FORMA

VOCÊS FORAM AVISADOS

*/


// package br.ufscar.dc.dsw;

// import java.time.LocalDateTime;
// import java.util.List;

// import br.ufscar.dc.dsw.dao.ProjetoDAO;
// import br.ufscar.dc.dsw.dao.UsuarioDAO;
// import br.ufscar.dc.dsw.model.Projeto;
// import br.ufscar.dc.dsw.model.Usuario;

// public class TestarDAOs {
//     public static void main(String[] args) {
//         UsuarioDAO usuarioDAO = new UsuarioDAO();
//         ProjetoDAO projetoDAO = new ProjetoDAO();

//         Usuario u = new Usuario(null, "Luis", "admin@email.com", "123", "ADMIN");
//         usuarioDAO.inserir(u);

//         // Garante que o id do usuário foi preenchido após o insert
//         System.out.println("ID do usuário inserido: " + u.getId());
//         if (u.getId() == null || u.getId() == 0) {
//             throw new RuntimeException("ID do usuário não foi preenchido após o insert. Verifique o método inserir em UsuarioDAO.");
//         }

//         List<Usuario> membros = new java.util.ArrayList<>();
//         membros.add(u);

//         Projeto p = new Projeto(null, "Projeto Teste", "Descrição", LocalDateTime.now(), LocalDateTime.now().plusDays(10), membros);
//         projetoDAO.inserir(p);

//         System.out.println("Usuário e projeto inseridos!");
//     }
// }