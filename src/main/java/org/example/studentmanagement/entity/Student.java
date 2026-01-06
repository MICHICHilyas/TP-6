package org.example.studentmanagement.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Entité représentant un apprenant dans le système de gestion.
 * Cette classe est mappée sur la table APPRENANT en base de données.
 * Elle contient les informations personnelles de chaque étudiant.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
@Entity
@Table(name = "APPRENANT")
public class Student {
    
    /**
     * Identifiant unique de l'apprenant (clé primaire auto-générée)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /**
     * Nom de famille de l'apprenant
     */
    @Column(name = "nom_famille")
    private String nom;
    
    /**
     * Prénom de l'apprenant
     */
    @Column(name = "prenom_apprenant")
    private String prenom;

    /**
     * Date de naissance de l'apprenant
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance")
    private Date dateNaissance;

    /**
     * Constructeur par défaut requis par JPA.
     */
    public Student() {
    }

    /**
     * Constructeur avec paramètres pour créer un nouvel apprenant.
     * 
     * @param nom le nom de famille de l'apprenant
     * @param prenom le prénom de l'apprenant
     * @param dateNaissance la date de naissance de l'apprenant
     */
    public Student(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Récupère l'identifiant de l'apprenant.
     * @return l'identifiant unique
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant de l'apprenant.
     * @param id le nouvel identifiant
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Récupère le nom de famille de l'apprenant.
     * @return le nom de famille
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de famille de l'apprenant.
     * @param nom le nouveau nom de famille
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le prénom de l'apprenant.
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom de l'apprenant.
     * @param prenom le nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Récupère la date de naissance de l'apprenant.
     * @return la date de naissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Modifie la date de naissance de l'apprenant.
     * @param dateNaissance la nouvelle date de naissance
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}