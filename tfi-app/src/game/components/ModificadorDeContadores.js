import Piedra from "../../assets/Piedra.png";
import Tijera from "../../assets/Tijera.png";
import Papel from "../../assets/Papel.png";
import Spock from "../../assets/Spock.png";
import Lagarto from "../../assets/Lagarto.png";

function leGana(eleccion1, eleccion2) {
    return ((eleccion1 === Tijera && (eleccion2 === Papel || eleccion2 === Lagarto))
        ||
        (eleccion1 === Papel && (eleccion2 === Piedra || eleccion2 === Spock))
        ||
        (eleccion1 === Piedra && (eleccion2 === Lagarto || eleccion2 === Tijera))
        ||
        (eleccion1 === Lagarto && (eleccion2 === Spock || eleccion2 === Papel))
        ||
        (eleccion1 === Spock && (eleccion2 === Tijera || eleccion2 === Piedra)))
}

const aumentarContadorSiCorresponde = (eleccion1, eleccion2, contador2, valorContador1, valorContador2) => {
    if (leGana(eleccion1, eleccion2)) {
        valorContador1++;
        window.localStorage.setItem("contador P1", valorContador1);
        window.localStorage.setItem("eleccion ganadora", eleccion1);
    } else if (leGana(eleccion2, eleccion1)) {
        valorContador2++;
        window.localStorage.setItem(contador2, valorContador2);
        window.localStorage.setItem("eleccion ganadora", eleccion2);
    }
}

const reiniciarContadores = (tipoContador2) => {
    window.localStorage.setItem("contador P1", 0);
    window.localStorage.setItem(tipoContador2, 0);
    window.location.reload();
}

// eslint-disable-next-line import/no-anonymous-default-export
export default {
    aumentarContadorSiCorresponde,
    reiniciarContadores,
}