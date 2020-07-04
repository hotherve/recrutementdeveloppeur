# Test Recrutement Développeur

commandes utilisées pour angular :

ng new recrutement-front --style=scss --skip-tests=true --routing
cd recrutement-front
npm install --save bootstrap jquery
npm install --save popper.js@^1.16
cd src/app
ng g s salle-event
ng g c salle-event-list
ng g c salle-event-details

## Introduction

Ce projet est un projet fictif utilisé comme test pour le recrutement d'un développeur pour le SCLI DCS de l'OCSIN


## Présentation de l'application

L'objectif de l'application à développer est de permettre à des utilisateurs de consulter le statut d'occupation des salles d'un bâtiment.
On considèrera que chaque salle est équipée d'un capteur de présence intelligent capable de communiquer en HTTP avec l'application. 
L'application reçoit les informations issues des capteurs et présente le statut de chaque salle (libre ou occupée) aux utilisateurs.


### Capteurs

La gestion des capteurs est hors du périmètre de ce projet. On considèrera ici qu'ils sont capables d'envoyer deux types de messages :
- Lorsqu'un mouvement a été détecté (```motion:on```)
- Lorsqu'aucune mouvement n'a été détecté depuis 30 secondes (```motion:off```)

Les messages ont la structure suivante :
- Heure de l'événement
- Type d'événement (```motion:on``` ou ```motion:off```)
- Identifiant de la salle

Pour simuler les capteurs, on pourra envoyer des messages à l'application avec un utilitaire de type ```curl```. 

Les messages pourront avoir le format suivant :

```
{
	"time": "2019-07-10T16:24:32",
	"event": "motion:on",
	"room_id": "1"
}
```
```
{
	"time": "2019-07-10T16:54:32",
	"event": "motion:off",
	"room_id": "1"
}
```


## Travail attendu

Un backlog minimaliste, avec des users stories a été créé dans le projet gitlab (voir [Issues](https://gitlab.com/wjkw/recrutementdeveloppeur/issues)).
L'objectif du test est d'implémenter les issues #1 et #2.
Chaque issue possède une valeur métier stockée dans le champ "Weight".


## Critères d'évaluations

- **Il n'est pas nécessaire d'implémenter toutes les user stories pour réussir le test**
- Il n'est pas nécessaire d'avoir une application qui fonctionne, seul le code est évalué
- La qualité du code. Ce sera le principal élément évalué. L'objectif est de démontrer votre capacité à produire du code de "qualité entreprise". 
    - conformité avec les user stories
    - maintenabilité
    - exploitabilité
    - clarté
    - fiabilité
    - facilité pour un autre utilisateur de reprendre le code
    - industrialisation
    - bonne utilisation de git
- La maximisation de la valeur métier délivrée


### Conseil

Afin de démontrer vos capacités à travailler sur des projets, veillez à travailler comme dans un vrai sprint d'un vrai projet avec d'autres développeurs : sur une user story à la fois, idéalement avec une branche par user story, en commentant vos commits etc. 

Derrière chacun des critères d'évaluation listés ci-dessus se trouve un ensemble de bonnes pratiques qui seront attendues dans vos livrables. 

Par exemple, pour "exploitabilité", on s'attend à ce que l'application puisse être facilement déployée et paramétrée, qu'elle fournisse des logs précis permettant facilement de diagnostiquer les erreurs qui pourraient survenir.


## Exigences non fonctionnelles

Stack : Angular, SCSS, Spring boot, Maven


## Comment participer au test

- Authentifiez vous sur gitlab.com
- Forkez le projet https://gitlab.com/wjkw/recrutementdeveloppeur dans votre namespace
- Dans "Settings / general / Visibility, project features, permissions", choisissez la visibilité "Private"
- Dans "Members", ajoutez @wjkw comme "Developer"
- Pushez votre code dans votre projet forké
- Pensez à ce que votre nom soit visible soit dans le nom du projet, soit dans le README


## Comment poser des questions / obtenir de l'aide

Vous pouvez directement ouvrir des [issues](https://gitlab.com/wjkw/recrutementdeveloppeur/issues) dans le projet [wjkw/recrutementdeveloppeur](https://gitlab.com/wjkw/recrutementdeveloppeur). Les réponses seront ainsi visibles par tous.
