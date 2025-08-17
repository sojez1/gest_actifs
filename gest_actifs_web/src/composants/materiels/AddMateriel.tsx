import React from 'react'
import Inputtxt from '../general/Inputtxt'

export default function AddMateriel() {
  
  
    
    const handleClic = ()=>{

    }
    
    
    return (
    <div>
        <form>
            <Inputtxt code/>
            <Inputtxt Appelation/>
            <button type="submit" onClik={handleClic}>Soumettre</button>

        </form>
    </div>
  )
}
