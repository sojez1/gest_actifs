import { createBrowserRouter } from "react-router-dom";
import BarMenu from "./BarMenu";
import NoPages from "../pages/NoPages";
import Dashbord from "../pages/Dashbord";
import AddMateriel from "../pages/AddMateriel";
import AllMateriels from "../pages/AllMateriels";
import SaisieCompteurs from "../pages/SaisieCompteurs";
import AddCategorie from "../pages/AddCategorie";
import Categories from "../pages/Categories";

export const  router = createBrowserRouter([
  {
    path: '/',
    element: <BarMenu/>,
    errorElement: <NoPages/>,
    children: [
      {path:'/', element: <Dashbord/> },

      {path:'all_materiels',element: <AllMateriels /> },

      {
        path:'categories',
        element: <Categories />
        },
        {
        path:'saisieCompteur',
        element: <SaisieCompteurs />
        },

        {
        path:'newMateriel',
        element: <AddMateriel />
        },
        {
        path:'newCategorie',
        element: <AddCategorie />
        },

      {
        path: 'materiels',
        element: <AllMateriels/>,
        children:[
            {
                path:'',
                element: <AllMateriels />
            },
            {
                path:'all_materiels',
                element: <AllMateriels />
            },
            {
                path:'add_materiel',
                element: <AddMateriel />
            },
            {
                path:'categorie',
                element:<Categories/>
            }      
            
        ] // fin children pour routes materiel 

      } // fin routes pour materiels

      
      
    ]
  }
]);