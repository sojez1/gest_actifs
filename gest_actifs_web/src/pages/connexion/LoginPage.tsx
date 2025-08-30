import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const loginApi:string = "http://localhost:8095/employes/login"

export default function LoginPage() {

    let navigate = useNavigate();

    const [username, setusername] = useState<string>("");
    const [password, setpassword] = useState("");
    const [success, setsuccess] = useState<boolean>(false)
    const [loading, setloading] = useState<boolean>(false)
    const [error, seterror] = useState<String | null>(null)

const AuthValidation = async (e: React.FormEvent)=>{
    e.preventDefault();
    setloading(true);
    seterror(null);
    setsuccess(false);

    try{
        const result = await axios.post(loginApi, {username, password});
        setsuccess(true);
        if(result.data.token){
            localStorage.setItem("authToken", result.data.token)
        }
        navigate("/dashbord")

    }catch(err: any){
        seterror(err.response?.data?.message || "Echec de l'authentification");

    }
    finally{
        setloading(false);
    }
    
}

  return (
    <div>
        <h3>Authentification</h3>

        <form className='form-group' onSubmit={AuthValidation}>
            <label>Email</label>
            <input className='form-control' type='text' name='Email' id='Email' value={username} onChange={(e) => setusername(e.target.value)} required/>

            <label>Mot de passe</label>
            <input className='form-control' type='password' name='password' id='password' value={password} onChange={e => setpassword(e.target.value)} required/>

            <button className='btn btn-primary' type='submit'>{loading?"connexion ...":"Valider"}</button>
        </form>

        {success && <p className='text-success mt-2'>Connexion reussie</p>}

        {error && <p className='text-danger mt-2'>{error}</p>}
    </div>
  )
}
