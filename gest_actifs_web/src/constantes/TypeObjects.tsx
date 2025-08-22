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