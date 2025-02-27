package tn.esprit.tpfoyerr.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyerr.entity.Universite;
import tn.esprit.tpfoyerr.service.IUniversiteService;

import java.util.List;

@Tag(name="Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    @Autowired
    IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getAllUniversites() {
        List<Universite> listuniversites=universiteService.retrieveAllUniversites();
        return listuniversites;
    }

    @PostMapping("/ajouter-universite-et-foyer")
    public Universite addFoyerAndUniversiteAndAssign(@RequestBody Universite universite) {
        Universite savedUniversite = universiteService.addFoyerAndUniversitelAndAssign(universite);
        return savedUniversite;
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite getUniversite(@PathVariable("universite-id") Long universiteId) {
        Universite universite=universiteService.retrieveUniversite(universiteId);
        return universite;

    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        universiteService.addUniversite(universite);
        return universite;
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    @PutMapping("/affecter-foyer-a-universite/{foyer-id}/{universite-id}")
    public void affecterFoyerAUniversite(@PathVariable("foyer-id") Long foyerId,
                                         @PathVariable("universite-id") Long universiteId) {
        universiteService.assignFoyerToUniversite(foyerId, universiteId);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite=universiteService.modifyUniversite(u);
        return universite;
    }
}