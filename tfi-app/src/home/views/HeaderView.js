import React from "react";
import { useNavigate } from "react-router-dom";
import Titulo from "../../assets/Titulo.png";

export default function HeaderView() {
    const navigate = useNavigate()
    const goToHome = () => {
        navigate(`/`)
    }

    return (
        <div style={{display:"flex"}}>
            <button type="button" className="Button" style={{width:"30%"}} onClick={goToHome}>IR AL MENU PRINCIPAL</button>
            <img className="Titulo" src={Titulo} alt="Titulo" style={{width:"65%"}} />
        </div>
    )
}