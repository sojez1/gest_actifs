import React, { useEffect, useState } from 'react'

import { domaineName } from '../constantes/Prefixes';
import type { Employes } from '../constantes/TypeObjects';
import EmployeRow from '../composants/employes/EmployeRow';
import axios from 'axios';
import { token } from '../constantes/Securite';

const apiUrl_employe = domaineName+"/employes/all_employes";

export default function AllEmployes() {

    const [listeEmployes, setlisteEmployes] = useState<Employes[]>([]);

    const handleListeEmployes = async ()=>{
        const donnees = await axios.get(apiUrl_employe, {
            headers:{
                        Authorization: `Bearer ${token}` 
                    }
        });
        setlisteEmployes(donnees.data);
    }

    useEffect(()=>{
        handleListeEmployes();

    },[])


   

  return (
    listeEmployes.length>0 &&
    <div>
        <h3 className='position-center'>Liste des employes<br/></h3>
        <table className='table table-hover'>
            <thead className='thead'>
                <tr>
                    <th>code</th>
                    <th>Nom</th>
                    <th>Prenoms</th>
                    <th>Matricule</th>
                    <th>Roles</th>
                    <th>Telephone</th>
                    <th>Email</th>
                    <th>Statut</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {listeEmployes.map(employ => <EmployeRow employe={employ} key={employ.id}/>)}

            </tbody>
        </table>
    </div>
  )
}
