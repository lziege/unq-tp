import React from "react";
import Piedra from "../../assets/Piedra.png";
import Tijera from "../../assets/Tijera.png";
import Papel from "../../assets/Papel.png";
import Spock from "../../assets/Spock.png";
import Lagarto from "../../assets/Lagarto.png";
import '../Elemento.css';

export default function ElementosView() {
    return (
        <div className="Elementos">
            <div>
                <img className="Elemento" src={Piedra} alt="Piedra" />
                <img className="Elemento" src={Tijera} alt="Tijera" />
                <img className="Elemento" src={Papel} alt="Papel" />
            </div>
            <div>
                <img className="Elemento" src={Spock} alt="Spock" />
                <img className="Elemento" src={Lagarto} alt="Lagarto" />
            </div>
        </div>
    )
}