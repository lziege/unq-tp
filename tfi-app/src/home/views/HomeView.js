import React from "react";
import { useNavigate } from "react-router-dom";

export default function HomeView() {
    const navigate = useNavigate()
    const goTo1PvsIA = () => {
        window.localStorage.setItem("contador P1", 0);
        window.localStorage.setItem("contador IA", 0);
        window.localStorage.removeItem("eleccion P1");
        window.localStorage.removeItem("eleccion IA");
        window.localStorage.removeItem("eleccion ganadora");
        navigate(`/1PvsIA`);
    }

    const goTo1Pvs2P = () => {
        window.localStorage.setItem("contador P1", 0);
        window.localStorage.setItem("contador P2", 0);
        window.localStorage.removeItem("eleccion P1");
        window.localStorage.removeItem("eleccion P2");
        window.localStorage.removeItem("eleccion ganadora");
        navigate(`/1Pvs2P`);
    }

    const goToReglas = () => {
        navigate(`/ReglasDelJuego`);
    }

    return (
        <div>
            <div>
                <button type="button" className="Button" onClick={goTo1PvsIA}>1P VS IA</button>
            </div>
            <div>
                <button type="button" className="Button" onClick={goTo1Pvs2P}>1P VS 2P</button>
            </div>
            <div>
                <button type="button" className="Button" onClick={goToReglas}>REGLAS DEL JUEGO</button>
            </div>
        </div>
    )
}