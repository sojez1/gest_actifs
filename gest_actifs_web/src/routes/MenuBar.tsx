import React from 'react'
import {Outlet, Link } from 'react-router-dom'

export default function MenuBar() {
  return (
    <div>
      <nav >
        <ol>
            <li><Link to="/">Dashbord</Link></li>

            <li><Link to="materiel">Ajouter Materiel</Link></li>

            <li>Employes</li>

            <li>Signaler une panne</li>

            <li>Maintenance</li>

            <li>Connexion</li>
        </ol>

    </nav>
    <Outlet/>
    </div>
  )
}
