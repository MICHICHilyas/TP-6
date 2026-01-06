package org.example.studentmanagement.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.studentmanagement.entity.Student;
import org.example.studentmanagement.repository.StudentRepository;
import java.util.Optional;

/**
 * Service métier pour la gestion des apprenants.
 * Cette classe implémente la logique métier pour les opérations
 * CRUD sur les apprenants et les requêtes statistiques.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Service
public class StudentService {

    /**
     * Dépôt d'accès aux données des apprenants
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Enregistre un nouvel apprenant ou met à jour un apprenant existant.
     * 
     * @param student l'apprenant à sauvegarder
     * @return l'apprenant sauvegardé avec son identifiant généré
     */
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * Supprime un apprenant par son identifiant.
     * Vérifie d'abord l'existence de l'apprenant avant suppression.
     * 
     * @param id l'identifiant de l'apprenant à supprimer
     * @return true si la suppression a réussi, false si l'apprenant n'existe pas
     */
    public boolean delete(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Récupère la liste complète de tous les apprenants enregistrés.
     * 
     * @return la liste de tous les apprenants
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Compte le nombre total d'apprenants dans la base de données.
     * 
     * @return le nombre total d'apprenants
     */
    public long countStudents() {
        return studentRepository.count();
    }

    /**
     * Récupère les statistiques du nombre d'apprenants par année de naissance.
     * 
     * @return une collection contenant les statistiques par année
     */
    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}