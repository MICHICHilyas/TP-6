package org.example.studentmanagement.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des apprenants.
 * Expose les endpoints de l'API pour les opérations CRUD
 * et les requêtes statistiques sur les apprenants.
 * Documentation automatique via Swagger/OpenAPI.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@RestController
@RequestMapping("apprenants")
@Tag(name = "Gestion des Apprenants", description = "API de gestion des étudiants - Ilyas MICHICH")
public class StudentController {

    /**
     * Service métier pour les opérations sur les apprenants
     */
    @Autowired
    private StudentService studentService;

    /**
     * Enregistre un nouvel apprenant dans le système.
     * 
     * @param student les données de l'apprenant à créer
     * @return l'apprenant créé avec son identifiant généré
     */
    @Operation(summary = "Créer un nouvel apprenant", description = "Ajoute un apprenant dans la base de données")
    @PostMapping("/enregistrer")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    /**
     * Supprime un apprenant par son identifiant.
     * 
     * @param id l'identifiant de l'apprenant à supprimer
     * @return NO_CONTENT si supprimé, NOT_FOUND si non trouvé
     */
    @Operation(summary = "Supprimer un apprenant", description = "Supprime un apprenant par son identifiant")
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        boolean deleted = studentService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupère la liste complète de tous les apprenants.
     * 
     * @return la liste de tous les apprenants enregistrés
     */
    @Operation(summary = "Lister tous les apprenants", description = "Récupère la liste complète des apprenants")
    @GetMapping("/liste")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Compte le nombre total d'apprenants enregistrés.
     * 
     * @return le nombre total d'apprenants
     */
    @Operation(summary = "Compter les apprenants", description = "Retourne le nombre total d'apprenants")
    @GetMapping("/nombre")
    public ResponseEntity<Long> countStudent() {
        long count = studentService.countStudents();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * Récupère les statistiques des apprenants par année de naissance.
     * 
     * @return les statistiques regroupées par année
     */
    @Operation(summary = "Statistiques par année", description = "Nombre d'apprenants par année de naissance")
    @GetMapping("/statistiques/annee")
    public ResponseEntity<Collection<?>> findByYear() {
        Collection<?> studentsByYear = studentService.findNbrStudentByYear();
        return new ResponseEntity<>(studentsByYear, HttpStatus.OK);
    }
}
