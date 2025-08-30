import { useEffect, useState, type ChangeEvent } from "react"
import axios from 'axios';
import { useNavigate } from "react-router-dom";


import type { Materiel, Categories } from "../constantes/TypeObjects";
import { domaineName } from "../constantes/Prefixes";


const apiUrl_addMateriel = domaineName +  "/materiels/materiels";
const apiUrl_categorie = domaineName +"/materiels/categories";

export default function AddMateriel() {

  const navigate = useNavigate();

  const [listeCategorie, setlisteCategorie] = useState<Categories[]>([]);

  const [materielData, setmaterielData] = useState<Partial<Materiel>>({categorie:{categorieAppelation:"",listeMateriels:[],id:0}});

  
  const handleListeCategorie = async ()=>{
    const listecat = await axios.get(apiUrl_categorie);
    setlisteCategorie(listecat.data);
  }

  const handleFormDataChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>)=>{
    const {name, value} = e.target;
    setmaterielData(prev =>({
      ...prev, 
      [name]:value,
    }))

  }

  const handleCategorieChange = (e: ChangeEvent<HTMLSelectElement>)=>{
    const val = Number(e.target.value);
    const categorieSelected = listeCategorie.find(cat => cat.id === val)
    
    if(!categorieSelected) return;

    setmaterielData(prev =>({
      ...prev, 
      categorie: {
          ...(prev.categorie ?? {}),
          id:categorieSelected.id,
          categorieAppelation: categorieSelected.categorieAppelation
      }       
      
      })
    )

  };

  useEffect(()=>{
    handleListeCategorie();
  }, [])

  const saveMateriel = async (e: React.FormEvent)=>{
    e.preventDefault();
    //var formulaire = document.getElementById("newMateForm") as HTMLFormElement | null;
    //if(!formulaire) return;
    //const formdata = new FormData(formulaire);
    await axios.post(apiUrl_addMateriel, materielData);
    alert("Materiel bien enregistre");    
    navigate("/all_materiels");   

  }
  
  
  
  return (
    <div className="container mx-5">
        
        <h3>Ajout d'un nouveau materiel</h3>

        <form onSubmit={saveMateriel} id="newMateForm">
          <div className="form-group">
          <label>Code</label>
          <input className="form-control" type="text" id="interneCode" name="interneCode" value={materielData.interneCode ?? ""} onChange={handleFormDataChange} required/>
        </div>

        <div className="form-group">
          <label>Appelation</label>
          <input className="form-control" type="text" id="appelation" name="appelation" value={materielData.appelation ?? ""} onChange={handleFormDataChange}required/>
        </div>

        <div className="form-group">
          <label htmlFor="categorieSelecteur">Categorie</label>
          <select className="form-control" id="categorieSelecteur" value={materielData.categorie?.id ?? 0} onChange={handleCategorieChange} required>
            <option value="">-- Please choose one categorie --</option>
            {listeCategorie.map((cat) =>
              <option value={cat.id} key={cat.id}>{cat.categorieAppelation}</option>
            )}
          </select>
        </div>

        
        <button className="btn btn-primary" type="submit">Creer</button>

        </form>
        
        

        

        


    </div>
  )
}
