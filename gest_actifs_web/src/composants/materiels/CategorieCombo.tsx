import React, { useState } from 'react'
import {domaineName} from 

export default function CategorieCombo() {
  
    const listCategorie = useState([]);
    return (
    <div>

        <label htmlFor='categorie'>Categorie</label>
        <select name='categorie' id='categorie'>
            {listCategorie.map(categorie -> 
                (<option></option>)}

        </select>

    </div>
  )
}
