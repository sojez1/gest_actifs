import React, { useState, type ChangeEvent } from 'react'


import type { Employes, RolesEmploye } from '../constantes/TypeObjects'
import { useNavigate } from 'react-router-dom'
import { domaineName } from '../constantes/Prefixes'
import axios from 'axios';
import { token } from '../constantes/Securite';

const apiUri_saveEmploye = domaineName + "/employes/newEmploye";

export default function AddEmploye() {
    const navigate = useNavigate();
    const [employeData, setemployeData] = useState<Partial<Employes>>({})
    

    const handleEmployeChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>)=>{
        const {name, value} = e.target
        setemployeData(prev =>(
            {...prev,
                [name]: value
            }
            
        ))
    }

const handleRoleChange = (e: ChangeEvent<HTMLSelectElement>)=>{
    const roleSelected = Array.from(e.target.selectedOptions, (option)=>option.value as RolesEmploye);

    setemployeData(prev =>(
        {...prev.role,
            role:roleSelected
        }
        
    ))

}

const saveEmploye = async (e:React.FormEvent)=>{
    e.preventDefault();
    await axios.post(apiUri_saveEmploye,employeData,{
        headers:{
            Authorization: `Bearer ${token}` 
        }
    });
    alert("EMploye bien enregistre");
    navigate("/all_employes");

}

  return (
    <div>
        <form onSubmit={saveEmploye}>
            <div className='container my-5'>
                <div className='form-group'>
                    <label htmlFor='nom'>Nom</label>
                    <input className='form-control' type='text' id='nom' name='nom' value={employeData.nom ?? ""} onChange={handleEmployeChange}/>
                </div>

                <div className='form-group'>
                    <label htmlFor='prenom'>Prenoms</label>
                    <input className='form-control' type='text' id='prenom' name='prenom' value={employeData.prenom ?? ""} onChange={handleEmployeChange}/>
                </div>

                <div>
                    <label htmlFor='matricule'>Matricule</label>
                    <input className='form-control' id='matricule' name='matricule' value={employeData.matricule ?? ""} onChange={handleEmployeChange}/>
                </div>

                <div>
                    <label htmlFor='roles'>Roles</label>
                    <select className='custom-select' multiple  id="roles" value={employeData.role} onChange={handleRoleChange}>
                        {employeData.role?.map(role =>
                            <option key={role} value={role}>{role}</option>
                        )}
                    </select>
                </div>

                <div>
                    <label htmlFor='email'>Email</label>
                    <input className='form-control' type='email' id='email' name='email' value={employeData.email ?? ""} onChange={handleEmployeChange}/>
                </div>

                <div>
                    <label htmlFor='telephone'>Telephone</label>
                    <input className='form-control' type='tel' name='telephone' id='telephone' value={employeData.telephone ?? ""} onChange={handleEmployeChange}/>
                </div>

                <div className='form-group'>
                    <button className='btn btn-primary' type='submit'>Enregistrer</button>
                </div>

                

            </div>
        </form>
    </div>
  )
}
