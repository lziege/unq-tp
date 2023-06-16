import React from "react";
import '../Tables.css';

export default function TableView({ name, contador }) {
    return (
        <table className="TablePlayer">
            <thead>
                <tr>
                    <th>{name}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{contador}</td>
                </tr>
            </tbody>
        </table>
    )
}