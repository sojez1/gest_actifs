import { NavLink, Outlet } from "react-router-dom";


export default function BarMenu(){
  return <>  
    
    <header className="fixed-top">
        <nav>
            <ul className="nav ">
                <li className="nav-item"><NavLink to="/" className="nav-link">Dashbord</NavLink></li>

                <li className="nav-item"><NavLink to="/categories" className="nav-link">Categorie</NavLink></li>

                <li className="nav-item"><NavLink to="/saisieCompteur" className="nav-link">Releves Compteur</NavLink></li>

                <li className="nav-item"><NavLink to="/newMateriel" className="nav-link">Nouveau materiel</NavLink></li>

                

                <li className="nav-dropdown">
                    <NavLink to="/materiels" className="nav-link dropdown-toggle" data-toggle="dropdown" aria-expanded="false" id="sousMenuMateriel">Materiel</NavLink>

                    <ul className="dropdown-menu" aria-labelledby="sousMenuMateriel">
                        <li className="dropdown-item"><NavLink to="materiels/categorie">Categories</NavLink></li>
                        <NavLink to="materiels/all_materiels" className="dropdown-item">Liste des Materiels</NavLink>
                        <li><NavLink to="materiels/add_materiel" className="dropdown-item">Ajouter un materiel</NavLink></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>

    <div><Outlet/></div>

  </>
}