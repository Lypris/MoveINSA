# MoveINSA - Gestion de la Mobilité des Étudiants INSA

## Description du projet

MoveINSA est une application web destinée à faciliter la gestion de la mobilité internationale des étudiants de l'INSA de Strasbourg. L'objectif est de centraliser la gestion des offres de mobilité, les candidatures des étudiants, et les affectations des candidats selon leur score. Le projet intègre une interface intuitive permettant de visualiser les établissements partenaires sur une carte interactive Google Maps et de gérer les différentes étapes du processus de mobilité.

### Fonctionnalités principales

- **Visualisation des établissements partenaires** :
  - Affichage des établissements partenaires sur une carte interactive Google Maps.
  - Filtrage des établissements par pays, type de dispositif (Erasmus, Double-Diplôme, Hors-Erasmus) et spécialité.
  
- **Gestion des offres de mobilité** :
  - Affichage de toutes les offres de mobilité disponibles, triables par établissement, semestre et spécialité.
  - Création, modification et suppression des offres.

- **Gestion des étudiants et des candidatures** :
  - Enregistrement des étudiants candidats et gestion de leurs candidatures.
  - Attribution des offres de mobilité en fonction du score des étudiants.
  - Visualisation de l’historique des mobilités.

- **Statistiques sur la mobilité** :
  - Génération de statistiques sur les candidatures et les offres de mobilité (actuelles et historiques).
  - Visualisation de l'évolution de la mobilité au sein de l'INSA sur plusieurs années.

## Prérequis

- Java 23+
- Vaadin 24+
- MySQL
- Clé API Google Maps (pour la carte interactive)

## Installation

1. Clonez le dépôt du projet :
   ```bash
   git clone https://github.com/Lypris/MoveINSA.git
   cd moveinsa
