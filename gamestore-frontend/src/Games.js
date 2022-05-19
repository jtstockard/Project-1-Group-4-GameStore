import { useState, useEffect } from "react";
import "./Card.css";
import GamesCard from "./GamesCard.js";
import GamesForm from "./GamesForm.js";

function Games() {
  const [games, setGames] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedCustomer, setScopedCustomer] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/games")
      .then((response) => response.json())
      .then((result) => setGames(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedCustomer({
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

  function notify({ action, games, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setGames([...games, games]);
        break;
      case "edit":
        setGames(
          games.map((e) => {
            if (e.id === games.id) {
              return games;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedCustomer(games);
        setShowForm(true);
        return;
      case "delete":
        setGames(games.filter((e) => e.id !== games.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <GamesForm games={scopedCustomer} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="customerTitle">Games</h1>
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
              <GamesCard key={r.customerId} games={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Games;
