import React from "react";
import { useNavigate } from "react-router-dom";
import Player from "./PlayerView";
import ModificadorDeContadores from "../components/ModificadorDeContadores";
import Elementos from "../../elementos/views/ElementosView";
import ElementosSeleccionables from "../../elementos/views/ElementosSeleccionablesView";
import '../Game.css';

export default function Player1VsPlayer2() {
    let eleccionP1 = window.localStorage.getItem("eleccion P1");
    let eleccionP2 = window.localStorage.getItem("eleccion P2");
    var contadorP1 = window.localStorage.getItem("contador P1");
    var contadorP2 = window.localStorage.getItem("contador P2");

    const navigate = useNavigate()
    const goTo1Pvs2PFinalizada = () => {
        ModificadorDeContadores.aumentarContadorSiCorresponde(
            eleccionP1, eleccionP2, "contador P2", contadorP1, contadorP2);
        navigate(`/1Pvs2P/PartidaFinalizada`);
    }

    return (
        <div>
            <div className="Game">
                {eleccionP1 ? <Player nroPlayer={1} elementosAMostrar={<Elementos />} /> 
                            : <Player nroPlayer={1} elementosAMostrar={<ElementosSeleccionables nroPlayer={1} />} /> }
                {eleccionP2 ? <Player nroPlayer={2} elementosAMostrar={<Elementos />} /> 
                            : <Player nroPlayer={2} elementosAMostrar={<ElementosSeleccionables nroPlayer={2} />} /> }
            </div>
            <div>
                {eleccionP1 && eleccionP2 ? <button type="button" className="Button" onClick={goTo1Pvs2PFinalizada}>Jugar partida</button> : null}
            </div>
            <button type="button" className="Button" onClick={() => ModificadorDeContadores.reiniciarContadores("contador P2")}>Reiniciar contadores</button>
        </div>
    )
}