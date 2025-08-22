import React, { useEffect, useState }from 'react'
import CategorieRow from '../composants/materiels/CategorieRow'
import {domaineName} from "../constantes/Prefixes";
import axios from 'axios';
import type { Categories } from '../constantes/TypeObjects';


const apiUrl:string = domaineName+"/materiels/categories";

export default function Categories() {

    const [listeCategorie, setlisteCategorie] = useState<Categories[]>([]);
    
    const loadcategories = async ()=>{
        const donnees = await axios.get(apiUrl,{
            auth:{
            username:'user',
            password:'123456'
            }
        });
        console.log(donnees.data)
        setlisteCategorie(donnees.data);        
    }

    useEffect(()=>{
        loadcategories();

    }, []);
    

  return (
    <div>
        
        <table className='table table-boarder table-shadow table-hover'>
            <thead className='thead'>
                <tr>
                    <td>code</td>
                    <td>libelle</td>
                    <td>Actions</td>
                </tr>
                
            </thead>
            <tbody>
                {
                    listeCategorie.map(varCategorie => <CategorieRow categorie ={varCategorie} key={varCategorie.id}/>)
                }

            </tbody>
        </table>
    </div>
  )
}
