⚔️ EPERS Online
=

Hace años, la desarrolladora de videojuegos **Spicy Games** desarrolló su famoso RPG llamado **EPERS Tactics**, reconocido por su gran sistema de combate que revivió al género de combate por turnos dentro del mercado. Tal fue el éxito del título, que grandes mentes del ámbito como Hideo Kojima, Markus Persson y hasta el excéntrico pero reservado Yoko Taro llenaron de elogios a la entrega.

Sin embargo, nuevas tecnologías surgen, y así también nuevos juegos. Tras nuestro periodo de adaptación en la empresa, se asigna a nuestro equipo desarrollar al sucesor de este gran juego insignia de la compañía: **EPERS Online**.

> _EPERS Online es un MMORPG no lineal donde el jugador podrá explorar un gran mundo abierto, mejorando su equipamiento en base a una economía decidida únicamente por los jugadores y forjando su propia leyenda tras cada inicio de sesión._
> ![world-img](https://github.com/francogarcino/deploy-template/blob/main/epers-online-wallpaper.jpg)

O al menos eso esperamos que sea, pero por ahora, solo es un MVP que se ve distante en el tiempo.

Sin embargo, y puramente con fines de marketing para este futuro Game of the Year, el líder de Spicy Games nos informa que se tomó la decisión de habilitar las precompras del juego lo antes posible, por lo que se nos encomendó nuestra primer misión dentro de este mundo: desarrollar una API que luego el equipo de DevOps presentara al público en coordinación con el frontend que se está desarrollando en simultáneo.

Adicionalmente, se nos brindan las siguientes aclaraciones y herramientas para el desarrollo:
- Dada la masivididad de datos esperados para el juego, se nos recomendo utilizar distintas bases de datos para el desarrollo, siendo estas:
    - Una base de datos relacional, para almacenar los datos basicos de los jugadores y gremios
    - Una base de datos orientada a grafos, pues se espera que en un futuro se puedan recorrer las relaciones entre jugadores de diversas maneras, pudiendo conectar con los amigos de tus amigos o compañeros de gremio
    - Una base de datos orientada a documentos, pues se espera que a futuro los gremios puedan darle mejoras a los items de sus miembros unicamente por pertenecer a la misma
- Nos otorgan los DTOs que usaran los usuarios para ver información de la API.
- Nos comentan brevemente cuales son los endpoints minimos que debemos implementar, siendo estos:

  - `epers-online/`
  - `epers-online/player/register/`
  - `epers-online/player/id/`
  - `epers-online/player/addFriend/playerId/friendId`
  - `epers-online/player/friends/id/`
  - `epers-online/inventory/addToPlayer/`
  - 