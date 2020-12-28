package com.ucad.service;

import com.ucad.bean.EtudiantBean;
import com.ucad.dao.EvaluationRepository;
import com.ucad.entities.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("evaluation")
public class EvaluationRestController {

    @Autowired
    EvaluationRepository evaluationRepository;

    @Autowired
    RestTemplate restTemplate; // utiliser pour acceder du web service gestion inscription

    @GetMapping(path = "/all")
    List<Evaluation> listEvaluation()
    {
        return  evaluationRepository.findAll();
    }

    private String getUrlWebService()
    {
        // url du web service etudiant definit dans le premier projet avec le port 9090
        return  "http://localhost:9090/etudiants/";
    }

    @GetMapping(value = "/evaluation/{id}")
    EtudiantBean findByEtudiant(@PathVariable Long id)
    {
        // appel du web service pour recuperer un etudiant connaissant son id
        return  restTemplate.getForEntity(getUrlWebService() + id, EtudiantBean.class).getBody();
    }

      //Premiere methode
   /* @PostMapping(value = "/evaluation/{id}/{numeroEtudiant}/{nomMatiere}/{note}")
    Evaluation save(@PathVariable  Long id,@PathVariable  String numeroEtudiant,@PathVariable  String nomMatiere,@PathVariable  double note)
    {
        EtudiantBean etudiantBean = findByEtudiant(id);
        if(etudiantBean != null)
        {
            Evaluation e=new Evaluation();
             e.setNumeroEtudiant(numeroEtudiant);
             e.setNomMatiere(nomMatiere);
             e.setNote(note);
             return evaluationRepository.save(e);

        }
        throw  new  RuntimeException("l eyudiant n existe pas");
    }*/
      //Deuxieme methode
    @PostMapping(value = "/new/{id}")
    Evaluation save(@PathVariable  Long id, @RequestBody Evaluation evaluation)
    {
        EtudiantBean etudiantBean = findByEtudiant(id);
        if(etudiantBean != null)
        {

            return evaluationRepository.save(evaluation);

        }
        throw  new  RuntimeException("l etudiant n existe pas");
    }
}
