import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // 🔹 Criar um novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("Yasmin");
        novoUsuario.setEmail("YASMIN-ADMIN@example.com");
        novoUsuario.setSenha("senha123");
        novoUsuario.setRole("ADMIN");

        usuarioDAO.inserir(novoUsuario);
        System.out.println("Usuário inserido com ID: " + novoUsuario.getId());

        // 🔹 Buscar usuário por ID
        Usuario usuarioBuscado = usuarioDAO.buscarPorId(novoUsuario.getId());
        if (usuarioBuscado != null) {
            System.out.println("Usuário encontrado: " + usuarioBuscado.getNome());
        } else {
            System.out.println("Usuário não encontrado.");
        }

//        // 🔹 Atualizar usuário
//        usuarioBuscado.setNome("YASMINNNNNNNN");
//        usuarioDAO.atualizar(usuarioBuscado);
//        System.out.println("Usuário atualizado.");

        // 🔹 Listar todos os usuários
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        System.out.println("Lista de usuários:");
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome() + " - " + u.getEmail() + " - " + u.getRole());
        }

        // 🔹 Deletar usuário
//        usuarioDAO.deletar(novoUsuario.getId());
//        System.out.println("Usuário deletado.");
    }
}
