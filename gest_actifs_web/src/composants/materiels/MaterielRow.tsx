import React from 'react'

import type { Materiel } from '../../constantes/TypeObjects'

type Materiels = {
  materiel: Materiel
}

export const MaterielRow = ({materiel}:Materiels) => {
  
    return (
    <tr>
      <td>{materiel.id}</td>
      <td>{materiel.interneCode}</td>
      <td>{materiel.appelation}</td>
      <td>{materiel.categorie?.categorieAppelation ?? ""}</td>      
      <td>{materiel.saveAt}</td>
      <td>
        <button className='btn btn-primary mx-2'>Update</button>
        <button className='btn btn-danger mx-2'>delete</button>
      </td>

    </tr>
    )
}
