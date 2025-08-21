import React from 'react'

type maCategorie = {
    id: number,
    categorieAppelation: string,
    listeMateriels: any
}

type categoriemateriel = {
    categorie: maCategorie;
}


export default function CategorieRow({categorie}:categoriemateriel) {
  return (
    <tr key={categorie.id}>
        <td>{categorie.id}</td>
        <td>{categorie.categorieAppelation}</td>
        <td>
            <button className='btn btn-primary mx-2'>Afficher</button>
            <button className='btn btn-warning mx-2'>update</button>
            <button className='btn btn-danger '>delete</button>
        </td>
    </tr>
  )
}
