import React from 'react'

import type { Employes } from '../../constantes/TypeObjects'


type Employe = {
    employe: Employes
}

export default function EmployeRow({employe}:Employe) {
  return (
    <tr>
        <td>{employe.id}</td>
        <td>{employe.nom}</td>
        <td>{employe.prenom}</td>
        <td>{employe.matricule}</td>
        <td>{employe.isEmployeActif}</td>
        <td>{employe.telephone}</td>
        <td>{employe.email}</td>
        <td>{employe.isEmployeActif}</td>

        <td>
            <button className='btn btn-primary mx-2'>Afficher</button>
            <button className='btn btn-warning mx-2'>Modifier</button>
            <button className='btn btn-danger'>Supprimer</button>
        </td>
    </tr>
  )
}
