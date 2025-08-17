import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Dashbord from '../pages/Dashbord'
import AddMateriel from '../pages/AddMateriel'
import NoPages from '../pages/NoPages'




export default function MenuRoute() {
  return (
    <BrowserRouter>
    <Routes>
       <Route path='/' element={<Dashbord/>}/>
       <Route path='materiel' element={<AddMateriel/>}/>
       <Route path='*' element={<NoPages/>}/>

        
    </Routes>
    
    </BrowserRouter>
  )
}
