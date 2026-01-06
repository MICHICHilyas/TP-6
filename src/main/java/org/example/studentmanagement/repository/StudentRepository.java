package org.example.studentmanagement.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.example.studentmanagement.entity.Student;

/**
 * Interface de dépôt pour l'accès aux données des apprenants.
 * Hérite de JpaRepository pour bénéficier des opérations CRUD standard
 * et définit des requêtes personnalisées pour les statistiques.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Recherche un apprenant par son identifiant unique.
     * 
     * @param id l'identifiant de l'apprenant à rechercher
     * @return l'apprenant correspondant ou null si non trouvé
     */
    Student findById(int id);

    /**
     * Récupère le nombre d'apprenants regroupés par année de naissance.
     * Cette requête JPQL permet d'obtenir des statistiques démographiques.
     * 
     * @return une collection de tableaux contenant [année, nombre d'apprenants]
     */
    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();
}
