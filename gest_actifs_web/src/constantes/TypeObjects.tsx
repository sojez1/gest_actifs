import { allEmployeRole } from "./Prefixes"

export type BreakdownReport = {
  
}

export type Compteurs = {
    id: number,
    materiel: Materiel,
    units: "km" | "heures" | "Autres",
    isActif: boolean,
    listeReleves: RelevesCompteurs[]

}

export type RelevesCompteurs = {

}

export type Materiel = {
  id: number,
  interneCode: string,
  appelation: string,
  categorie: Categories,
  listeCompteurs: Compteurs[],
  saveAt: string,
  listeBreakdownReport: BreakdownReport[]
}

export type Categories = {
    id?: number,
    categorieAppelation: string,
    listeMateriels?: Materiel[]
}

export type Employes = {
    id: number,
    matricule: string,
    nom: string,
    prenom: string,
    email: string,
    telephone: string,
    hireDate: string,
    isEmployeActif:boolean,
    role?: RolesEmploye[]
}

export type RolesEmploye = typeof allEmployeRole[number];
