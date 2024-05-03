package com.engim.verificapratica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private static Sorteggio sorteggio = new Sorteggio();


    /*
     * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
     * la classe Sorteggio) - 15 p*/

    @GetMapping(value = "/add")
    public void AddSquadra(@RequestParam(value = "nome") String nome, @RequestParam(value = "nazione") String nazione) {


        sorteggio.aggiungi(nome, nazione);




    }
    /*ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p*/

    @GetMapping(value = "/listaSquadre")

    public List<Squadra> listaSquadra(@RequestParam(value = "nazione") String nazione) {
        List<Squadra> squadre = sorteggio.getSquadre();
        List<Squadra> Team = new ArrayList<>();


        for (int i = 0; i < squadre.size(); i++) {
            if (squadre.get(i).getNazione().equals(nazione)) {
                Team.add(squadre.get(i));
            }


        }
        return Team;


    }



    /* ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
     next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
                                                                                     * non è di una nazione diversa) - 20 p*/
    @GetMapping(value="/sorteggia")

    public List<Squadra> sorteggia() {
    List<Squadra> duo = new ArrayList<>();
    Squadra s1 = sorteggio.next();
    Squadra s2 = sorteggio.next();

    while(s1.getNazione().equals(s2.getNazione())) {

        s1 =sorteggio.next();


    }
    duo.add(s1);w
    duo.add(s2);
    return duo;
}





  /*  * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
    * Creare il metodo sorteggiaPartite che:
    * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
    * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
    * - restituisce la lista di Partite.
    * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
    * */
 @GetMapping(value="/getPartite")




}
