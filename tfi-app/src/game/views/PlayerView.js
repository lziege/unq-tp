import React from "react";
import TablePlayer from "../../tables/views/TableView";
import '../Game.css';

export default function PlayerView({ nroPlayer, elementosAMostrar }) {
    return (
        <div className="Player">
            <TablePlayer name={"Player " + nroPlayer} contador={window.localStorage.getItem("contador P" + nroPlayer)} />
            {elementosAMostrar}
        </div>
    )
}