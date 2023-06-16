import React from "react";
import { useNavigate } from "react-router-dom";
import TablePlayer from "../../tables/views/TableView";
import '../Game.css';
import '../Eleccion.css';
import '../../tables/Tables.css';

export default function Player1VsPlayer2Finalizada() {
    let eleccionP1 = window.localStorage.getItem("eleccion P1");
    let eleccionP2 = window.localStorage.getItem("eleccion P2");
    let eleccionGanadora = window.localStorage.getItem("eleccion ganadora");

    const navigate = useNavigate()
    const goTo1PvsP2 = () => {
        window.localStorage.removeItem("eleccion P1");
        window.localStorage.removeItem("eleccion P2");
        window.localStorage.removeItem("eleccion ganadora");
        navigate(`/1Pvs2P`);
    }

    function elGanador() {
        if (eleccionGanadora === eleccionP1) {
            return <h3>El ganador es el player 1</h3>
        } else if (eleccionGanadora === eleccionP2) {
            return <h3>El ganador es el player 2</h3>
        }
    }

    return (
        <div>
            <div className="Game">
                <div className="TablaFinalizada">
                    <TablePlayer name={"Player 1"} contador={window.localStorage.getItem("contador P1")} />
                    <img className="Eleccion" src={eleccionP1} alt="Eleccion P1" />
                </div>
                <div className="TablaFinalizada">
                    <TablePlayer name={"Player 2"} contador={window.localStorage.getItem("contador P2")} />
                    <img className="Eleccion" src={eleccionP2} alt="Eleccion P2" />
                </div>
            </div>
            <div>
                {elGanador()}
                {eleccionGanadora ? <img className="EleccionGanadora" src={eleccionGanadora} alt="Eleccion ganadora" /> : <h3>EMPATE</h3>}
            </div>
            <button type="button" className="Button" onClick={goTo1PvsP2}>Volver a jugar</button>
        </div>
    )
}