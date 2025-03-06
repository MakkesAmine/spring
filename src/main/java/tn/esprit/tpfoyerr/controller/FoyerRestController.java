package tn.esprit.tpfoyerr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyerr.entity.Bloc;
import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Foyer;
import tn.esprit.tpfoyerr.service.IChambreService;
import tn.esprit.tpfoyerr.service.IFoyerService;

import java.util.List;
@Tag(name= "Gestion Foyer")
@RestController
@RequiredArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService;

    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable ("foyer-id")Long foyerId) {
        Foyer foyer = foyerService.retrieveFoyer(foyerId);
        return foyer;

    }
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer=foyerService.modifyFoyer(f);
        return foyer;
    }
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer=foyerService.addFoyer(f);
        return foyer;
    }

    @PutMapping("/assign-bloc-to-foyer/{foyerId}/{blocId}")
    public void assignBlocToFoyer(@PathVariable Long foyerId,
                                  @PathVariable Long blocId) {
        foyerService.assignBlocToFoyer(foyerId, blocId);
    }
    @PutMapping("/unassign-bloc-from-foyer/{blocId}")
    public void unassignBlocFromFoyer(@PathVariable Long blocId) {
        foyerService.unassignBlocFromFoyer(blocId);
    }

    @PostMapping("/create-bloc-and-foyer")
    public Foyer createBlocAndFoyer(@RequestBody Foyer foyer, @RequestBody Bloc bloc) {
        return foyerService.createBlocAndFoyer(foyer, bloc);
    }
}