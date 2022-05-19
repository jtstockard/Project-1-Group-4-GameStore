import { useState, useEffect } from "react";
import "./Card.css";
import ConsoleCard from "./ConsolesCard.js";
import ConsolesForm from "./ConsolesForm.js";

function Consoles() {
  const [consoles, setConsoles] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [scopedCustomer, setScopedCustomer] = useState({});
  const [error, setError] = useState();

  useEffect(() => {
    fetch("http://localhost:8080/consoles")
      .then((response) => response.json())
      .then((result) => setConsoles(result))
      .catch(console.log);
  }, []);

  function addClick() {
    // const now = new Date();
    setScopedCustomer({
      id: 0,
      model: "",
      manufacturer: "",
      memoryAmount: "",
      processor: "",
      price: "",
      quantity: "",
    });
    setShowForm(true);
  }

  function notify({ action, consoles, error }) {
    if (error) {
      setError(error);
      setShowForm(false);
      return;
    }

    switch (action) {
      case "add":
        setConsoles([...consoles, consoles]);
        break;
      case "edit":
        setConsoles(
          consoles.map((e) => {
            if (e.id === consoles.id) {
              return consoles;
            }
            return e;
          })
        );
        break;
      case "edit-form":
        setScopedCustomer(consoles);
        setShowForm(true);
        return;
      case "delete":
        setConsoles(consoles.filter((e) => e.id !== consoles.id));
        break;
      default:
        console.log("You have entered an invalid choice! Try again!");
        break;
    }

    setError("");
    setShowForm(false);
  }

  if (showForm) {
    return <ConsolesForm consoles={scopedCustomer} notify={notify} />;
  }

  return (
    <>
      {error && <div className="alert alert-danger">{error}</div>}
      <div>
        <h1 id="customerTitle">Consoles</h1>
        <button className="btn btn-primary" type="button" onClick={addClick}>
          Add a Consoles
        </button>
        <table id="consoles">
          <tr>
            <th>model</th>
            <th>manufacturer</th>
            <th>memoryAmount</th>
            <th>processor</th>
            <th>price</th>
            <th>quantity</th>
          </tr>
          <tbody>
            {consoles.map((r) => (
              <ConsoleCard key={r.customerId} consoles={r} notify={notify} />
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Consoles;
