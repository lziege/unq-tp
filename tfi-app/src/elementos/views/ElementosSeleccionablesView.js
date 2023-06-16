import React from "react";
import Piedra from "../../assets/Piedra.png";
import Tijera from "../../assets/Tijera.png";
import Papel from "../../assets/Papel.png";
import Spock from "../../assets/Spock.png";
import Lagarto from "../../assets/Lagarto.png";
import '../Elemento.css';

export default function ElementosView({ nroPlayer }) {

    function eleccion(elemento) {
        window.localStorage.setItem("eleccion P" + nroPlayer, elemento);
        window.location.reload();
    }

    return (
        <div className="Elementos">
            <div>
                <img className="ElementoSeleccionable" src={Piedra} alt="Piedra" onClick={() => eleccion(Piedra)} />
                <img className="ElementoSeleccionable" src={Tijera} alt="Tijera" onClick={() => eleccion(Tijera)} />
                <img className="ElementoSeleccionable" src={Papel} alt="Papel" onClick={() => eleccion(Papel)} />
            </div>
            <div>
                <img className="ElementoSeleccionable" src={Spock} alt="Spock" onClick={() => eleccion(Spock)} />
                <img className="ElementoSeleccionable" src={Lagarto} alt="Lagarto" onClick={() => eleccion(Lagarto)} />
            </div>
        </div>
    )
}