
export default function AddMateriel() {
  
  
  
  return (
    <div>
        <h3>Ajout d'un nouveau materiel</h3>
        
        <div>
          <label>Code</label>
          <input type="text"/>
        </div>

        <div className="div">
          <label>Appelation</label>
          <input type="text"/>
        </div>

        <div>
          <label>Categorie</label>
          <select>
            <option>Informatique</option>
            <option>Vus</option>
          </select>
        </div>

        <div>
          <label>Unite compteur</label>
          <select>
            <option>Km</option>
            <option>Heure</option>
            <option>Autre</option>
          </select>
        </div>

        <button>Creer</button>

        

        


    </div>
  )
}
