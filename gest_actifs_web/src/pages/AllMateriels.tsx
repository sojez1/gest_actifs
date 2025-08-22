import React, { useEffect, useState } from 'react'

import type { Materiel } from '../constantes/TypeObjects'
import { MaterielRow } from '../composants/materiels/MaterielRow'
import axios from 'axios';

const apiUrl_materiel: string = "http://localhost:8095/materiels/materiels";

export default function AllMateriels() {
  
  const [listeMateriel, setlisteMateriel] = useState<Materiel[]>([]);

  const getAllMateriel = async ()=>{
    const mat = await axios.get(apiUrl_materiel);
    setlisteMateriel(mat.data);
  }

  useEffect(()=>{
    getAllMateriel();
     
  }, [])

  
  return (
    <div>
        <h3>Liste de tous les materiels</h3>
        <table className='table table-hover'>
          <thead className='thead'>
            <tr>
              <th>id</th>
              <th>Code</th>
              <th>Appelation</th>
              <th>Categorie</th>
              <th>date enreg</th>
            </tr>

          </thead>
          <tbody>
            {listeMateriel.map(mate =>
              <MaterielRow materiel={mate} key={mate.id}/>
            )}
          </tbody>

        </table>
    </div>
  )
}
