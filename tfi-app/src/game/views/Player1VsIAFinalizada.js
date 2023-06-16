import React from "react";
import { useNavigate } from "react-router-dom";
import TablePlayer from "../../tables/views/TableView";
import '../Game.css';
import '../Eleccion.css';
import '../../tables/Tables.css';

export default function Player1VsIAFinalizada() {
    let eleccionPlayer = window.localStorage.getItem("eleccion P1");
    let eleccionIA = window.localStorage.getItem("eleccion IA");
    let eleccionGanadora = window.localStorage.getItem("eleccion ganadora");

    const navigate = useNavigate()
    const goTo1PvsIA = () => {
        window.localStorage.removeItem("eleccion P1");
        window.localStorage.removeItem("eleccion IA");
        window.localStorage.removeItem("eleccion ganadora");
        navigate(`/1PvsIA`);
    }

    function elGanador() {
        if (eleccionGanadora === eleccionPlayer) {
            return <h3>El ganador es el player 1</h3>
        } else if (eleccionGanadora === eleccionIA) {
            return <h3>El ganador es la IA</h3>
        }
    }

    return (
        <div>
            <div className="Game">
                <div className="TablaFinalizada">
                    <TablePlayer name={"Player 1"} contador={window.localStorage.getItem("contador P1")} />
                    <img className="Eleccion" src={eleccionPlayer} alt="Eleccion P1" />
                </div>
                <div className="TablaFinalizada">
                    <TablePlayer name={"IA"} contador={window.localStorage.getItem("contador IA")} />
                    <img className="Eleccion" src={eleccionIA} alt="Eleccion IA" />
                </div>
            </div>
            <div>
                {elGanador()}
                {eleccionGanadora ? <img className="EleccionGanadora" src={eleccionGanadora} alt="Eleccion ganadora" /> : <h3>EMPATE</h3> }
            </div>
            <button type="button" className="Button" onClick={goTo1PvsIA}>Volver a jugar</button>
        </div>
    )
}