import { createBrowserRouter } from "react-router-dom";
import BarMenu from "./BarMenu";
import NoPages from "../pages/NoPages";
import Dashbord from "../pages/Dashbord";
import AddMateriel from "../pages/AddMateriel";
import AllMateriels from "../pages/AllMateriels";
import SaisieCompteurs from "../pages/SaisieCompteurs";
import AddCategorie from "../pages/AddCategorie";
import Categories from "../pages/Categories";
import AllEmployes from "../pages/AllEmployes";
import LoginPage from "../pages/connexion/LoginPage";
import AddEmploye from "../pages/AddEmploye";

export const  router = createBrowserRouter([
  {
    path: '/',
    element: <BarMenu/>,
    errorElement: <NoPages/>,
    children: [
      {path:'/', element: <LoginPage/> },

     {path:'dashbord', element: <Dashbord/> },

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
        path:'newEmploye',
        element: <AddEmploye />
        },
        {
        path:'all_employes',
        element: <AllEmployes />
        },
        {
        path:'loginPage',
        element: <LoginPage />
        }

      

      
      
    ]
  }
]);