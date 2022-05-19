import { useState, useEffect } from "react";

import GamesCard from "./GamesCard.js";
import GamesForm from "./GamesForm.js";

function Games() {
  const [games, setGames] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedGames, setScopedGames] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/games")
      .then((response) => response.json())
      .then((result) => setGames(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedGames({
      id: 0,
      title: "",
      esrbRating: "",
      description: "",
      price: "",
      studio: "",
      quantity: "",
    });
    setShowForm(true);
  }

  function notify({ action, games: gamesAdd, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setGames([...gamesAdd, games]);
        break;
      case "edit":
        setGames(
          games.map((e) => {
            if (e.id === gamesAdd.id) {
              return games;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedGames(gamesAdd);
        setShowForm(true);
        return;
      case "delete":
        setGames(games.filter((e) => e.id !== gamesAdd.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <GamesForm games={scopedGames} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="gamesTitle">Games</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Add a Games
        </button>
        <table id="games">
          <tr>
            <th>title</th>
            <th>esrbRating</th>
            <th>description</th>
            <th>price</th>
            <th>studio</th>
            <th>quantity</th>
          </tr>
          <tbody>
            {games.map((r) => (
              <GamesCard key={r.id} games={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Games;
