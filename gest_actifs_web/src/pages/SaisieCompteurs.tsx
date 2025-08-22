import React, { useState } from 'react'

export default function SaisieCompteurs() {
  
    const [materiel, setmateriel] = useState({});

    const handleMaterielChange = ()=>{

        // find materiel by code


        setmateriel({});

    }

    const saveReleveCompteur = (e: React.FormEvent)=>{
        e.preventDefault();
        
    }
  
    return (
    <div className='container mx-4'>
        <h3> Saisie valeur du compteur d'un materiel</h3>
        
        <form onSubmit={saveReleveCompteur}>

            <div >
            
            <div className='form-group'>
                <label>Materiel</label>
                <input className="form-control" type='text'onBlur={handleMaterielChange} required/>
            </div>
            

            <div className='form-group'>
                <label>valeur compteur</label>
                <input className="form-control" type='number' required/>
            </div>

            <div className='form-group'>
                <label>unite</label>

            </div> 

            <button type='submit' className='btn btn-primary'>Enregistrer</button>

        </div>

        </form>
        
        
    </div>
  )
}
