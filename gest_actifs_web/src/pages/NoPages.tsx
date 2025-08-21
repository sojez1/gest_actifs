
import { useRouteError } from 'react-router-dom'

export default function NoPages(){
  const monErreur = useRouteError();
  return (
    <div>
        <h3>Erreur survenue sur la page. Ci-apres l'erreur:</h3>
        <p> {monErreur.data} <br />Type d'erreur: {monErreur.status} </p>
    </div>
  )
}
