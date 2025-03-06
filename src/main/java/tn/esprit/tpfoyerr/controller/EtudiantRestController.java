package tn.esprit.tpfoyerr.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyerr.entity.Chambre;
import tn.esprit.tpfoyerr.entity.Etudiant;
import tn.esprit.tpfoyerr.service.IChambreService;
import tn.esprit.tpfoyerr.service.IEtudiantService;

import java.util.List;

@Tag(name= "Gestion des etudiants")
@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {



        @Autowired
        IEtudiantService etudiantService;
        // http://localhost:8089/tpfoyer/etudiants/retrieve-all-etudiants
        @Operation(description = "récupérer toutes les etudiants de la base de données")
        @GetMapping("/retrieve-all-etudiants")
        public List<Etudiant> getEtudiants() {
            List<Etudiant> listetudiants = etudiantService.retrieveAllEtudiants();
            return listetudiants;
        }
        // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
        @GetMapping("/retrieve-etudiant/{etudiant-id}")
        public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
            Etudiant etudiant = etudiantService.retrieveEtudiant(etudiantId);
            return etudiant;
        }
        // http://localhost:8089/tpfoyer/etudiant/add-etudiant
        @PostMapping("/add-etudiant")
        public Etudiant addEtudiant(@RequestBody Etudiant e) {
            Etudiant etudiant = etudiantService.addEtudiant(e);
            return etudiant;
        }
        // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
        @DeleteMapping("/remove-etudiant/{etudiant-id}")
        public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
            etudiantService.removeEtudiant(etudiantId);
        }
        // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
        @PutMapping("/modify-etudiant")
        public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
            Etudiant etudiant = etudiantService.modifyEtudiant(e);
            return etudiant;
        }
}
