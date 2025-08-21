import React, { useState } from 'react'

export default function SaisieCompteurs() {
  
    const [materiel, setmateriel] = useState({});

    const handleMaterielChange = ()=>{

        // find materiel by code


        setmateriel({});

    }

    const saveReleveCompteur = ()=>{
        
    }
  
    return (
    <div>
        <h3> Saisie valeur du compteur d'un materiel</h3>
        <div className='container'>
            <label>Materiel</label>
            <input type='text'onBlur={handleMaterielChange}/>

            <label>valeur compteur</label>
            <input type='number'/>
            <label>unite</label>

            <button>Enregistrer</button>

        </div>
    </div>
  )
}
