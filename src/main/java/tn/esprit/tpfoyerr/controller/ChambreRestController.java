package tn.esprit.tpfoyerr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyerr.entity.*;
import tn.esprit.tpfoyerr.service.*;

import java.util.List;
@Tag(name= "Gestion Chambre")
@RestController
@RequiredArgsConstructor
@RequestMapping("/chambre")

public class ChambreRestController {
    @Autowired
    IChambreService chambreService;
    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
    @PostMapping("/create-chambre-and-reservation")
    public Chambre createChambreAndReservation(@RequestBody Chambre chambre, @RequestBody Reservation reservation) {
        return chambreService.createChambreAndReservation(chambre, reservation);
    }

    @PutMapping("/assign-reservation-to-chambre/{chambreId}/{reservationId}")
    public void assignReservationToChambre(@PathVariable Long chambreId, @PathVariable Long reservationId) {
        chambreService.assignReservationToChambre(chambreId, reservationId);
    }

    @PutMapping("/unassign-reservation-from-chambre/{reservationId}")
    public void unassignReservationFromChambre(@PathVariable Long reservationId) {
        chambreService.unassignReservationFromChambre(reservationId);
    }
}