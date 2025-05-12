package br.ufscar.dc.dsw;

import java.util.logging.Logger;

/*
 * acho interessante manter essa classe aqui por enquanto
 * pois muitas dessas estruturas a gente pode reutilizar
 * se não utilizar praticamente igual
 * vale dar uma lidinha nela e entender como funciona
 * depois podemos apenas converter as "mensagens"
 * no futuro objeto "teste"
 */

public class Mural {
    private static Logger logger = Logger.getLogger(Mural.class.getName());
    //private List<Mensagem> mensagens;

    // public Mural() {
    //     logger.info("Mural Construtor");
    //     mensagens = Collections.synchronizedList(new ArrayList<>());
    // }

    // public List<Mensagem> getMensagens() {
    //     synchronized (mensagens) {
    //         return new ArrayList<>(mensagens);
    //     }
    // }    

    // public void addMensagem(String de, String para, String texto) { 
    //     synchronized (mensagens) {
    //         int iid = mensagens.size() + 1;
    //         var novaMsg = new Mensagem(iid, de, para, texto, new Date());
    //         mensagens.add(novaMsg);
    //     }
    // }    
}